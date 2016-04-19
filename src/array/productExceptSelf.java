/**
 * Function Instruction: LeetCode 238. Product of Array Except Self
 * Developer：jxwang
 * Date：2016, Mar 4
 */
//Solve it without division and in O(n).
package array;

import java.util.Arrays;


public class productExceptSelf {
	public static void main(String[] args){
		int[] res = productExceptSelf(new int[]{1,2,3,4});
			System.out.print(Arrays.toString(res));
	}
	public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int[] left = new int[n];
        left[0] = nums[0];
        for(int i = 1; i < n; i++){
            left[i] = left [i-1] * nums[i];
        }
        
        int[] right = new int[n];
        right[n-1] = nums[n-1];
        for(int i = n - 2; i >= 0; i--){
            right[i] = right[i+1] * nums[i];
        }
        res[0] = right[1];
        res[n-1] = left[n-2];
        for(int i = 1; i < n - 1; i++){
            res[i] = left [i-1] * right[i+1];
        }
        return res;
    }
}
