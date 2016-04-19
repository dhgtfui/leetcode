package linkedList;

public class Solution82 {
	//82. Remove Duplicates from Sorted List II
	//leaving only distinct numbers from the original list.
		public static ListNode deleteDuplicates3(ListNode head) {
			ListNode dummy = new ListNode(0);
		    dummy.next = head;
		    ListNode p = dummy;
		    while(p.next != null && p.next.next!=null){
		        if(p.next.val == p.next.next.val){
		            int cur = p.next.val;
		            while(p.next!=null && p.next.val == cur){
		                p.next = p.next.next;
		            }
		        }else{
		            p = p.next;
		        }
		 
		    }
		    return dummy.next;
	    }
}
