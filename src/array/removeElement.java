/**
 * Function Instruction: LeetCode 27. Remove Element
 * Developer：jxwang
 * Date：2016, Feb 21
 */
//Given an array and a value, remove all instances of that value in place and return the new length.
//The order of elements can be changed. It doesn't matter what you leave beyond the new length.
package array;

public class removeElement {
	public static int removeElement(int[] nums, int val) {
        if(nums.length == 0 || nums == null){
        	return 0;
        }
        int length = 0;
        for(int i = 0; i< nums.length; i++){
        	if(nums[i] != val){
        		if(nums[length] != nums[i]){
        			nums[length] = nums[i];
        		}
        		length++;
        	}
        }
        return length;
    }
}
