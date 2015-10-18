package answer;

import auxiliary.TreeNode;

public class InvertBinaryTree {
	/**
	 * https://leetcode.com/problems/invert-binary-tree/
	 */
	public TreeNode invertTree(TreeNode root) {
        if (root == null)
        	return null;
        TreeNode left = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(left);
        
        return root;
    }
}
