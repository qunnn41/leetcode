package answer;

import auxiliary.ListNode;

public class LinkedListCycleII {
	/**
	 * https://leetcode.com/problems/linked-list-cycle-ii/
	 */
	public ListNode detectCycle(ListNode head) {
        if (head == null)
            return null;
        ListNode p = head, q = head;
        while (q != null && q.next != null) {
            p = p.next;
            q = q.next.next;
            
            if (p == q) {
                q = head;
                while (q != p) {
                    q = q.next;
                    p = p.next;
                }
                return p;
            }
            
        }
        return null;
    }
}
