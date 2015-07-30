package answer;

import auxiliary.TreeNode;

public class LCAinBST {
	/**
	 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		int min = Math.min(p.val, q.val);
		int max = Math.max(p.val, q.val);
		
		while (root.val < min || root.val > max) {
			while (root.val < min)
				root = root.right;
			while (root.val > max)
				root = root.left;
		}
		return root;
	}
}
