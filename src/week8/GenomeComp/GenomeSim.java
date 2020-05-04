package week8.GenomeComp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class GenomeSim {
//    private static Scanner sc = new Scanner(System.in);

static final int[][] geneScorePair = {{10, -5, 0, -5}, {-5, 10, -5, 0}, {0, -5, 10, -5}, {-5, 0, -5, 10}};


public static String DNA_A = "GAATC"; //columns
public static String DNA_B = "AATTC"; //rows
//public static String DNA_B = "CATAC"; //rows

public static void main(String[] args) {
////      get 2 strings
//    DNA_A=sc.nextLine();
//    DNA_B=sc.nextLine();
    
    // create dot plot matrix
    int[][] dotPlot;
    byte[][] dotLink;
    
    int tableHorizonLength = DNA_A.length() + 1;
    int tableVerticalLength = DNA_B.length() + 1;
    
    dotPlot = new int[tableVerticalLength][tableHorizonLength];
    dotLink = new byte[tableVerticalLength][tableHorizonLength];
    
    
    for (int[] line : dotPlot) {
        Arrays.fill(line, Integer.MIN_VALUE);
    }
    
    dotPlot[0][0] = 0;
    
    // numerical gene arrays
    short[] geneA = geneToArray(DNA_A);
    short[] geneB = geneToArray(DNA_B);


/*
    3 possibilities for every route(box).

    route1: go right   (Null assigned to gene A) -4    G-
    route2: go down    (Null assigned to gene B) -4    -A
    route3: go diag(exact match) according to matrix
*/
    
    
    int i = 0, j = 0;
//      initialize 0th row (left to right)
    
    for (int k = j + 1; k < tableHorizonLength; k++) {
        dotPlot[i][k] = Math.max(dotPlot[i][k - 1] - 4, dotPlot[i][k]);
        dotLink[i][k] += 0b1;
    }


//      initialize 0th col (up to down)
    for (int k = i + 1; k < tableVerticalLength; k++) {
        dotPlot[k][j] = Math.max(dotPlot[k - 1][j] - 4, dotPlot[k][j]);
        dotLink[k][j] += 0b100;
    }


//      following boxes
    for (i = 1; i < tableVerticalLength; i++) {
        for (j = 1; j < tableHorizonLength; j++) {
            
            
            int best;
            int dg, right, down;
            
            Route1:
            {
                // go right (from left)
                right = dotPlot[i][j - 1] - 4;
            }
            
            Route2:
            {
                // go down (from up)
                down = dotPlot[i - 1][j] - 4;
            }
            
            Route3:
            {
                dg = dotPlot[i - 1][j - 1] + geneScorePair[geneB[i]][geneA[j]];
            }
            
            SelectBest:
            {
                best = Math.max(right, Math.max(down, dg));
                //! establishing links(in-edges)
                
                // it is easier to perform path add than instead of inside comparison if-statements
                
                /*
                 * 0b000001 : right link
                 * 0b000100 : down link
                 * 0b010000 : diagonal link
                 * */
                if (best == right) {
                    dotLink[i][j] += 0b1;
                }
                if (best == down) {
                    dotLink[i][j] += 0b100;
                }
                if (best == dg) {
                    dotLink[i][j] += 0b10000;
                }
            }
            dotPlot[i][j] = best;
        }
    }//end of scoring system
    
    
    //start of path tracing, from dp[m][n]
    int m = DNA_B.length(), n = DNA_A.length();
    //initial m=5 n=5
    ArrayList<Integer> subPath = new ArrayList<>();
    ArrayList<Character> genMatchI = new ArrayList<>();
    ArrayList<Character> genMatchII = new ArrayList<>();
    
    //in reverse traversal
    char charA, charB;
    while ((n | m) != 0) { //end at (0,0)
        
        if (m != 0) {
            charB = DNA_B.charAt(m - 1);
        } else {
            charB = '-';
        }
        
        if (n != 0) {
            charA = DNA_A.charAt(n - 1); //offset start from zero
        } else {
            charA = '-';
        }
        
        if ((dotLink[m][n] & 16) != 0) { //dg
            //append SB
            genMatchI.add(charA);
            genMatchII.add(charB);
            //continue traversal
            m -= 1;
            n -= 1;
            continue;
        }
        if ((dotLink[m][n] & 4) != 0) { //down
            //append SB
            genMatchI.add('-');
            genMatchII.add(charB);
            //continue traversal
            m -= 1;
//            n -= 1;
            continue;
        }
        if ((dotLink[m][n] & 1) != 0) { //right
            //append SB
            genMatchI.add(charA);
            genMatchII.add('-');
            //continue traversal
//            m -= 1;
            n -= 1;
        }
        
        
    }//end of path tracing
    
    
    //display results
    System.out.println("Original");
    System.out.println("gene A: " + DNA_A);
    System.out.println("gene B: " + DNA_B);
    
    Collections.reverse(genMatchI);
    Collections.reverse(genMatchII);
    System.out.println("\nMatched\n=====================\n");
    System.out.println("gene A: " + genMatchI.toString());
    System.out.println("gene B: " + genMatchII.toString());
    System.out.println("Score: " + dotPlot[tableVerticalLength - 1][tableHorizonLength - 1]);
    
}//end of main


private static short[] geneToArray(String gene) {
//        static char[] geneChar={'A','C','G','T'};
    short[] array = new short[gene.length() + 1];
    char[] charArray = gene.toCharArray();
    
    array[0] = -1; //reserved
    
    for (int i = 1; i <= charArray.length; i++) {
        char curr = charArray[i - 1];
        switch (curr) {
            case 'A':
                array[i] = 0;
                break;
            case 'C':
                array[i] = 1;
                break;
            case 'G':
                array[i] = 2;
                break;
            case 'T':
                array[i] = 3;
                break;
            
        }
    }
    
    return array;
}
}
