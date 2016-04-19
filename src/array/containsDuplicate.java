/**
 * Function Instruction: LeetCode 217. Contains Duplicate
 * Developer：jxwang
 * Date：2016, Feb 21
 */
//Given an array of integers, find if the array contains any duplicates. 
//Your function should return true if any value appears at least twice in the array, 
//and it should return false if every element is distinct.

package array;

import java.util.*;

public class containsDuplicate {
	public static void main(String[] args){
		int[] list={1,2,3,3};
		System.out.println(containsDuplicate(list));
	}
	public static boolean containsDuplicate(int[] nums) {
		if(nums.length == 0)
			return false;
        Set<Integer> list = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++){
        	if(list.contains(nums[i]) == false){
        		list.add(nums[i]);
        	}
        	else{
        		return true;
        	}
        	/**TLE
        	if(!list.add(nums[i]))
                return true;
                */
        }
        return false;
    }
}
