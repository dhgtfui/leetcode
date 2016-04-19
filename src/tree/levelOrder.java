/**
 * Function Instruction: LeetCode 102. Binary Tree Level Order Traversal
 * Description: Given a binary tree, return the level order traversal of its nodes' values. 
 * (ie, from left to right, level by level).
 * Developer：jxwang
 * Date：2016, Mar 13
 */
package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class levelOrder {
	public static void main(String[] args) {  
        TreeNode n1 = new TreeNode(1);  
        TreeNode n2 = new TreeNode(2);  
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);  
        TreeNode n5 = new TreeNode(5);      
        n1.left = n2; 
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;
        System.out.println(levelOrderBottom(n1));  
    } 
	//107. Binary Tree Level Order Traversal II
	//return the bottom-up level order traversal of its nodes' values. 
	//(ie, from left to right, level by level from leaf to root).
	public static List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> res = new LinkedList<>();
        //List<Integer> tmp = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 1;
        while(!queue.isEmpty()){
            List<Integer> tmp = new LinkedList<>();
            int tmpCount = 0;
            for(int i = 0; i < count; i++){
                TreeNode node = queue.poll();
                if(node != null){
                    tmp.add(node.val);
                    queue.offer(node.left);
                    queue.offer(node.right);
                    tmpCount +=2;
                }
            }
            if(!tmp.isEmpty()){
                res.add(0, tmp);
            }
            count = tmpCount;   
        }
        return res;
    }
	public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        //List<Integer> tmp = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 1;
        while(!queue.isEmpty()){
            List<Integer> tmp = new LinkedList<>();
            int tmpCount = 0;
            for(int i = 0; i < count; i++){
                TreeNode node = queue.poll();
                if(node != null){
                    tmp.add(node.val);
                    queue.offer(node.left);
                    queue.offer(node.right);
                    tmpCount +=2;
                }
            }
            if(!tmp.isEmpty()){
                res.add(tmp);
            }
            count = tmpCount;   
        }
        return res;
    }
}
