/**
 * Function Instruction: LeetCode 235. Lowest Common Ancestor of a Binary Search Tree
 * Description: Given a binary search tree (BST), 
 * find the lowest common ancestor (LCA) of two given nodes in the BST.
 * Developer：jxwang
 * Date：2016, Mar 13
 */
package tree;

import java.util.ArrayList;
import java.util.List;

public class lowestCommonAncestor {
	public static void main(String[] args){
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		n1.left = n2;
		n1.right = n3;
		List<TreeNode> pathp = new ArrayList<>();
		getPath(n1, n2, pathp);
		System.out.print(lowestCommonAncestor1(n1,n2,n3).val);
	}
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == root || q == root)
        	return root;
        if(Math.max(p.val,q.val) < root.val)
        	return lowestCommonAncestor(root.left,p,q);	
        else if(Math.min(p.val,q.val) > root.val)
        	return lowestCommonAncestor(root.right,p,q);
        else
        	return root;
    }
	//236. Lowest Common Ancestor of a Binary Tree
	public static TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null || p == root || q == root)
        	return root;
		//traverse pathp and pathq
		List<TreeNode> pathp = new ArrayList<>();
		List<TreeNode> pathq = new ArrayList<>();
		pathp.add(root);  
        pathq.add(root); 
		getPath(root, p, pathp);
		getPath(root, q, pathq);
		TreeNode res = null;
		for(int i = 0; i < pathp.size() && i <pathq.size();i++){
			if(pathp.get(i) == pathq.get(i))
				res = pathp.get(i);
			else
				break;
		}
		return res;	
    }
	public static boolean getPath(TreeNode root, TreeNode p, List<TreeNode> pathp){
		if(root == p)
			return true;
		if(root.left != null){
			pathp.add(root.left);
			if(getPath(root.left,p, pathp))
				return true;
			pathp.remove(pathp.size()-1);
		}
		if(root.right != null){
			pathp.add(root.right);
			if(getPath(root.right,p, pathp))
				return true;
			pathp.remove(pathp.size()-1);
		}
		return false;	
	}
}
