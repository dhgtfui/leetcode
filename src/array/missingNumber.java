/**
 * Function Instruction: LeetCode 268. Missing Number
 * Developer：jxwang
 * Date：2016, Mar 5
 */
//Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, 
//find the one that is missing from the array.
package array;

public class missingNumber {
	public static void main(String[] args){
		int[] test = {1,0,3,4};
		System.out.println(missingNumber2(test)); //2
	}
	public static int missingNumber(int[] nums) {
		int sum = 0;
		int n = nums.length;
		for(int i = 0; i < n; i++){
			sum += nums[i];
		}
		return n*(n+1)/2 - sum;    
    }
	public static int missingNumber2(int[] nums) {
		int n = nums.length;
		int res = n;
		for(int i = 0; i < n; i++){
			res ^= i;
			res ^= nums[i];
		}
		return res; 
    }
}
