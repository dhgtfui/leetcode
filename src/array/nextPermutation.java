/**
 * Function Instruction: LeetCode 31. Next Permutation
 * Developer：jxwang
 * Date：2016, Mar 5
 */
package array;

import java.util.Arrays;

public class nextPermutation {
	public static void main(String[] args){
		int[] nums = {5,1,1,1,1};
		
		//System.out.print(i);
		nextPermutation(nums);
		System.out.print(Arrays.toString(nums));
	}
	public static void nextPermutation(int[] nums) {
		//step 1: right->left, find the first element nums[i] in a increasing subset
		int i = nums.length - 1;
		while(i > 0){
			if(nums[i] <= nums[i-1]){
				i--;
			}
			else
				break;
		}
		if(i == 0) 
			Arrays.sort(nums); //special case 3,2,1
		else {
			i--;
			//step 2: On right of nums[i], find the minimum nums[j] > nums[i]
			int min = nums[i + 1];
			int indexMin = i;
			for(int j = i + 1; j < nums.length; j++){
				if(nums[j] > nums[i]){
					min = nums[j] > min ? min : nums[j];
					indexMin = nums[j] > min ? indexMin : j;
				}
			}
			//step 3: swap nums[i] , nums[indexMin]
			int tmp = nums[i];
			nums[i] = min;
			nums[indexMin] = tmp;
			
			//step 4: sort nums[i+1 ... n-1]
			Arrays.sort(nums, i+1, nums.length);
		}
    }
}
