package answer;

import auxiliary.ListNode;
import auxiliary.TreeNode;

public class ConvertSortedListToBinarySearchTree {
	/**
	 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
	 */
	private ListNode node;
	public TreeNode sortedListToBST(ListNode head) {
		if (head == null)
			return null;
		int size = 0;
		
		ListNode current = head;
		node = head;
		while (current != null) {
			current = current.next;
			size ++;
		}
		
		return helper(0, size - 1);
    }
	
	private TreeNode helper(int start, int end) {
		if (start > end)
			return null;
		int mid = (start + end) / 2;
		
		TreeNode left = helper(start, mid - 1);
		
		//after left, node just point to mid
		TreeNode current = new TreeNode(node.val);
		current.left = left;
		node = node.next;
		
		TreeNode right = helper(mid + 1, end);
		current.right = right;

		return current;
	}
}
