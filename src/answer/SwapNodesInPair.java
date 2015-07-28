package answer;

import auxiliary.ListNode;

public class SwapNodesInPair {
	/**
	 * https://leetcode.com/problems/swap-nodes-in-pairs/
	 */
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode p = head;
		ListNode h = new ListNode(-1);
		ListNode t = h;
		
		while (p != null && p.next != null) {
			ListNode q = p.next;
			p.next = q.next;
			q.next = p;
			p = p.next;
			t.next = q;
			t = t.next.next;
		}
		
		return h.next;
    }
}
