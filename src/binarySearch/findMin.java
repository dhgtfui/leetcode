/**
 * Function Instruction: LeetCode 153. Find Minimum in Rotated Sorted Array
 * 154. Find Minimum in Rotated Sorted Array II
 * Developer：jxwang
 * Date：2016, Mar 5
 */
//Suppose a sorted array is rotated at some pivot unknown to you beforehand.
//(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
//Find the minimum element.
package binarySearch;


public class findMin {
	public static void main(String[] args){
		//int[] test = {4, 5, 5, 6, 7, 0, 1, 2};
		int[] test = {1,3,3};
		System.out.println(findMin3(test));
	}
	//153. Find Minimum in Rotated Sorted Array
	//You may assume no duplicate exists in the array.
	//O(n)
	public static int findMin1(int[] nums) {
		if(nums.length == 0 || nums == null)
			return 0;
        int min = nums[0];
        for(int i = 1; i < nums.length; i++){
        	min = min > nums[i] ? nums[i] : min;
        }
        return min;
    }
	//153. Find Minimum in Rotated Sorted Array
	//You may assume no duplicate exists in the array.
	//O(log n)
	public static int findMin2(int[] nums) {
		if(nums.length == 0 || nums == null)
			return 0;
        int min = nums[0];
        int left = 0, right = nums.length - 1;
        int mid = 0;
        while(left < right){
        	mid = left + (right - left)/2;
        	if(nums[right] < nums[mid]){
        		left = mid + 1;
        	}
        	else{
        		right = mid; 
        	}
        }
        return nums[left];
    }
	//154. Find Minimum in Rotated Sorted Array II
	//The array may contain duplicates. 3 3 1 3
	public static int findMin3(int[] nums) {
		if(nums.length == 0 || nums == null)
			return 0;
        int min = nums[0];
        for(int i = 1; i < nums.length; i++){
        	min = min > nums[i] ? nums[i] : min;
        }
        return min;
    }
}
