package answer;

import auxiliary.ListNode;

public class PartitionList {
	/**
	 * https://leetcode.com/problems/partition-list/
	 */
	public ListNode partition(ListNode head, int x) {
        ListNode less = new ListNode(-1);
        ListNode great = new ListNode(-1);
        ListNode tail_l = less, tail_g = great;
        
        while (head != null) {
        	if (head.val < x) {
        		tail_l.next = new ListNode(head.val);
        		tail_l = tail_l.next;
        	} else {
        		tail_g.next = new ListNode(head.val);
        		tail_g = tail_g.next;
        	}
        	head = head.next;
        }
        
        tail_l.next = great.next;
        return less.next;
    }
}
