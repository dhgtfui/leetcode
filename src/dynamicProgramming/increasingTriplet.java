/**
 * Function Instruction: LeetCode 334. Increasing Triplet Subsequence
 * Description: Given an unsorted array return whether an increasing 
 * subsequence of length 3 exists or not in the array.
 * Your algorithm should run in O(n) time complexity and O(1) space complexity.
 * Developer：jxwang
 * Date：2016, Apr18
 */
package dynamicProgramming;

public class increasingTriplet {
	public static void main(String[] args){
		int[] nums = {5,4,3,2,1};
		if(increasingTriplet(nums))
			System.out.print("true");
		else
			System.out.print("false");
	}
	public static boolean increasingTriplet(int[] nums) {
        int x1= Integer.MAX_VALUE, x2 = Integer.MAX_VALUE;
        int num;
        for(int i = 0; i < nums.length; i++){
        	if(nums[i] <= x1)
        		x1 = nums[i];
        	else if(nums[i] <= x2)
        		x2 = nums[i];
        	else
        		return true;
        }
        return false;
    }
}
