/**
 * Function Instruction: LeetCode 283. Move Zeroes
 * Developer：jxwang
 * Date：2016, Feb 26
 */
//Given an array nums, write a function to move all 0's to the end of it 
//while maintaining the relative order of the non-zero elements.
//[0, 1, 0, 3, 12]-> [1, 3, 12, 0, 0].
//Note: 1. You must do this in-place without making a copy of the array.
//2. Minimize the total number of operations.
package array;

public class moveZeroes {
	public static void main(String[] args){
		int[] array = {0, 1, 0, 3, 12};
		moveZeroes(array);
		for(int i = 0; i < array.length; i++){
			System.out.print(array[i]+" ");
		}
	}
	public static void moveZeroes(int[] nums) {
		int count = 0;
		//nonzero elements 
		for(int i = 0; i < nums.length; i++){
			if(nums[i] == 0){
				count++;
			}	
			else{
				nums[i-count] = nums[i];
			}
		}
		//zero elements
		for(int i = nums.length - 1; i > nums.length-1-count ; i--){
			nums[i] = 0;
		}
    }
}
