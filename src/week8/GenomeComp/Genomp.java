package week8.GenomeComp;

import java.util.ArrayList;
import java.util.Arrays;

public class Genomp {
static char[] geneChar = {'A', 'C', 'G', 'T'};
static int[][] genePair = {{10, -5, 0, -5}, {-5, 10, -5, 0}, {0, -5, 10, -5}, {-5, 0, -5, 10}};


public static String DNA_A = "GAATC";
public static String DNA_B = "CATAC";

public static void main(String[] args) {
    //get 2 strings
    
    // create dot plot matrix
    int[][] dotPlot;
    dotPlot = new int[DNA_A.length() + 1][DNA_B.length() + 1];
    
    byte[][] dotLink;
    dotLink = new byte[DNA_A.length() + 1][DNA_B.length() + 1];
    /*
     * 0b000001 : right down link
     * 0b000100 : down right link
     * 0b010000 : diagonal   link
     * */
    
    
    for (int[] ints : dotPlot) {
        Arrays.fill(ints, Integer.MIN_VALUE);
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
//            initialize 0th row
    for (int k = j + 1; k < dotPlot[0].length; k++) {
        dotPlot[i][k] = Math.max(dotPlot[i][k - 1] - 4, dotPlot[i][k]);
    }
//            initialize 0th col
    for (int k = i + 1; k < dotPlot.length; k++) {
        dotPlot[k][j] = Math.max(dotPlot[k - 1][j] - 4, dotPlot[k][j]);
    }


//      following boxes
    for (i = 1; i < dotPlot.length; i++) {
        for (j = 1; j < dotPlot[0].length; j++) {
            
            
            int best;
            int dg, right, down;
            
            Route1:
            {
                // go right
                right = dotPlot[i][j - 1] - 4;
            }
            
            Route2:
            {
                // go down
                down = dotPlot[i - 1][j] - 4;
            }
            
            Route3:
            {
                dg = dotPlot[i - 1][j - 1] + genePair[geneB[i]][geneA[j]];
            }
            
            SelectBest:
            {
                best = Math.max(right, Math.max(down, dg));
                
                // establishing links(in edges)
                // right arrow
                // down  arrow
                // diag  arrow
                
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
    }//end of scoring
    
    assert false;
    
    //start of path choosing, from dp[m][n]
    int m = DNA_B.length(), n = DNA_A.length();
    //initial m=5 n=5
    ArrayList<Integer> subPath = new ArrayList<>();
    ArrayList<Character> genMatchI = new ArrayList<>();
    ArrayList<Character> genMatchII = new ArrayList<>();
    
    //everything are in reverse direction here
    while (n != 0 || m != 0) {
        char charA = DNA_A.charAt(n - 1); //offset start from zero
        char charB = DNA_B.charAt(m - 1);
        
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
            continue;
        }
        
        
    }
    
    
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
