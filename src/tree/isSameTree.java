/**
 * Function Instruction: LeetCode 100. Same Tree
 * Description: Given two binary trees, write a function to check if they are equal or not.
 * Developer：jxwang
 * Date：2016, Mar 13
 */
package tree;

public class isSameTree {
	public static void main(String[] args) {  
        TreeNode n1 = new TreeNode(1);  
        TreeNode n2 = new TreeNode(2);  
        TreeNode n3 = new TreeNode(3);
        TreeNode n11 = new TreeNode(1);  
        TreeNode n12 = new TreeNode(2);  
        TreeNode n13 = new TreeNode(3);
        TreeNode n7 = new TreeNode(7);  
        
        n1.left = n2; 
        n1.right = n3;
        n11.left = n12;
        n11.right = n13; 
        System.out.println(isSameTree(n1,n11));  
    } 
	
	public static boolean isSameTree(TreeNode p, TreeNode q) {
		if(p == null && q == null)
			return true;
		else if(p == null && q != null)
        	return false;
        else if(p != null && q == null)
        	return false;
        else if(p != null && q != null && p.val != q.val)
        	return false;
        else{
        	return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }
    }
}
