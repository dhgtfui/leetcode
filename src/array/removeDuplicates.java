/**
 * Function Instruction: LeetCode 26. Remove Duplicates from Sorted Array
 * Developer：jxwang
 * Date：2016, Feb 21
 */
//Given a sorted array, remove the duplicates in place such that 
//each element appear only once and return the new length.
//Do not allocate extra space for another array, you must do this in place with constant memory.
//[1,1,2]->length=2, nums=[1,2]
package array;

public class removeDuplicates {
	public static void main(String[] args){
		int[] array={1,2,2};//1,1,2,2,3
		//int[] res = removeDuplicates2(array);
		//for(int i = 0; i < res.length; i++){
			System.out.print(removeDuplicates2(array));
		//}
		
	}
	//80. Remove Duplicates from Sorted Array II
	public static int removeDuplicates2(int[] nums) {
		if(nums.length == 0 || nums == null)
			return 0;
		if(nums.length > 0 && nums.length <3)
			return nums.length;
		int length = 2;
		//[1,1,1,2,2,3]->1,1,2,2,3
		for(int i = 2; i < nums.length; i++){
			if(nums[i] != nums[length - 2]){
				nums[length++] = nums[i];
			}
		}
		return length;
    }
	public static int removeDuplicates(int[] nums) {
		if(nums.length == 0 || nums == null)
			return 0;
		int length = 1;
		for(int i = 1; i<nums.length; i++){
			if(nums[i] != nums[i-1]){
				if(nums[i] != nums[length]){
					nums[length] = nums[i];
				}
				length++;
			}
		}
        return length;
    }
}
