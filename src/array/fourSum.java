/**
 * Function Instruction: LeetCode 18. 4Sum
 * Developer：jxwang
 * Date：2016, Feb 28
 */
package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class fourSum {
	public static void main(String[] args){
		int[] array = {-1,2,2,-5,0,-1,4};
		System.out.print(fourSum(array,3));
	}
	public static List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<>();
        if(nums.length < 3 || nums == null)
            return res;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 3; i++){
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            for(int j = i + 1; j < nums.length - 2; j++){
                if(j > i + 1 && nums[j] == nums[j-1])
                    continue;
                int left = j + 1, right = nums.length - 1;
                while(left < right){
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if(sum == target){
                        List<Integer> data = new ArrayList<>();
                        data.add(nums[i]);
                        data.add(nums[j]);
                        data.add(nums[left]);
                        data.add(nums[right]);
                        res.add(data);
                        left++;
                        right--;
                        while(left < right && nums[left] == nums[left - 1]) left++;
                        while(left < right && nums[right] == nums[right + 1]) right--;
                    }
                    else if(sum > target){
                        right--;
                        while(left < right && nums[right] == nums[right + 1]) right--;
                    }
                    else{
                        left++;
                        while(left < right && nums[left] == nums[left - 1]) left++;
                    }
                }
            }
        }
        return res;
    }
}
