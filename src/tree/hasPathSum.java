/**
 * Function Instruction: LeetCode 112. Path Sum
 * Developer：jxwang
 * Description: Given a binary tree and a sum, determine if the tree has a root-to-leaf path 
 * such that adding up all the values along the path equals the given sum.
 * Date：2016, Mar 12
 */
package tree;

public class hasPathSum {
	public static void main(String[] args){
		TreeNode n1 = new TreeNode(5);  
        TreeNode n2 = new TreeNode(4);  
        TreeNode n3 = new TreeNode(8);  
        TreeNode n4 = new TreeNode(11);  
        TreeNode n5 = new TreeNode(13);  
        TreeNode n6 = new TreeNode(4);  
        TreeNode n7 = new TreeNode(7);  
        TreeNode n8 = new TreeNode(2);  
        TreeNode n9 = new TreeNode(1); 
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n4.left = n7;
        n4.right = n8;
        n3.left = n5;
        n3.right = n6;
        n6.right = n9;
        System.out.println(hasPathSum(n9,0));  
	}
	static boolean state = false;
    public static boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
            return state;
        helper(root, sum,0);
        return state;
    }
    public static void helper(TreeNode root, int sum, int s){
        if(state == true)
            return;
        if(root.left == null && root.right == null){
            if(s + root.val == sum){
                state = true;
            }
            return;
        }
        if(root.left != null)
            helper(root.left, sum, root.val+s);
        if(root.right != null)
            helper(root.right, sum, root.val+s);
    }
}
