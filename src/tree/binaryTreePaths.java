/**
 * Function Instruction: LeetCode 257. Binary Tree Paths
 * Developer：jxwang
 * Description: Given a binary tree, return all root-to-leaf paths.
 * Date：2016, Mar 12
 */
package tree;

import java.util.ArrayList;
import java.util.List;

public class binaryTreePaths {
	public static void main(String[] args) {  
        TreeNode n1 = new TreeNode(1);  
        TreeNode n2 = new TreeNode(2);  
        TreeNode n3 = new TreeNode(3);  
        //TreeNode n4 = new TreeNode(4);  
        TreeNode n5 = new TreeNode(5);  
        n1.left = n2;  
        n1.right = n3;    
        //System.out.println(binaryTreePaths(n1));  
        //n2.left = n4;  
        //System.out.println(binaryTreePaths(n1));  
        n2.right = n5;  
        System.out.println(binaryTreePaths(n1));  
    }  
	public static List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
        if(root == null)
        	return res;
        helper(root,String.valueOf(root.val),res);
        return res;
    }
    public static void helper(TreeNode root, String path, List<String> result){
    	if(root == null)
    		return;
    	if(root.left == null && root.right == null){
    		result.add(path);
    	}
    	if(root.left != null){
    		helper(root.left, path + "->" + String.valueOf(root.left.val), result);
    	}
    	if(root.right != null){
    		helper(root.right, path + "->" + String.valueOf(root.right.val), result);
    	}
    }
    
}
