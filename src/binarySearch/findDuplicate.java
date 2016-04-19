/**
 * Function Instruction: LeetCode 287. Find the Duplicate Number
 * Developer：jxwang
 * Date：2016, Mar 5
 */
//Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. 
//Assume that there is only one duplicate number, find the duplicate one.
//O(1) space, O(n^2) time
package binarySearch;

import java.util.Arrays;

public class findDuplicate {
	public static void main(String[] args){
		int[] test = {5,1,2,3,4,2};
		System.out.print(findDuplicate(test));
	}
	public static int findDuplicate(int[] nums) {
		int n = nums.length - 1;
        int left = 1, right = n;
        int mid = 0;
        while(left < right){
            mid = left + (right - left)/2;
            if(count(nums, mid) <= mid)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }
	public static int count(int[] nums, int mid){
		int c = 0;  
        for(int i=0; i< nums.length; i++) {  
            if(nums[i]<= mid) c++;  
        }  
        return c; 
	}
}
