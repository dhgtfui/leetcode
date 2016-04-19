/**
 * Function Instruction: LeetCode 110. Balanced Binary Tree
 * Description: Given a binary tree, determine if it is height-balanced.
 * Developer：jxwang
 * Date：2016, Mar 13
 */
package tree;

public class isBalanced {
	public static void main(String[] args) {  
        TreeNode n1 = new TreeNode(1);  
        TreeNode n2 = new TreeNode(2);  
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);  
        TreeNode n5 = new TreeNode(5);  
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);  
        TreeNode n8 = new TreeNode(8);  
        n1.left = n2; 
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n4.left = n7;
        n3.right = n6;
        n6.right = n8;
         
        System.out.println(isBalanced(n1));  
    }  
	//For this problem, a height-balanced binary tree is defined as a binary tree 
	//in which the depth of the two subtrees of every node never differ by more than 1.
	static boolean res = true;
	public static boolean isBalanced(TreeNode root) {
        res = true;
        helper(root);
        return res;
    }
	public static int helper(TreeNode root){
		if(root == null || res == false)
			return 0;
		int a = helper(root.left);
		int b = helper(root.right);
		if(Math.abs(a - b) > 1) res = false;  
		//res = Math.abs(a-b) > 1 ? false:true;
		return Math.max(a, b) + 1;	       
	}
}
