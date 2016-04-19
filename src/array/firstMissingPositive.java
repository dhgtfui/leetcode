/**
 * Function Instruction: LeetCode 41. First Missing Positive
 * Developer：jxwang
 * Date：2016, Mar 5
 */
//Given an unsorted integer array, find the first missing positive integer.
//Your algorithm should run in O(n) time and uses constant space.
package array;

public class firstMissingPositive {
	public static void main(String[] args){
		int[] test = {1,1};
		System.out.println(firstMissingPositive(test)); //2
	}
	public static int firstMissingPositive(int[] nums) {
        if(nums.length == 0 || nums == null)
        	return 1;
      //bucket sort
        int i = 0;
        while(i < nums.length){
            if(nums[i] == i + 1){
                i++; 
                continue;
            }
            else if(nums[i] > nums.length || nums[i] <= 0){
                i++;
                continue;
            }
            else if(nums[nums[i]-1] == nums[i]){
            	i++;
                continue;
            }
            swap(nums, i, nums[i] - 1);
        }
        //find the first missing positive integer
        i = 0;
        while(i < nums.length){
            if(nums[i] != i + 1)
                return i + 1;
            i++;
        }
        return i + 1;
    }
	public static void swap(int[] nums, int i, int j){
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;}
}
