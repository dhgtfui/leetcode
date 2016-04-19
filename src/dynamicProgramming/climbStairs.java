/**
 * Function Instruction: LeetCode 70. Climbing Stairs
 * Description: You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * Developer：jxwang
 * Date：2016, Apr 11
 */
package dynamicProgramming;

public class climbStairs {
	public static void main(String[] args){
		System.out.print(climbStairs(3));
	}
	public static int climbStairs(int n) {
		int[] dp = new int[n];
        dp[0] = 1;
        if(n > 1){
            dp[1] = 2;
            for(int i = 2; i < n; i++){
            	dp[i] = dp[i-1] + dp[i-2];
            }
        }
        return dp[n-1];
    }
}