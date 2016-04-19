/**
 * Function Instruction: LeetCode 46. Permutations
 * Developer：jxwang
 * Date：2016, Mar 5
 */
//Given a collection of distinct numbers, return all possible permutations.
package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class permute {
	public static void main(String[] args){
		List<List<Integer>> res = permute(new int[] {1,2,3});
		System.out.print(res);
	}
	public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length == 0 ||nums == null)
            return res;
        List<Integer> tmp = new ArrayList<>();
        Arrays.sort(nums);
        helper(res, tmp, nums, new boolean[nums.length]);
        return res;
    }
    public static void helper(List<List<Integer>> res, List<Integer> tmp, int[] num, boolean[] visit){
        if(tmp.size() == num.length){
            res.add(new ArrayList<>(tmp));
            return;
        }
        for(int i = 0; i < num.length; i++){
            if(!visit[i]){
                tmp.add(num[i]);
                visit[i] = true;
                helper(res, tmp, num, visit);
                tmp.remove(tmp.size()-1);
                visit[i] = false;
            }
        }
    }
}
