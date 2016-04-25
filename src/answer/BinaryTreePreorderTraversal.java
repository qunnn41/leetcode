package answer;

import java.util.ArrayList;
import java.util.LinkedList;
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

    public List<Integer> preorderTraversal2(TreeNode root) {
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
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        return result;
    }
}
