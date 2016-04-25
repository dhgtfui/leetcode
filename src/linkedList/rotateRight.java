package linkedList;

public class rotateRight {
	public static void main(String[] args){
		ListNode test = new ListNode(1);
		test.next = new ListNode(2);
		test.next.next = new ListNode(3);
		test.next.next.next = new ListNode(4);
		test.next.next.next.next = new ListNode(5);
		//test.next.next.next.next.next = new ListNode(2);
		test=rotateRight2(test,1); //4 5 1 2 3
		for(ListNode cur = test; cur != null; cur = cur.next){
			System.out.print(cur.val + " ");
		}
	}
	public static ListNode rotateRight2(ListNode head, int k) {
        if(head == null || k == 0 || head.next == null)
			return head;
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		int len = 1;
		ListNode p = head;  
		while (p.next != null) {  
            len ++;  
            p = p.next;  
        }
		k = k % len;
		if(k == 0)
			return head;
        p = head;
        for(int i = 1; i < len-k; i++){
            p = p.next;
        }
        ListNode newhead = p.next;
        p.next = null;
        p = newhead;
        while(p.next != null)
            p = p.next;
        p.next = dummy.next;
        return newhead;
    }
	public static ListNode rotateRight(ListNode head, int k) {
		if(head == null || k == 0 || head.next == null)
			return head;
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		int len = 1;
		ListNode p = head;  
		while (p.next != null) {  
            len ++;  
            p = p.next;  
        }
		k = k % len;
		if(k == 0)
			return head;
        ListNode slow = head;
        ListNode fast = head;
        for(int i = 0; i < k; i++){
        		fast = fast.next;
        }
        while(fast.next != null){
        	slow = slow.next;
        	fast = fast.next;
        }
        p = slow.next;
        ListNode cur = dummy;
        
        while(p != fast){
        	ListNode tmp = p.next;
            slow.next = tmp;
            p.next = head;
            cur.next = p;
            cur = cur.next;
            p = slow.next; 	      	
        }
        p.next = head;
        cur.next = p;
    	slow.next = null;
        return dummy.next;
    }
}
