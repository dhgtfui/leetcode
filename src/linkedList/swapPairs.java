//24. Swap Nodes in Pairs Mar 9
//Given a linked list, swap every two adjacent nodes and return its head.
package linkedList;

public class swapPairs {
	public static void main(String[] args){
		ListNode test = new ListNode(1);
		test.next = new ListNode(2);
		test.next.next = new ListNode(3);
		test.next.next.next = new ListNode(4);
		test.next.next.next.next = new ListNode(5);
		//test.next.next.next.next.next = new ListNode(2);
		test=reverseKGroup(test,3); //3 2 1 4 5
		for(ListNode cur = test; cur != null; cur = cur.next){
			System.out.print(cur.val + " ");
		}
	}
	public static ListNode swapPairs(ListNode head) {
		if(head == null || head.next == null)
			return head;
        ListNode p = head.next;
        head.next = swapPairs(p.next);
        p.next = head;
        return p;
    }
	public static ListNode reverseKGroup(ListNode head, int k) {
		if(head == null || k <= 0)
            return head;
        //1. confirm first k nodes
        ListNode p = head;
        for(int i = 0; i < k; i++){
            if(p == null)
                return head;
            p = p.next;
        }
        //2. reverse the first group including k nodes
        ListNode rTail = null, head2 = head;
        for(int i = 0; i < k; i++){
            ListNode tmp = head2.next;
            head2.next = rTail;
            rTail = head2;
            head2 = tmp;
        }
        //3. call recursion
        head.next = reverseKGroup(p,k);
        return rTail;
    }
}
