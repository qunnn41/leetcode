package answer;

import java.util.*;

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

	public List<Integer> postorderTraversal2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                result.add(node.val);
                node = node.right;
            }
            node = stack.pop();
            node = node.left;
        }
        Collections.reverse(result);
        return result;
    }
}
