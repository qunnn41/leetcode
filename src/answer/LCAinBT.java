package answer;

import auxiliary.TreeNode;

public class LCAinBT {
	/**
	 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (p == root || q == root || root == null)
			return root;
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		return (left != null && right != null) ? root : (left != null) ? left : right;
	}
}
