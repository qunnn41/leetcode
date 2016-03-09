package answer;

import auxiliary.TreeNode;

public class RecoverBinarySearchTree {
	/**
	 * https://leetcode.com/problems/recover-binary-search-tree/
	 */
	TreeNode first = null, second = null;
	TreeNode prev = new TreeNode(Integer.MIN_VALUE);
	public void recoverTree(TreeNode root) {
		traverse(root);
		int temp = first.val;
		first.val = second.val;
		second.val = temp;
    }
	
	private void traverse(TreeNode root) {
		if (root == null)
			return;
		traverse(root.left);
		
		if (first == null && prev.val >= root.val) {
			first = prev;
		}
		
		if (first != null && prev.val >= root.val) {
			second = root;
		}
		System.out.println(prev.val + "\t" + root.val);
		prev = root;
		traverse(root.right);
	}
}
