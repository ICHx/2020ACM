package week7.q3;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * .
 * .
 * .
*/
public class drawers {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException {
        //  File  file1=new File("src/week7/q3/case.txt");
        //  Scanner sc = new Scanner(file1);
        int n = sc.nextInt();
        int s = sc.nextInt();
        while (n+s>=0) {
            payload(n,s);

            n = sc.nextInt();
            s = sc.nextInt();
        }
    }
//this is a incremental calculation of possible permutation

    private static void payload(int n, int s) {
    int[][][] dp=new int[n+1][n+1][2];

    //base cases:

        //single locked case#
        dp[1][1][1]=1;

        //single unlocked case#
        dp[1][0][0]=1;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.println("i="+i+" j="+j);
                // bottom layer is not locked

                dp[i][j][0]+=dp[i-1][j][0]+dp[i-1][j][1];
//                System.out.println("0="+dp[i][j][0]);

                // bottom layer is locked

                // copy possibilities of to this layer is not locked
                dp[i][j][1]+=dp[i-1][j][0];

                // when last layer is also locked, increase lock possibilities
                if(j>0) {
                    dp[i][j][1]+=dp[i-1][j-1][1];
                }

//                System.out.println("1="+ dp[i][j][1]);

            }
        }
        System.out.println(dp[n][s][1]+dp[n][s][0]);

    }
}