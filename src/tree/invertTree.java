/**
 * Function Instruction: LeetCode 226. Invert Binary Tree
 * Description: invert a binary tree.
 * Developer：jxwang
 * Date：2016, Mar 13
 */
package tree;

import java.util.LinkedList;
import java.util.Queue;

public class invertTree {
	//use recursion
	public static TreeNode invertTree(TreeNode root) {
        if(root == null)
            return null;
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = invertTree(right);
        root.right = invertTree(left);
        return root;
    }
	//use BFS
	public static TreeNode invertTree2(TreeNode root) {
		if(root == null)
            return null;
		Queue<TreeNode> queue= new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()){
			TreeNode node = queue.poll();
			TreeNode left = node.left;
			node.left = node.right;
			node.right = left;
			if(node.left != null)
				queue.offer(node.left);
			if(node.right != null)
				queue.offer(node.right);
		}
		return root;
	}
}
