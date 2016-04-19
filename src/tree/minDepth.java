/**
 * Function Instruction: LeetCode 111. Minimum Depth of Binary Tree
 * 104. Maximum Depth of Binary Tree
 * Description: Given a binary tree, find its minimum depth.
 * Developer：jxwang
 * Date：2016, Mar 13
 */
package tree;

public class minDepth {
	public static void main(String[] args) {  
        TreeNode n1 = new TreeNode(1);  
        TreeNode n2 = new TreeNode(2);  
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);  
        TreeNode n5 = new TreeNode(5);      
        n1.left = n2; 
        n1.right = n3;
        n3.left = n4;
        n4.right = n5;
        System.out.println(maxDepth(n1));  
    } 
	static int min = Integer.MAX_VALUE;
	static int cur = 0;
	public static int minDepth(TreeNode root) {
		if (root == null)   
            return 0;  
 
        if (root.left == null)   
            return minDepth(root.right) + 1;  
        else if (root.right == null)   
            return minDepth(root.left) + 1;  
        else   
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;  
    }
	//104. Maximum Depth of Binary Tree
	public static int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        if(root.left == null)
            return maxDepth(root.right) +1;
        else if(root.right == null)
            return maxDepth(root.left) +1;
        else
            return Math.max(maxDepth(root.right), maxDepth(root.left)) +1;
    }
}
