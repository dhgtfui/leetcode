package linkedList;
//160. Intersection of Two Linked Lists
//Write a program to find the node at which the intersection of two singly linked lists begins.

public class getIntersectionNode {
	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if(headA == null || headB == null)
            return null;
        ListNode p = headA;
        while(p.next != null){
            p = p.next;
        }
        p.next = headB;
        //detect headB is cycle or not? If it is, return the cycle begins, otherwise return null
        ListNode res= detectCycle(headA);
        p.next = null;
        return res;
    }
    public static ListNode detectCycle(ListNode head){
        if(head == null || head.next == null)
            return null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast)
                break;
        }
        if(fast.next == null || fast.next.next == null)
            return null;
        
        //find the cycle begin
        slow = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}


