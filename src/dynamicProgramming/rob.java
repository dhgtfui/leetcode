/**
 * Function Instruction: LeetCode 198. House Robber
 * Developer：jxwang
 * Date：2016, Apr 11
 */
package dynamicProgramming;

public class rob {
	public static void main(String[] args){
		int[] list = {2,6,5};
		System.out.print(rob2(list));
	}
	//LeetCode 198. House Robber
	//Given a list of non-negative integers representing the amount of money of each house, 
	//determine the maximum amount of money you can rob tonight without alerting the police.
	public static int rob1(int[] nums) {
		if(nums.length == 0)
			return 0;
		if(nums.length == 1)
			return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        int max = Math.max(dp[0],dp[1]);
        if(nums.length == 2)
			return max;
        for(int i = 2; i < nums.length; i++){
        	dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]);
        	if(max < dp[i])
        		max = dp[i];
        }
        return max;
    }
	//213. House Robber II
	//This time, all houses at this place are arranged in a circle. 
	public static int rob2(int[] nums) {
		if(nums.length == 0)
			return 0;
		if(nums.length == 1)
			return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        int max = Math.max(dp[0],dp[1]);
        if(nums.length == 2)
			return max;
        //no rob of the 1st house
        dp[0] = 0;
        dp[1] = nums[1];
        int max1 = nums[1];
        for(int i = 2; i < nums.length; i++){
        	dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]);
        	if(max1 < dp[i])
        		max1 = dp[i];
        }
        //rob the 1st house
        dp[0] = nums[0];
        dp[1] = nums[0];
        int max2 = nums[0];
        for(int i = 2; i < nums.length-1; i++){
        	dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]);
        	if(max2 < dp[i])
        		max2 = dp[i];
        }
        
        return Math.max(max1, max2);
    }
}
