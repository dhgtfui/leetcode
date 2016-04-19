/**
 * Function Instruction: LeetCode 152. Maximum Product Subarray
 * Description: Given the array [2,3,-2,4],
 * the contiguous subarray [2,3] has the largest product = 6.
 * Developer：jxwang
 * Date：2016, Apr 11
 */
package dynamicProgramming;

public class maxProduct {
	public static void main(String[] args){
		int[] nums = {-2,-3,-2,4};
		System.out.print(maxProduct(nums));
	}
	public static int maxProduct(int[] nums) {
		if(nums.length == 1)
			return nums[0];
		int res = nums[0];
		int tmpMax = nums[0];
		int tmpMin = nums[0];
		int tmp;
		for(int i = 1; i < nums.length; i++){
		    tmp = tmpMax;
		    tmpMax = Math.max(Math.max(tmp * nums[i], nums[i]), nums[i] * tmpMin);
		    tmpMin = Math.min(Math.min(tmp * nums[i], nums[i]), nums[i] * tmpMin);
		    res = Math.max(res, tmpMax);
		}
		return res;
	}
}
