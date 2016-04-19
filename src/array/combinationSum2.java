/**
 * Function Instruction: LeetCode 40. Combination Sum II
 * Developer：jxwang
 * Date：2016, Feb 29
 */
//Given a set of candidate numbers (C) and a target number (T), 
//find all unique combinations in C where the candidate numbers sums to T.
//Each number in C may only be used once in the combination.
package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combinationSum2 {
	public static void main(String[] args){
		int t = 7;
		int[] c = {10,1,2,7,6,1,5};
		System.out.print(combinationSum2(c,8));
	}
	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, target, 0, res, tmp);
        return res;
    }
    public static void helper(int[] c, int target, int start, List<List<Integer>> res, List<Integer> tmp){
        if(target == 0){
            res.add(new ArrayList<>(tmp));
        }
        if(target < 0)
            return;
        for(int i = start; i < c.length; i++){
        	if(i > start && c[i] == c[i - 1])
        		continue;
            tmp.add(c[i]);
            helper(c, target - c[i], i+1, res, tmp);
            tmp.remove(tmp.size()-1);
        }
    }
}
