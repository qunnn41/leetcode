package answer;

import auxiliary.TreeNode;

public class CountCompleteTreeNodes {
	/**
	 * https://leetcode.com/problems/count-complete-tree-nodes/
	 */
	public int countNodes(TreeNode root) {
        int h = height(root);
        if (h < 0)
        	return 0;
        
        int r = height(root.right);
        
        /*
         * h=r+1	left is complete
         * h!=r+1	right is complete
         */
        return (h == r + 1) ? (1 << h) + countNodes(root.right) : (1 << h - 1) + countNodes(root.left);
    }
	
	private int height(TreeNode node) {
		return node == null ? -1 : 1 + height(node.left);
	}
}
