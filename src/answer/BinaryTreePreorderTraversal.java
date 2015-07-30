package answer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import auxiliary.TreeNode;

public class BinaryTreePreorderTraversal {
	/**
	 * https://leetcode.com/problems/binary-tree-preorder-traversal/
	 */
	public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<Integer>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
        	TreeNode t = stack.pop();
        	if (t != null) {
        		result.add(t.val);
        		stack.push(t.right);
        		stack.push(t.left);
        	}
        }
        return result;
    }
}
