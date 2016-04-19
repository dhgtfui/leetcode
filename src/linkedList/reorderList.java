package linkedList;

public class reorderList {
	public static void main(String[] args){
		ListNode test = new ListNode(1);
		test.next = new ListNode(2);
		test.next.next = new ListNode(3);
		//test.next.next.next = new ListNode(4);
		//test.next.next.next.next = new ListNode(5);
		//test.next.next.next.next.next = new ListNode(2);
		reorderList(test);
		for(ListNode cur = test; cur != null; cur = cur.next){
			System.out.print(cur.val + " ");
		}
	}
	//143. Reorder List
		public static void reorderList(ListNode head) {
			if (head == null || head.next == null) 
	            return;
	        //1.break into 2 parts: head + head2
	        ListNode slow = head;
	        ListNode fast = head.next;
	        while(fast != null && fast.next != null){
	            slow = slow.next;
	            fast = fast.next.next;
	        }
	        ListNode p = slow.next;
	        slow.next = null;
	        //2.reverse head2
	        ListNode head2 = null;
	        while(p != null){
	        	ListNode tmp = p.next;
	        	p.next = head2;
	        	head2 = p;
	        	p = tmp;
	        }
	        
	      //3.merge head + head2
	        ListNode a = head, b = head2;
	        while (a != null && b != null) {
	            ListNode tmp1 = a.next;
	            ListNode tmp2 = b.next;
	            a.next = b;
	            b.next = tmp1;
	            a = tmp1;
	            b = tmp2;
	        }
		    
		}	
		public static void reorderList2(ListNode head) {
		    if (head == null || head.next == null) {
		        return;
		    }
		    ListNode slow = head, fast = head;
		    while (fast != null) {
		        if (fast.next != null && fast.next.next != null) {
		            fast = fast.next.next;
		            slow = slow.next;
		        }
		        else {
		            fast = null;
		        }
		    }
		    // if length = 2, slow point to 1st
		    // if length = 3, slow point to 2nd
		    // if length = 4, slow point to 2nd
		    ListNode secondHalf = slow.next;
		    slow.next = null;
		    // now reverse secondHalf
		    ListNode p = secondHalf;
		    while (p.next != null) {
		        ListNode tail = p.next.next;
		        p.next.next = secondHalf;
		        secondHalf = p.next;
		        p.next = tail;
		    }
		    // now merge 2 list: head and secondHalf
		    ListNode a = head, b = secondHalf;
		    while (a != null && b != null) {
		        ListNode temp1 = a.next;
		        ListNode temp2 = b.next;
		        a.next = b;
		        b.next = temp1;
		        a = temp1;
		        b = temp2;
		    }
		}
}
