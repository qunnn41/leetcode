package answer;

import auxiliary.TreeNode;

public class SumRootToLeafNumber {
	/**
	 * https://leetcode.com/problems/sum-root-to-leaf-numbers/
	 */
	private int result = 0;
	public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return result;
    }
	
	private void helper(TreeNode node, int val) {
		if (node == null)
			return;
		if (node.left == null && node.right == null) {
			result += val + (node.val);
			return;
		}
		
		helper(node.left, (val + node.val) * 10);
		helper(node.right, (val + node.val) * 10);
	}
}
