package week7;

import java.util.Arrays;

/**
 * q1coinChange
 * https://leetcode.com/problems/coin-change
 * 
 You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:

Input: coins = [1, 2, 5], amount = 11
Output: 3 
Explanation: 11 = 5 + 5 + 1

Example 2:

Input: coins = [2], amount = 3
Output: -1

 */
public class q1coinChange {
    public static void main(String[] args) {
        System.out.println(coinChange(new int[] { 2 }, 1));

    }

    public static int coinChange(int[] coins, int amount) {
        if (amount == 0)
            return 0;
            
        int[] dpCoin = new int[amount + 1];

        Arrays.fill(dpCoin, amount + 1); // impossible value for later comparison and rewrite

        //preprocessing array
        dpCoin[0] = 0;

        out: for (int i = 1; i < amount + 1; i++) { //combine every number before
            for (int coin : coins) { //scan thru coins
                if (coin == i) {
                    dpCoin[coin] = 1;
                    continue out;
                }
                if (coin < i) {
                    // dpCoin[i-coin]+1 means that 
                    // "original count add this current coin" becomes i, 
                    //therefore count for i is dp[i-coin]+1
                    dpCoin[i] = Math.min(dpCoin[i], dpCoin[i - coin] + 1);
                    continue;
                }
            }
            //check if equal
        }
        if (dpCoin[amount] <= amount) {
            //that is changed
            return dpCoin[amount];
        }
        //dp[amount] never changed, meaning not possible
        return -1;
    }

}