/**
 * Function Instruction: LeetCode 77. Combinations
 * Developer：jxwang
 * Date：2016, Feb 29
 */
//Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

package backtracking;

import java.util.ArrayList;
import java.util.List;

public class combine {  
	public static void main(String[] args){
		System.out.print(combine(2,1));
	}
	static List<List<Integer>>  res  = new ArrayList<>();  
    public static List<List<Integer>> combine(int n, int k) {  
        ArrayList<Integer> list = new ArrayList<Integer>();  
        res.clear();  
        helper(n, k, 0, 1, list);  
        return res;  
    }  
  
    private static void helper(int n, int k, int level, int start, ArrayList<Integer> list) {  
        if (level >= k) {  
            res.add(new ArrayList<>(list));    
            return;  
        }  
        for (int i = start; i <= n; i++) {  
            list.add(i);  
            helper(n, k, level + 1, i + 1, list);  
            list.remove(list.size()-1);  
        }  
    } 
}
