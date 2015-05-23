package answer;

import auxiliary.ListNode;

public class RotateList {
	/**
	 * https://leetcode.com/problems/rotate-list/
	 */
	public ListNode rotateRight(ListNode head, int k) {
		if (k == 0 || head == null)
            return head;
        int length = 1;
        ListNode p = head;
        while (p.next != null) {
        	p = p.next;
        	++ length;
        }
        
        p.next = head;
        int n = k % length;
        for (int i = 0; i < length - n + 1; ++i)
        	p = p.next;
        
        ListNode result = p;
        for (int i = 0; i < length - 1; ++i) {
        	p = p.next;
        }
        p.next = null;
        return result;
    }
}
