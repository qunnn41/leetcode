package answer;

import auxiliary.ListNode;

public class ReverseLinkedListII {
	/**
	 * https://leetcode.com/problems/reverse-linked-list-ii/
	 */
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null || head.next == null)
    		return head;
		
		ListNode h = new ListNode(1);
		ListNode result = h;
		h.next = head;
		
		int index = 1;
		while (index < m) {
			index ++;
			h = h.next;
		}
		
		ListNode current = h.next;
		while (index < n) {
			ListNode p = current.next;
			current.next = p.next;
			p.next = h.next;
			h.next = p;
			index ++;
		}
		
		return result.next;
    }
}
