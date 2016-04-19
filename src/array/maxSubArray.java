/**
 * Function Instruction: LeetCode 53. Maximum Subarray
 * Developer：jxwang
 * Date：2016, Mar 4
 */
//Find the contiguous subarray within an array (containing at least one number) 
//which has the largest sum. O(n)
package array;

public class maxSubArray {
	public static void main(String[] args){
		int[] list = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSubArray(list));//6
	}
	public static int maxSubArray(int[] nums) {
		int maxSum = nums[0];
        if(nums.length == 1)
            return maxSum;
        int[] tmp = new int[nums.length];
        tmp[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            tmp[i] = Math.max(tmp[i-1] + nums[i], nums[i]);
            maxSum = Math.max(tmp[i], maxSum);
        }
        return maxSum;
    }
}
