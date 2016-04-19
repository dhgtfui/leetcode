/**
 * Function Instruction: LeetCode 60. Permutation Sequence
 * Developer：jxwang
 * Date：2016, Mar 5
 */
//Given n and k, return the kth permutation sequence.
package backtracking;

import java.util.*;

public class getPermutation {
	public static void main(String[] args){
		System.out.print(getPermutation(3,4));
	}
	public static String getPermutation(int n, int k) {
		int index = k - 1;
	    List<Integer> nums = new ArrayList<Integer>();
	    for (int i = 1; i <= n; i++) {
	        nums.add(i);
	    }
	    String ans = "";
	    for (int i = n - 1; i >= 1; i--) {
	        int fact = factorial(i);
	        int nextIndex = index / fact;
	        index = index % fact;
	        ans += nums.remove(nextIndex);
	    }
	    ans += nums.get(0);
	    return ans;
	}

	private static int factorial(int x) {
	    if (x == 0) return 0;
	    int ans = 1;
	    for (int i = 2; i <= x; i++) {
	        ans *= i;
	    }
	    return ans;
	}
}
