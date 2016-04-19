/**
 * Function Instruction: LeetCode 322. Coin Change
 * Description: You are given coins of different denominations and a total amount of money amount. 
 * Write a function to compute the fewest number of coins that you need to make up that amount. 
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 * Developer：jxwang
 * Date：2016, Apr 11
 */
package dynamicProgramming;

public class coinChange {
	public static void main(String[] args){
		int[] coin = {1,2,5};
		int amount = 11;
		System.out.println(coinChange(coin, amount));
	}
	public static int coinChange(int[] coins, int amount) {
        int res = -1;
        int[] dp = new int[amount+1];//Amount = i, need at least dp[i] coins
        dp[0] = 0;
        for(int i = 1; i <= amount; i++){
        	dp[i] = Integer.MAX_VALUE;
        }
        for(int i = 0; i <= amount; i++){
        	for(int j = 0; j < coins.length; j++){
        		if(dp[i] != Integer.MAX_VALUE && i + coins[j] <= amount)
        			dp[i+coins[j]] = Math.min(dp[i]+1, dp[i+coins[j]]);
        	}
        }
        return dp[amount] == Integer.MAX_VALUE ? -1:dp[amount];
    }
}
