package linkedList;

public class deleteDuplicates {
	public static void main(String[] args){
		ListNode test = new ListNode(1);
		test.next = new ListNode(2);
		test.next.next = new ListNode(4);
		test.next.next.next = new ListNode(3);
		//test.next.next.next.next = new ListNode(5);
		//test.next.next.next.next.next = new ListNode(2);
		//reorderList(test);
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
        ListNode p = head;
        while(p != null && p.next != null){
        	ListNode tmp = p.next;
        	
        	while(p.val == tmp.val && tmp.next != null){
        		tmp = tmp.next;
        	}
        	if(p.val == tmp.val && tmp.next == null){
        		p.next = null;
        		return head;
        	}
        	p.next = tmp;
        	p = p.next;
        }
        return head;
    }
}
