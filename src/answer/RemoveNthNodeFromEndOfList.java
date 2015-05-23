package answer;

import auxiliary.ListNode;

public class RemoveNthNodeFromEndOfList {
	/**
	 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
	 */
	public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p1 = head;
        while (n > 0 && p1 != null) {
            p1 = p1.next;
            n --;
        }
        
        if (p1 == null)
            return head.next;
        
        ListNode p2 = head;
        while (p1.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        
        ListNode remove = p2.next.next;
        p2.next = remove;
        return head;
    }
}
