/**
 * Function Instruction: LeetCode 206. Reverse Linked List
 * Developer：jxwang
 * Date：2016, Mar 6
 */
//Reverse a singly linked list.
package linkedList;

import java.util.Stack;

public class Solution206 {
	public static void main(String[] args) {  
        ListNode head = new ListNode(1);  
        head.next = new ListNode(2);  
         
        print_reverse(head);
        System.out.println();
        print_reverse(reverseList(head));  
    } 
	public static ListNode reverseList(ListNode head) {
		if(head == null || head.next == null)
			return head;
		ListNode p = head.next;
		head.next = null;
		while(p != null){
			ListNode tmp = p.next;
			p.next = head;
			head = p;
			p = tmp;
		}
		return head;
    }
	public static void print_reverse(ListNode listNode){
        Stack<ListNode> stack = new Stack<ListNode>();
        //将节点入栈
        while(listNode!=null){
            stack.push(listNode);
            listNode = listNode.next;
        }
        //节点出栈
        while(!stack.empty()){
            System.out.print(stack.pop().val);
        }
    }

}
