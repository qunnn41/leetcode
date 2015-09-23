package answer;

import java.util.Comparator;
import java.util.PriorityQueue;

import auxiliary.ListNode;

public class MergeKSortedLists {
	/**
	 * https://leetcode.com/problems/merge-k-sorted-lists/
	 */
	public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;
		int k = lists.length;
		PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(k, new Comparator<ListNode>() {
			public int compare(ListNode node1, ListNode node2) {
				return node1.val - node2.val;
			}
		});
		
		ListNode head = new ListNode(1);
		ListNode tail = head;
		
		for (ListNode node : lists) {
			if (node != null) {
				queue.add(node);
			}
		}
		
		while (!queue.isEmpty()) {
			ListNode node = queue.poll();
			tail.next = node;
			tail = node;
			if (node.next != null)
			    queue.add(node.next);
		}
		
		return head.next;
    }
}
