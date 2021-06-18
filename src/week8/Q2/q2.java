package week8.Q2;

public class q2 {
// https://leetcode.com/problems/dice-roll-simulation/

public static void main(String[] args) {
    Solution sl = new Solution();
    int n = 2;
    int[] rollMax = {1, 1, 2, 2, 2, 3};
    System.out.println((sl.dieSimulator(n, rollMax)));
    
    
}
}

//return the number of distinct sequences that can be obtained with exact n rolls.
class Solution {
public int dieSimulator(int n, int[] rollMax) {
    int cLength = n;
// smaller but slower
//    int cLength = 0;
//    for (int cur : rollMax) {
//        cLength = Math.max(cLength,cur);
//    }
    
    // [Dice seq. length][No. of faces][number of same consequent faces]
    // row col page
    int dp[][][] = new int[n+1][7][cLength+1];
    
    //initialize first row
    dp[1][1][1]=1;
    dp[1][2][1]=1;
    dp[1][3][1]=1;
    dp[1][4][1]=1;
    dp[1][5][1]=1;
    dp[1][6][1]=1;
    
    int total=0;
    for (int i = 2; i <= n; i++) {
        for (int j = 1; j <=6; j++) {
            for (int k = 1; k < cLength; k++) {
                for (int p = 1; p < 7; p++) {
                    if(p==j)continue;
        
                    dp[i][j][1]+= dp[i-1][p][k];
                    //aggregate combinations for last length, regardless of same seq.
                }
                
            if(k< rollMax[j-1]){
    
            dp[i][j][k+1] = dp[i-1][j][k];
            // count allowed repeated sequences
            }

            total+=dp[i][j][k];
            total+=dp[i][j][k+1];
            }
        
        }
    
    }
    return total;
}
}