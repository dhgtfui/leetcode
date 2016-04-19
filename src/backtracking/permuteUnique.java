/**
 * Function Instruction: LeetCode 47. Permutations II
 * Developer：jxwang
 * Date：2016, Mar 5
 */
//Given a collection of numbers that might contain duplicates, 
//return all possible unique permutations.
package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class permuteUnique {
	public static void main(String[] args){
		List<List<Integer>> res = permuteUnique(new int[] {1,1,2});
		System.out.print(res);
	}
	public static List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if(nums.length == 0 || nums == null)
			return res;
		Arrays.sort(nums);
		helper(res, nums, new boolean[nums.length], new ArrayList<Integer>());
		return res;
    }
	public static void helper(List<List<Integer>> ans, int[] num, boolean[] visit, ArrayList<Integer> tmp){
		if(tmp.size() == num.length){
			ans.add(new ArrayList<>(tmp)); 
			return;
		}
		for(int i = 0; i < num.length; i++){
			if(i > 0 && num[i] == num[i-1] && visit[i-1] == false)
				continue;
			if (!visit[i]) {
                tmp.add(num[i]);
                visit[i] = true;
                helper(ans, num, visit, tmp);
                tmp.remove(tmp.size() - 1);
                visit[i] = false;
            }
		}
	}
}
