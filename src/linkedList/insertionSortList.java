/**
 * Function Instruction: LeetCode 147. Insertion Sort List
 * Developer：jxwang
 * Date：2016, Mar 10
 */
package linkedList;
//Sort a linked list using insertion sort.
public class insertionSortList {
	public static void main(String[] args){
		ListNode test = new ListNode(10);
		test.next = new ListNode (10);
		//test.next.next = new ListNode (7);
		//test.next.next.next = new ListNode(6);
		//test.next.next.next.next = new ListNode(5);
		//test.next.next.next.next.next = new ListNode(8);
		//test.next.next.next.next.next.next = new ListNode(6);
		test = insertionSortList(test);
		for(ListNode current = test; current != null;current = current.next){
			System.out.print(current.val + " ");
		}
	}
	public static ListNode insertionSortList(ListNode head) {
		if(head == null)
            return head;
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode p = dummy;
        while(p.next != null){
            if(p.val <= p.next.val){
                p = p.next;
            }
            else{
            	//insert q into r->r.next
                ListNode q = p.next;
                ListNode r = dummy;
                while(r.next.val < q.val ){
                    r = r.next;
                }
                p.next = q.next; 
                if(q == r.next){
                	q.next = head;
                	return head;
                }
                else{
                q.next = r.next;
                r.next = q;}         
            }
        }
        return dummy.next;
    }
}
