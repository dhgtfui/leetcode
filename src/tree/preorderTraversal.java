/**
 * Function Instruction: LeetCode 144. Binary Tree Preorder Traversal
 * Description: Given a binary tree, return the preorder traversal of its nodes' values.
 * Developer：jxwang
 * Date：2016, Mar 13
 */
package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class preorderTraversal {
	public static void main(String[] args){
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		System.out.print(preorderTraversal1(n1));
		//System.out.print(inorderTraversal1(n1));
		//System.out.print(postorderTraversal1(n1));
	}
	//144. Binary Tree Preorder Traversal
	//recursion solution
	public static List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
	    if(root == null)
	        	return res;
	    res.add(root.val);
	    res.addAll(preorderTraversal(root.left));
	    res.addAll(preorderTraversal(root.right));
	    return res;
	 }
	//iterative solution
	public static List<Integer> preorderTraversal1(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
	    if(root == null)
	        	return res;
	    TreeNode p =root;
	    stack.push(p);
	    while(!stack.isEmpty()){
	    	p = stack.pop();
	    	res.add(p.val);
	    	if(p.right != null)
	    		stack.push(p.right);
	    	if(p.left != null)
	    		stack.push(p.left);
	    }
	    return res;
	 }
	//94. Binary Tree Inorder Traversal
	public static List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
	    if(root == null)
	        	return res;
	    
	    res.addAll(inorderTraversal(root.left));
	    res.add(root.val);
	    res.addAll(inorderTraversal(root.right));
	    return res;  
	    }
	//iterative solution
	public static List<Integer> inorderTraversal1(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if(root == null)
			return null;
		Stack<TreeNode> stack = new Stack<>();
		TreeNode p = root;
		while(p != null){
			stack.push(p);
			p = p.left;
		}
		while(!stack.isEmpty()){
			p = stack.pop();
			res.add(p.val);
			p = p.right;
			while(p != null){
				stack.push(p);
				p = p.left;
			}			
		}
		return res;
	}
	//145. Binary Tree Postorder Traversal
	public static List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
	    if(root == null)
	        	return res;
	    
	    res.addAll(postorderTraversal(root.left));
	    res.addAll(postorderTraversal(root.right));
	    res.add(root.val);
	    return res;  
	    }
	//iterative solution
	public static List<Integer> postorderTraversal1(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
	    Stack<TreeNode> stack = new Stack<TreeNode>();
	    TreeNode prev = null; // previously traversed node
	    TreeNode curr = root;

	    if (root == null) {
	        return result;
	    }

	    stack.push(root);
	    while (!stack.empty()) {
	        curr = stack.peek();
	        if (prev == null || prev.left == curr || prev.right == curr) { // traverse down the tree
	            if (curr.left != null) {
	                stack.push(curr.left);
	            } else if (curr.right != null) {
	                stack.push(curr.right);
	            }
	        } else if (curr.left == prev) { // traverse up the tree from the left
	            if (curr.right != null) {
	                stack.push(curr.right);
	            }
	        } else { // traverse up the tree from the right
	            result.add(curr.val);
	            stack.pop();
	        }
	        prev = curr;
	    }

	    return result;
    }
}
