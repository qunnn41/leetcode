package answer;

import auxiliary.TreeNode;

public class KthSmallestElementInABST {
	/**
	 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
	 */
	public int kthSmallest(TreeNode root, int k) {
        int leftNum = count(root.left);
        
        if (leftNum + 1 == k)
        	return root.val;
        
        return (leftNum + 1 > k) ? kthSmallest(root.left, k) : kthSmallest(root.right, k - leftNum - 1);
    }
	
	private int count(TreeNode node) {
		if (node == null)
			return 0;
		return 1 + count(node.left) + count(node.right);
	}
}
