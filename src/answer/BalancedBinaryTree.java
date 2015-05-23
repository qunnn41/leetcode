package answer;

import auxiliary.TreeNode;

public class BalancedBinaryTree {
	/**
	 * https://leetcode.com/problems/balanced-binary-tree/
	 */
	public boolean isBalanced(TreeNode root) {
        if (root == null)
        	return true;
        return Depth(root) != -1;
    }
	
	private int Depth(TreeNode node) {
		if (node == null)
			return 0;
		int left = Depth(node.left);
		if (left == -1) return -1;
		int right = Depth(node.right);
		if (right == -1) return -1;
		if (left - right < -1 || left - right > 1)
			return -1;
		return Math.max(left, right) + 1;
	}
}
