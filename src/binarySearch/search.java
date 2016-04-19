/**
 * Function Instruction: LeetCode 33. Search in Rotated Sorted Array
 * 281. Search in Rotated Sorted Array II
 * Developer：jxwang
 * Date：2016, Mar 3
 */
//33-You are given a target value to search. If found in the array return its index, otherwise return -1.
package binarySearch;

public class search {
	public static int search33(int[] nums, int target) {
		if(nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0, end = nums.length-1;
        int mid;
        while(start + 1 < end){
            mid = start + (end - start) / 2;
            if(nums[mid] == target) {
                return mid;
            }
            if(nums[start] < nums[mid]){
                if(nums[start] <= target && target <= nums[mid]){
                    end = mid;
                } else {
                    start = mid;
                }
            } else {
                if(nums[mid] <= target && target <= nums[end]){
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }//while
        if(nums[start] == target){
            return start;
        }
        if(nums[end] == target){
            return end;
        }
        return -1;
    }
	public static boolean search281(int[] nums, int target) {
        boolean res ;
        return false;
    }
}
