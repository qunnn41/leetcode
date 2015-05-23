package answer;

import auxiliary.ListNode;

public class SortList {
	/**
	 * https://leetcode.com/problems/sort-list/
	 */
	private ListNode merge(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(-1);
		ListNode cur = head;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				cur.next = l1;
				cur = cur.next;
				l1 = l1.next;
			} else {
				cur.next = l2;
				cur = cur.next;
				l2 = l2.next;
			}
		}
		
		if (l1 == null) cur.next = l2;
		else cur.next = l1;
		return head.next;
	}
	public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
        	return head;
        ListNode p1 = head;
        ListNode p2 = head;
        ListNode pre = head;
        while (p2 != null && p2.next != null) {
        	pre = p1;
        	p1 = p1.next;
        	p2 = p2.next.next;
        }
        
        pre.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(p1);
        
        return merge(l1, l2);
    }
}
