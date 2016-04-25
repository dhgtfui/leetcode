/**
 * Function Instruction: LeetCode 86. Partition List
 * Description: Given a linked list and a value x, 
 * partition it such that all nodes less than x come before nodes greater than or equal to x.
 * Developer：jxwang
 * Date：2016, Apr 25
 */
package linkedList;

public class partition {
	public static void main(String[] args) {  
        ListNode head = new ListNode(2);  
        head.next = new ListNode(1);  
        //head.next.next = new ListNode(3);  
        //head.next.next.next = new ListNode(2);  
        //head.next.next.next.next = new ListNode(1);  
        ListNode head3= partition(head,2);
        for(ListNode i=head3;i!=null;i=i.next){
			System.out.print(i.val+" ");}   
    } 
	public static ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);
        ListNode head1 = dummy1;
        ListNode head2 = dummy2;
        ListNode p = head;
        while(p != null){
            if(p.val < x){
                head1.next = p; 
                head1 = head1.next;
            }
            else{
                head2.next = p; 
                head2 = head2.next;
            }
            p = p.next;
        }
        head2.next = null;
        head1.next = dummy2.next;
        
        //p.next = dummy2.next;
        return dummy1.next;
    }
}
