package answer;

import auxiliary.TreeNode;

public class MinimumDepthOfBinaryTree {
	/**
	 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
	 */
	public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null)
            return 1 + minDepth(root.right);
        if (root.right == null)
            return 1 + minDepth(root.left);
        return 1 + Math.min(minDepth(root.right), minDepth(root.left));
    }
}
