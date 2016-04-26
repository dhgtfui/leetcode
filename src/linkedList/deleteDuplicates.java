package linkedList;

public class deleteDuplicates {
	public static void main(String[] args){
		ListNode test = new ListNode(1);
		test.next = new ListNode(3);
		//test.next.next = new ListNode(3);
		//test.next.next.next = new ListNode(4);
		//test.next.next.next.next = new ListNode(5);
		//test.next.next.next.next.next = new ListNode(2);
		deleteDuplicates2(test);
		for(ListNode cur = test; cur != null; cur = cur.next){
			System.out.print(cur.val + " ");
		}
	}
	
	
	//203. Remove Linked List Elements
	public static ListNode removeElements(ListNode head, int val) {
		if(head == null)
        	return head;
        //check head
        ListNode dummy = new ListNode(-1);
        dummy.next =head;
        ListNode p = dummy;
        while(p.next != null){
        	if(p.next.val == val){
        	    ListNode tmp = p.next;
        	    p.next = tmp.next;
        	}
        	else
        	    p = p.next;
        }
        return dummy.next;
    }
	//328. Odd Even Linked List
	public static ListNode oddEvenList(ListNode head) {
		if(head == null || head.next == null)
			return head;
        ListNode oddhead = head;
        ListNode evenhead = head.next;
        ListNode odd = head;
        ListNode even = head.next;
        while(odd.next != null && even.next != null){
        	odd.next = even.next;
            odd = odd.next;

            even.next = odd.next;
            even = even.next;
        	}
		odd.next = evenhead; 
        return head;
    }
	//83. Remove Duplicates from Sorted List
	public static ListNode deleteDuplicates(ListNode head) {
		if(head == null)
	        return head;
	    ListNode pre = head;
	    ListNode cur = head.next;
	    while(cur!=null)
	    {
	        if(cur.val == pre.val)
	            pre.next = cur.next;
	        else    
	            pre = cur;
	        cur = cur.next;
	    }
	    return head;
    }
	
	//82. Remove Duplicates from Sorted List II
	//Description: Given a sorted linked list, delete all nodes that have duplicate numbers, 
	//leaving only distinct numbers from the original list.
	public static ListNode deleteDuplicates2(ListNode head){
		 if(head == null)
		        return head;
		    ListNode dummy = new ListNode(-1);
		    dummy.next = head;
		    ListNode p = dummy;
		    ListNode cur = head;
		    while(cur!=null)
		    {
		        while(cur.next!=null && p.next.val==cur.next.val){
		            cur = cur.next;
		            }
		        if(p.next==cur)
		            p = p.next;
		        else
		            p.next = cur.next;
		        cur = cur.next;
		    }
		    
		    return dummy.next;
	}
}
