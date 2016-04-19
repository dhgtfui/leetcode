/**
 * Function Instruction: LeetCode 101. Symmetric Tree
 * Description: nvert a binary tree.
 * Developer：jxwang
 * Date：2016, Mar 13
 */
package tree;

public class isSymmetric {
	public static void main(String[] args) {  
        TreeNode n1 = new TreeNode(2);  
        TreeNode n2 = new TreeNode(1);  
        TreeNode n3 = new TreeNode(1);
        TreeNode n4 = new TreeNode(4);  
        TreeNode n5 = new TreeNode(4);      
        n1.left = n2; 
        n1.right = n3;
        //n3.left = n4;
        //n3.right = n5;
        System.out.println(isSymmetric(n1));  
    }
	static boolean state = true;
	public static boolean isSymmetric(TreeNode root) {
        if(root == null)
        	return true;
        else
            return symmetric(root.left, root.right);
    }
	public static boolean symmetric(TreeNode p, TreeNode q){
		if(p == null && q == null)
			return true;
		else if(p != null && q == null)
			return false;
		else if(p == null && q != null)
			return false;
		else 
			return p.val == q.val&& symmetric(p.left,q.right) && symmetric(q.right,q.left);
	}
}
