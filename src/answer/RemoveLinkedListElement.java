package answer;

import auxiliary.ListNode;

public class RemoveLinkedListElement {
	/**
	 * https://leetcode.com/problems/remove-linked-list-elements/
	 */
	public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val)
        	head = head.next;
        if (head == null)
        	return head;
        ListNode p = head, pp = p;
        while (p != null) {
        	if (p.val == val) {
        		pp.next = p.next;
        		p = pp.next;
        	} else {
        		pp = p;
        		p = p.next;
        	}
        }
        return head;
    }
}
