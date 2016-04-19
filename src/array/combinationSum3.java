/**
 * Function Instruction: LeetCode 216. Combination Sum III
 * Developer：jxwang
 * Date：2016, Feb 29
 */
//Find all possible combinations of k numbers that add up to a number n, 
//given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
package array;

import java.util.ArrayList;
import java.util.List;

public class combinationSum3 {
	public static void main(String[] args){
		List<Integer> tmp = new ArrayList<>();
		System.out.print(combinationSum3(1,1));
	}
	public static List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> tmp = new ArrayList<>();
		if(k == 1)
	    {
	        tmp.add(1);
	        res.add(tmp);
	        return res;
	    }
	if(k >2 && k >= n)
		return res;
		int[] candidates = {1,2,3,4,5,6,7,8,9};
		helper(candidates, n, 0, tmp, res, k);
		return res;
    }
	public static void helper(int[] c, int target, int start, List<Integer> tmp, List<List<Integer>> res, int k){
		if(target == 0){
			ArrayList<Integer> cur=new ArrayList<>(tmp);
			if(tmp.size() == k)
				{res.add(new ArrayList<>(tmp));}
		}
		if(target < 0)
			return;
		for(int i = start; i < c.length; i++){
			if (i > start && c[i] == c[i - 1])
				continue;
			tmp.add(c[i]);
			helper(c, target - c[i], i + 1, tmp, res, k);
			tmp.remove(tmp.size() - 1);
		}
	}
}
