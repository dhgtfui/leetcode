/**
 * Function Instruction: LeetCode 39. Combination Sum
 * Developer：jxwang
 * Date：2016, Feb 28
 */
//Given a set of candidate numbers (C) and a target number (T), 
//find all unique combinations in C where the candidate numbers sums to T.
//The same repeated number may be chosen from C unlimited number of times.
package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combinationSum {
	public static void main(String[] args){
		int t = 7;
		int[] c = {2,3,6,7};
		System.out.print(combinationSum(c,7));
	}
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
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
            tmp.add(c[i]);
            helper(c, target - c[i], i, res, tmp);
            tmp.remove(tmp.size()-1);
        }
    }
}
