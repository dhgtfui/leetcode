/**
 * Function Instruction: LeetCode 234. Palindrome Linked List
 * Developer：jxwang
 * Date：2016, Mar 5
 */
package linkedList;

public class Solution234 {
	
	public static void main(String[] args) {  
        ListNode head = new ListNode(1);  
        head.next = new ListNode(2);  
        head.next.next = new ListNode(3);  
        head.next.next.next = new ListNode(2);  
        head.next.next.next.next = new ListNode(1);  
        Solution234 ans = new Solution234();  
        System.out.println(ans.isPalindrome(head));  
    }  
	public static boolean isPalindrome(ListNode head) {  
        if(head == null)
        	return true;
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null && fast.next.next != null){
        	slow = slow.next;
        	fast = fast.next.next;
        }
        ListNode head2 = null;
        ListNode p = slow.next;
        while(p != null){
        	ListNode tmp = p.next;
        	p.next = head2;
        	head2 = p;
        	p = tmp;
        }
        while(head != null && head2 != null){
        	if(head.val != head2.val)
        		return false;
        	head = head.next;
        	head2 = head2.next;
        }
        return true;
    }  
}
