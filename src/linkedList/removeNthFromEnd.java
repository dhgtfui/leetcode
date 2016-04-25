//19. Remove Nth Node From End of List
package linkedList;

public class removeNthFromEnd {
	public static void main(String[] args){
		ListNode test = new ListNode(1);
		test.next = new ListNode(2);
		test.next.next = new ListNode(3);
		test.next.next.next = new ListNode(4);
		test.next.next.next.next = new ListNode(5);
		//test.next.next.next.next.next = new ListNode(2);
		removeNthFromEnd(test, 2);
		for(ListNode cur = test; cur != null; cur = cur.next){
			System.out.print(cur.val + " ");
		}
	}
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode fast = dummy;
		ListNode slow = dummy;
        for(int i = 0; i <= n; i++){
        	fast = fast.next;
        }
        if(fast == null){
        	dummy.next = head.next;
        	return dummy.next;
        }   
        while(fast != null){
        	fast = fast.next;
        	slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
