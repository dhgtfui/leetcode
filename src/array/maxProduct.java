/**
 * Function Instruction: LeetCode 152. Maximum Product Subarray
 * Developer：jxwang
 * Date：2016, Mar 4
 */
//Find the contiguous subarray within an array 
//(containing at least one number) which has the largest product.
package array;

public class maxProduct {
	public static void main(String[] args){
		int[] list = {-2,3,-4};
		System.out.println(maxProduct(list));//6
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
