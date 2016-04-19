/**
 * Function Instruction: LeetCode 35. Search Insert Position
 * Developer：jxwang
 * Date：2016, Mar 2
 */
//Given a sorted array and a target value, return the index if the target is found. 
//If not, return the index where it would be if it were inserted in order.
//You may assume no duplicates in the array.
package binarySearch;

public class searchInsert {
	public static void main(String[] args){
		//[1,3,5,6], 5 → 2
		//[1,3,5,6], 2 → 1
		//[1,3,5,6], 7 → 4
		//[1,3,5,6], 0 → 0
		int nums[] = {1,3,5,6};
		System.out.print(searchInsert(nums, 0));
	}
	public static int searchInsert(int[] nums, int target) {
		int mid = 0;
        int low = 0, high = nums.length - 1;
        while(low <= high){
        	mid = (high + low)/2;
        	if(nums[mid] == target)
        		return mid;
        	else if(nums[mid] > target)
        		high = mid - 1;
        	else
        		low = mid + 1;
        }
        return high + 1;
    }
	
}
