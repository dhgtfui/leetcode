/**
 * Function Instruction: LeetCode 16. 3Sum Closest
 * Developer：jxwang
 * Date：2016, Feb 28
 */
//For example, given array S = {-1 2 1 -4}, and target = 1.
//The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
package array;

import java.util.Arrays;

public class threeSumClosest {
	public static void main(String[] args){
		int[] list = {0, 2, 1, -3};
		System.out.print(threeSumClosest(list,1));
	}
	public static int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int res = 0;
        for(int i = 0; i < nums.length - 2; i++){
            int left = i + 1, right = nums.length - 1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                int diff = Math.abs(sum - target);
                if(diff == 0){
                    return target;
                }
                else{
                    if(diff < min){
                        min = diff;
                        res = sum;
                    }
                }
                if(sum < target)
                    left++;
                else if(sum > target)
                    right--;
                
            }
        }
        return res;
    }
}
