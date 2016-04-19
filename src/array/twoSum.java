/**
 * Function Instruction: LeetCode 1. Two Sum
 * Developer：jxwang
 * Date：2016, Feb 28
 */
//return [0,1]
package array;

import java.util.HashMap;

public class twoSum {
	public static void main(String[] args){
		int[] array = {2,7,11,15, 9};
		System.out.print(twoSum(array,16)[0]+" "+ twoSum(array,16)[1]);
	}
	public static int[] twoSum(int[] nums, int target) {
		int[] res = new int[2];
        HashMap<Integer, Integer> map= new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(target - nums[i])){
                res[0] = map.get(target - nums[i]);
                res[1] = i;
            }
            else
                map.put(nums[i], i);
        }
        return res;
    }

}
