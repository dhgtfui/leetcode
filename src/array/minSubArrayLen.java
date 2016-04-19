/**
 * Function Instruction: LeetCode 209. Minimum Size Subarray Sum
 * Developer：jxwang
 * Date：2016, Feb 28
 */
//Given an array of n positive integers and a positive integer s, 
//find the minimal length of a subarray of which the sum ≥ s.
//If there isn't one, return 0 instead.
package array;

public class minSubArrayLen {
	public static void main(String[] args){
		int[] list = {5,1,3,5,10,7,4,9,2,8};
		System.out.println(minSubArrayLen(15,list));
	}
	public static int minSubArrayLen(int s, int[] nums) {
		if(nums.length == 0 || nums == null)
			return 0;
        int sum = 0, min = Integer.MAX_VALUE;
        int start = 0, end = 0;
        while(start < nums.length && end < nums.length){
        	while(sum < s && end < nums.length){
        		sum += nums[end++];
        	}
        	while(sum >= s && start <= end){
        	    min = Math.min(min, end-start);
        		sum -= nums[start++];
        	}
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
