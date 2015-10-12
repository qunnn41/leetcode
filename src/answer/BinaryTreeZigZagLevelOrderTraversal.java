package answer;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import auxiliary.TreeNode;

public class BinaryTreeZigZagLevelOrderTraversal {
	/**
	 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
	 */
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (root == null)
            return result;
        
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        
        stack1.push(root);
        
        
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
    		List<Integer> current = new LinkedList<Integer>();
        	if (stack1.isEmpty()) {
        		//right to left
        		while (!stack2.isEmpty()) {
        			TreeNode node = stack2.pop();
        			current.add(node.val);
        			if (node.right != null) 
        				stack1.push(node.right);
        			if (node.left != null) 
        				stack1.push(node.left);
        		}
        	} else {
        		//left to right
        		while (!stack1.isEmpty()) {
        			TreeNode node = stack1.pop();
        			current.add(node.val);
        			if (node.left != null)
        				stack2.push(node.left);
        			if (node.right != null)
        				stack2.push(node.right);
        		}
        	}
        	result.add(current);
        }
        
        return result;
    }
}
