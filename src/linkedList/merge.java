package linkedList;

public class merge {
	public static void main(String[] args){
		ListNode l1 = new ListNode(22);
		ListNode l3 = new ListNode(-1);
		l1.next = new ListNode(71);
		//l1.next.next = new ListNode(-10);
		//System.out.print("l1 is ");
		//for(ListNode current = l1; current != null;current = current.next){
		//	System.out.print(current.val + " ");
		//}
		//System.out.println();
		ListNode l2 = new ListNode(-9);
		l2.next = new ListNode(2);
		l2.next.next = new ListNode(4);
		l2.next.next.next = new ListNode(5);
		//System.out.print("l2 is ");
		//for(ListNode current = l2; current != null;current = current.next){
		//	System.out.print(current.val + " ");
		//}
		//System.out.println();
		ListNode[] lists = {};
		ListNode res=mergeKLists(lists);
		System.out.print(lists.length);
		//for(ListNode current = res; current != null;current = current.next){
			//System.out.print(current.val + " ");
		//}
	}
	//148. Sort List
	public static ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
        	return head;
        ListNode tmp = head;
        int len = 0;
        while(tmp != null){
        	tmp = tmp.next;
        	len++;
        }
        tmp = head;
        for(int i = 1; i < len/2; i++){
        	tmp = tmp.next;
        }
        
        ListNode l1 = head;
        ListNode l2 = tmp.next;
        tmp.next = null;
        
        ListNode res = mergeTwoLists(sortList(l1),sortList(l2));
        return res;
    }
	
	//21. Merge Two Sorted Lists
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1 == null)
			return l2;
		if(l2 == null)
			return l1;
		ListNode dummy = new ListNode(-1);
		ListNode p = dummy;
        while(l1!= null && l2 != null){
        	if(l1.val > l2.val){
        		p.next = l2;
        		p = p.next;
        		l2 = l2.next;
        		
        	}
        	else{
        		p.next = l1;
        		p = p.next;
        		l1 = l1.next;
        	}
        }
        if(l1 != null){
        	p.next = l1;
        }
        if(l2 != null){
        	p.next = l2;
        }
        return dummy.next;
    }
	public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
		if(l1 == null)
			return l2;
		if(l2 == null)
			return l1;
		if(l1.val > l2.val){
			l2.next = mergeTwoLists2(l1,l2.next);
			return l2;}
		else{
			l1.next = mergeTwoLists2(l1.next,l2);
			return l1;
		}
	}
	//23. Merge k Sorted Lists
	public static ListNode mergeKLists(ListNode[] lists) {
		int k = lists.length;
        if(k == 0)
        	return null;
        //divide and conquer
        int i = 2;
        while(i/2 < k){
        	for(int j = 0; j + i/2 < k; j += i){
        		ListNode p = lists[j];
        		p = mergeTwoLists2(p, lists[j + i/2]);
        		lists[j] = p;
        	}
        	i = i *2;
        }
        return lists[0];
        
        /** TLE
        ListNode p = lists[0];
        for(int i = 1; i < n; i++){ 
        	p = merge2Lists(p, lists[i]);
        }
        return p;
         */
    }
}
