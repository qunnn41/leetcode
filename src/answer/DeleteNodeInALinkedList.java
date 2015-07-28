package answer;

import auxiliary.ListNode;

public class DeleteNodeInALinkedList {
	/**
	 * https://leetcode.com/problems/delete-node-in-a-linked-list/
	 */
	public void deleteNode(ListNode node) {
        if (node != null && node.next != null) {
        	node.val = node.next.val;
        	node.next = node.next.next;
        }
    }
}
