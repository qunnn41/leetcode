package answer;

import auxiliary.ListNode;

public class ReorderList {
	/**
	 * https://leetcode.com/problems/reorder-list/
	 */
	public void reorderList(ListNode head) {
        if (head == null || head.next == null)
        	return;
        ListNode p = head, mid = head;
        //find median
        while (p.next != null && p.next.next != null) {
        	p = p.next.next;
        	mid = mid.next;
        }
        
        //reverse the half after middle
        ListNode current = mid.next;
        while (current.next != null) {
        	ListNode after = current.next;
        	current.next = after.next;
        	after.next = mid.next;
        	mid.next = after;
        }
        
        
        //concat two list
        ListNode p2 = mid.next;
        p = head;
        while (p != mid) {
        	mid.next = p2.next;
        	p2.next = p.next;
        	p.next = p2;
        	p = p.next.next;
        }
    }
}
