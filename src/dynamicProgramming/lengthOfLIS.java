/**
 * Function Instruction: LeetCode 300. Longest Increasing Subsequence
 * Description: Given an unsorted array of integers, find the length of longest increasing subsequence.
 * Given [10, 9, 2, 5, 3, 7, 101, 18],
 * The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4.
 * Developer：jxwang
 * Date：2016, Apr 12
 */
package dynamicProgramming;

public class lengthOfLIS {
	public static void main(String[] args){
		int[] num = {1,3,2};
		System.out.println(lengthOfLIS(num));
	}
	public static int lengthOfLIS(int[] nums) {
		if(nums.length == 0 ||nums == null)
			return 0;
        int max = 0;
        int[] dp = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
        	dp[i] = 1;
        	for(int j = 0; j < i; j++){
        		if(nums[i] > nums[j] && dp[j]+1 > dp[i]){
        			dp[i] = dp[j]+1;
        		}
        	}
        	max = max > dp[i] ? max: dp[i];
        }
        return max;
    }
}
