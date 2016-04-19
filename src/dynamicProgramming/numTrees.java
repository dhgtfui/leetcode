/**
 * Function Instruction: LeetCode 96. Unique Binary Search Trees
 * Description: Given n, how many structurally unique BST's (binary search trees) 
 * that store values 1...n?
 * Given n = 3, there are a total of 5 unique BST's.
 * Developer：jxwang
 * Date：2016, Apr 11
 */
package dynamicProgramming;

import java.util.*;

public class numTrees {
	public static void main(String[] args){
		System.out.print(generateTrees(3));
	}
	public static int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i < n+1; i++){
        	for(int k = 0; k < i; k++){
        		dp[i] += dp[k] * dp[i-k-1]; 
        	}
        }
        return dp[n];
    }
	//95. Unique Binary Search Trees II
	//Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.
	public static List<TreeNode> generateTrees(int n) {
		if(n == 0)
			return new LinkedList<TreeNode>();
        return generateTrees(1,n);
    }
	public static List<TreeNode> generateTrees(int start, int end) {

		List<TreeNode> res = new LinkedList<>();
		if (start > end) {
	        res.add(null);
	        return res;
	    }
		for(int i = start; i <= end; i++){
			List<TreeNode> lefts = generateTrees(start,i-1);
			List<TreeNode> rights = generateTrees(i+1,end);
			for(TreeNode left:lefts){
				for(TreeNode right: rights){
					TreeNode node = new TreeNode(i);
					node.left = left;
					node.right = right;
					res.add(node);
				}
			}
		}
        return res;
	}
}
