/**
 * Function Instruction: 92. Reverse Linked List II
 * Description: Reverse a linked list from position m to n. 
 * Do it in-place and in one-pass.
 * Developer：jxwang
 * Date：2016, Apr 25
 */
package linkedList;

public class reverseBetween {
	public static void main(String[] args){
		ListNode ll = new ListNode(1);
		ll.next = new ListNode(2);
		ll.next.next = new ListNode(3);
		ll.next.next.next = new ListNode(4);
		ll.next.next.next.next = new ListNode(5);
		//ListNode l2=removeNthFromEnd(ll,5);
		//for(ListNode current = l1; current != null;current = current.next){
			//System.out.print(current.val + " ");
		//}
	}
	public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode prehead = new ListNode(-1);
        prehead.next = head;
        ListNode p = prehead;
        for(int i = 1; i < m; i++)
        	p = p.next;
        ListNode rtail = p.next;
        ListNode cur = p.next.next;
        for(int i = 0; i < n - m; i++){
        	ListNode tmp = cur.next;
        	cur.next = p.next;
        	p.next = cur;
        	cur = tmp;
        }
        rtail.next = cur;
        return prehead.next;
    }
}
