/**
 * Function Instruction: LeetCode 279. Perfect Squares
 * Description: Given a positive integer n, find the least number of perfect square numbers 
 * (for example, 1, 4, 9, 16, ...) which sum to n.
 * Developer：jxwang
 * Date：2016, Mar 7
 */
package dynamicProgramming;

import java.util.Arrays;

public class numSquares {
	public static void main(String[] args){
		//int[] dp = new int[]{4};
		System.out.print(numSquares(13));
	}
	public static int numSquares(int n) {
        int[] dp = new int[n+1]; //dp[i], the least times of sum to i
        dp[0] = 0; 
        for(int i = 1; i <= n; i++){
        	dp[i] = Integer.MAX_VALUE;
        	for(int j = 1; j * j <= i; j++){
        		dp[i] = Math.min(dp[i], dp[i-j*j]+1);
        	}
        }
        return dp[n];
    }
}
