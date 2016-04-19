/**
 * Function Instruction: 2. Add Two Numbers
 * Description: You are given two linked lists representing two non-negative numbers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.
 * Developer：jxwang
 * Date：2016, Mar 8
 */
package linkedList;

public class Solution2 {
	public static void main(String[] args) {  
        ListNode head1 = new ListNode(1);  
        head1.next = new ListNode(8);  
        //head1.next.next = new ListNode(3);  
        ListNode head2 = new ListNode(0);
        //head2.next = new ListNode(6);
        //head2.next.next = new ListNode(4);
        ListNode head3 = addTwoNumbers(head1,head2);
        for(ListNode i=head3;i!=null;i=i.next){
			System.out.print(i.val+" ");}    
    } 
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        int carry = 0;
        while(l1 != null || l2 != null){
            if(l1 != null){
                carry += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                carry += l2.val;
                l2 = l2.next;
            }
            p.next = new ListNode(carry%10);
            carry /= 10;
            p = p.next;
        }
        if(carry == 1){
            p.next = new ListNode(1);
        }
        return dummy.next;
    }
}
