/**
 * Function Instruction: LeetCode 78. Subsets
 * Developer：jxwang
 * Date：2016, Feb 29
 */
//Given a set of distinct integers, nums, return all possible subsets.
package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class subsets {
	public static void main(String[] args){
		int[] nums={1,2};
		System.out.print(subsets(nums));
	}
	static List<List<Integer>>  res  = new ArrayList<>(); 
	public static List<List<Integer>> subsets(int[] nums) {
		ArrayList<Integer> tmp = new ArrayList<Integer>(); 
		Arrays.sort(nums);
		res.clear();
        helper(nums, 0, tmp);  
        return res; 
    }
	public static void helper(int[] num, int start, ArrayList<Integer> list) {  
        if (start == num.length) {  
            res.add(new ArrayList<>(list));    
            return;  
        }  
        helper(num, start + 1, new ArrayList<Integer>(list));     
        list.add(num[start]);          
        helper(num, start + 1, new ArrayList<Integer>(list));   
    } 
}
