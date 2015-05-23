package answer;

import auxiliary.ListNode;

public class LinkedListCycle {
	/**
	 * https://leetcode.com/problems/linked-list-cycle/
	 */
	public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
        ListNode p = head, q = head;
        while (q != null && q.next != null) {
            p = p.next;
            q = q.next.next;
            
            if (p == q)
                return true;
        }
        return false;
    }
}
