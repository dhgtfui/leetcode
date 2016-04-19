/**
 * Function Instruction: LeetCode 189. Rotate Array
 * Developer：jxwang
 * Date：2016, Feb 21
 */
//Rotate an array of n elements to the right by k steps.
//For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

package array;

public class rotate {
	public static void main(String[] args){
		int[] y={1,2};
		int[] x=rotate(y,1);
		for(int i=0; i<x.length;i++){
			System.out.print(x[i]+" ");
		}
	}
	public static int[] rotate(int[] nums, int k) {
        int[] newNums=new int[nums.length];
        k = k % nums.length;  
        for(int i = 0; i < k; i++){
        	newNums[i] = nums[nums.length - k + i];
        }
        for(int i = 0; i < nums.length-k; i++){
        	newNums[i+k] = nums[i];
        }
        return newNums;
    }
	public static void reverse(int[] nums, int start, int end) {  
        while(start < end) {  
            int temp = nums[start];  
            nums[start] = nums[end];  
            nums[end] = temp;  
            ++start;  
            --end;  
        }  
    }  
    public static int[] rotate1(int[] nums, int k) {  
        k = k % nums.length;  
        reverse(nums, 0, nums.length - 1 );  
        reverse(nums, 0, k - 1 );  
        reverse(nums, k, nums.length - 1 );
		return nums;  
    }  
}
