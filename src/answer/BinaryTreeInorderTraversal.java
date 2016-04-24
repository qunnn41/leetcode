package answer;

import auxiliary.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreeInorderTraversal {
    /**
     * https://leetcode.com/problems/binary-tree-inorder-traversal/
     */
    private LinkedList<Integer> result = new LinkedList<Integer>();
    public List<Integer> inorderTraversal(TreeNode root) {
        helper(root);
        return result;
    }

    private void helper(TreeNode node) {
        if (node == null)
            return;
        helper(node.left);
        result.add(node.val);
        helper(node.right);
    }


    public List<Integer> inorderTraversal2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            result.add(node.val);
            node = node.right;
        }
        return result;
    }
}
