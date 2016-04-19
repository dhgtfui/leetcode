/**
 * Function Instruction: LeetCode 129. Sum Root to Leaf Numbers
 * Developer：jxwang
 * Description: Find the total sum of all root-to-leaf numbers.
 * Date：2016, Mar 13
 */
package tree;

public class sumNumbers {
	public static void main(String[] args){
		TreeNode n1 = new TreeNode(0);
		TreeNode n2 = new TreeNode(1);
		TreeNode n3 = new TreeNode(3);
		n1.left = n2;
		//n1.right = n3;
		System.out.print(sumNumbers(n1));
	}
	static int res = 0;
	public static int sumNumbers(TreeNode root) {
		res = 0;
        helper(root,0);
        return res;
    }
	public static void helper(TreeNode root, int sum){
		if(root == null)
			return;
		if(root.left == null && root.right == null){
			res += root.val + sum* 10;
			return;
		}
		if(root.left != null)
			helper(root.left, root.val+ sum*10);
		if(root.right != null)
			helper(root.right, root.val+ sum*10);
	}
}
