package answer;

import java.util.LinkedList;
import java.util.List;

import auxiliary.TreeNode;



public class UniqueBinaryTreeII {
	/**
	 * https://leetcode.com/problems/unique-binary-search-trees-ii/
	 */
	public List<TreeNode> generateTrees(int n) {
		return generate(1, n);
	}
	
	private List<TreeNode> generate(int start, int end) {
		LinkedList<TreeNode> tree = new LinkedList<TreeNode>();
		if (start > end) {
			tree.add(null); return tree;
		}
		
		for (int rootValue = start; rootValue <= end; ++rootValue) {
			List<TreeNode> leftTree = generate(start, rootValue - 1);
			List<TreeNode> rightTree = generate(rootValue + 1, end);
			for (TreeNode l : leftTree)
				for (TreeNode r : rightTree) {
					TreeNode c = new TreeNode(rootValue);
					c.left = l;
					c.right = r;
					tree.add(c);
				}
		}
		
		return tree;
	}
}
