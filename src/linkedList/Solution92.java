//92. Reverse Linked List II
package linkedList;

public class Solution92 {
	public static void main(String[] args){
		ListNode ll = new ListNode(1);
		ll.next = new ListNode(2);
		ll.next.next = new ListNode(3);
		ll.next.next.next = new ListNode(4);
		ll.next.next.next.next = new ListNode(5);
		ListNode l2=removeNthFromEnd(ll,5);
		for(ListNode current = l2; current != null;current = current.next){
			System.out.print(current.val + " ");
		}
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
	//removeNthFromEnd
	public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode prehead = new ListNode(-1);
        prehead.next = head;
		ListNode slow = head;
        ListNode fast = head;
        
        for(int i = 0; i < n; i++)
        	fast = fast.next;
        if(fast == null){
        	prehead.next = slow.next;
        	return prehead.next;
        }
        while(fast.next != null){
        	slow = slow.next;
        	fast = fast.next;
        }
        slow.next = slow.next.next;
        return prehead.next;
    }
}
