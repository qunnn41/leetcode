package answer;

import java.util.ArrayList;
import java.util.List;

import auxiliary.TreeNode;

public class BinaryTreePostorderTraversal {
	/**
	 * https://leetcode.com/problems/binary-tree-postorder-traversal/
	 */
	public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        helper(result, root);
        return result;
    }
	
	private void helper(ArrayList<Integer> list, TreeNode root) {
		if (root == null)
			return;
		helper(list, root.left);
		helper(list, root.right);
		list.add(root.val);
	}
}
