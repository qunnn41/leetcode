package answer;

import java.util.LinkedList;
import java.util.List;

import auxiliary.TreeNode;

public class BinaryTreePaths {
	/**
	 * https://leetcode.com/problems/binary-tree-paths/
	 */
	private LinkedList<String> result;
	public List<String> binaryTreePaths(TreeNode root) {
		result = new LinkedList<String>();
		helper(root, "");
		return result;
	}
	
	private void helper(TreeNode node, String val) {
		if (node == null)
			return;
		if (node.left == null && node.right == null) {
			//leaf
			if (val.length() == 0)
				result.add(node.val + "");
			else
				result.add(val + "->" + node.val);
			return;
		}
		
		if (node.left != null)
			if (val.length() == 0)
				helper(node.left, node.val + "");
			else
				helper(node.left, val + "->" + node.val);
		
		if (node.right != null)
			if (val.length() == 0)
				helper(node.right, node.val + "");
			else
				helper(node.right, val + "->" + node.val);
	}
}
