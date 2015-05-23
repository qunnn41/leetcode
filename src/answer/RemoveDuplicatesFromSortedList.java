package answer;

import java.util.HashSet;

import auxiliary.ListNode;

public class RemoveDuplicatesFromSortedList {
	/**
	 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
	 */
	public ListNode deleteDuplicates(ListNode head) {
        ListNode result = new ListNode(-1);
        HashSet<Integer> map = new HashSet<Integer>();
        ListNode p = head, tail = result;
        while (p != null) {
            if (!map.contains(p.val)) {
                tail.next = new ListNode(p.val);
                tail = tail.next;
                map.add(p.val);
            }
            p = p.next;
        }
        
        return result.next;
    }
}
