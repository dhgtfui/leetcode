/**
 * Function Instruction: LeetCode 113. Path Sum II
 * Developer：jxwang
 * Description: Given a binary tree and a sum, 
 * find all root-to-leaf paths where each path's sum equals the given sum.
 * Date：2016, Mar 13
 */
package tree;

import java.util.ArrayList;
import java.util.List;

public class pathSum {
	public static void main(String[] args){
		TreeNode n1 = new TreeNode(5);  
        TreeNode n2 = new TreeNode(4);  
        TreeNode n3 = new TreeNode(8);  
        TreeNode n4 = new TreeNode(11);  
        TreeNode n5 = new TreeNode(13);  
        TreeNode n6 = new TreeNode(4);  
        TreeNode n7 = new TreeNode(7);  
        TreeNode n8 = new TreeNode(2);  
        TreeNode n9 = new TreeNode(5); 
        TreeNode n10 = new TreeNode(1); 
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n4.left = n7;
        n4.right = n8;
        n3.left = n5;
        n3.right = n6;
        n6.right = n10;
        n6.left = n9;
        TreeNode n19 = null;
        System.out.println(pathSum(n19,22));  
	}
	public static List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> path = new ArrayList<>();
		helper(res, path, root, sum, 0);
		return res;
    }
	public static void helper(List<List<Integer>> res, List<Integer> path, TreeNode root, int sum, int s){
		if(root == null)
            return;
		if(root.left == null && root.right == null){
			if(root.val + s == sum){
				path.add(root.val);
				res.add(new ArrayList<Integer>(path));
				path.remove(path.size()-1);
			}
			return;
		}
		path.add(root.val);
		if(root.left != null)
			helper(res, path, root.left,sum, s+root.val);
		if(root.right != null)
			helper(res, path, root.right,sum, s+root.val);	
		path.remove(path.size()-1);
	}
}
