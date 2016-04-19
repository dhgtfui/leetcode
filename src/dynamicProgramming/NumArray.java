/**
 * Function Instruction: LeetCode 303. Range Sum Query - Immutable
 * Description: Given an integer array nums, find the sum of the elements 
 * between indices i and j (i ≤ j), inclusive.
 * Developer：jxwang
 * Date：2016, Feb 28
 */
//Given an integer array nums, find the sum of the elements 
//between indices i and j (i ≤ j), inclusive.
package dynamicProgramming;

public class NumArray {
	public static void main(String[] args){
		System.out.println(sumRange(2,5));
	}
	public static int[] list={-2,0,3,-5,2,-1};
    public NumArray(int[] nums) {
        if(nums == null)
            list = null;
        else if(nums.length == 0)
            list[0] = 0;
        else{
            this.list = new int[nums.length];
            list[0] = nums[0];
            for(int i = 1; i < nums.length; i++){
                list[i] = list[i-1] + nums[i];
            }
        }
    }

    public static int sumRange(int i, int j) {
        if(list == null || i > j || i < 0 || j > list.length || j < 0 || i > list.length)
            return 0;
        else if(i == 0)
            return list[j];
        else
            return list[j] - list[i-1];
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);
