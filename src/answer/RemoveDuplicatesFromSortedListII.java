package answer;

import java.util.HashMap;

import auxiliary.ListNode;

public class RemoveDuplicatesFromSortedListII {
	/**
	 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
	 */
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null)
			return head;
		HashMap<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
		ListNode p = head;
		while (p != null) {
			if (hashmap.containsKey(p.val)) {
				int count = hashmap.get(p.val);
				hashmap.put(p.val, count + 1);
			} else {
				hashmap.put(p.val, 1);
			}
			p = p.next;
		}
		
		ListNode result = new ListNode(-1);
		ListNode tail = result;
		p = head;
		while (p != null) {
			if (hashmap.get(p.val) == 1) {
				tail.next = new ListNode(p.val);
				tail = tail.next;
			}
			p = p.next;
		}
		return result.next;
    }
}
