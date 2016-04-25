/**
 * Function Instruction: 328. Odd Even Linked List
 * Description: Given a singly linked list, 
 * group all odd nodes together followed by the even nodes. 
 * Please note here we are talking about the node number and not the value in the nodes.
 * The program should run in O(1) space complexity and O(nodes) time complexity.
 * Developer：jxwang
 * Date：2016, Mar 8
 */
package linkedList;

public class oddEvenList {
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
}
