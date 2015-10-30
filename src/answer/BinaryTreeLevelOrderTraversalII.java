package answer;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import auxiliary.TreeNode;

public class BinaryTreeLevelOrderTraversalII {
	/**
	 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
	 */
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		if (root == null)
            return new LinkedList<List<Integer>>();
        Stack<List<Integer>> stack = new Stack<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
        	Queue<TreeNode> children = new LinkedList<TreeNode>();
        	LinkedList<Integer> list = new LinkedList<Integer>();
        	while (!queue.isEmpty()) {
        		TreeNode node = queue.poll();
        		list.add(node.val);
        		if (node.left != null)
        			children.add(node.left);
        		if (node.right != null)
        			children.add(node.right);
        	}
        	
        	queue.addAll(children);
        	stack.push(list);
        }
        
        LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
        while (!stack.isEmpty()) {
        	result.add(stack.pop());
        }
        return result;
    }
}
