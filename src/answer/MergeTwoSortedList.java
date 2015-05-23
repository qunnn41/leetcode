package answer;

import auxiliary.ListNode;

public class MergeTwoSortedList {
	/**
	 * https://leetcode.com/problems/merge-two-sorted-lists/
	 */
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(-1), tail = result;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                ListNode p = new ListNode(l1.val);
                tail.next = p;
                tail = p;
                l1 = l1.next;
            } else {
                ListNode p = new ListNode(l2.val);
                tail.next = p;
                tail = p;
                l2 = l2.next;
            }
        }
        
        if (l1 == null) {
            tail.next = l2;
        } else {
            tail.next = l1;
        }
        
        return result.next;
    }
}
