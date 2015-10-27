package answer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import auxiliary.TreeNode;

public class SerializeAndDeserializeBinaryTree {
	/**
	 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
	 */
	private String Leaf = "X";
	private String split = ",";
	// Encodes a tree to a single string.
    public String serialize(TreeNode root) {
    	StringBuilder sb = new StringBuilder();
    	encode(root, sb);
    	return sb.toString();
    }
    
    private void encode(TreeNode node, StringBuilder sb) {
    	if (node == null) {
    		sb.append(Leaf).append(split);
    	} else {
    		sb.append(node.val).append(split);
    		encode(node.left, sb);
    		encode(node.right, sb);
    	}
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
    	Queue<String> queue = new LinkedList<String>();
    	queue.addAll(Arrays.asList(data.split(split)));
    	return decode(queue);
    }
    
    private TreeNode decode(Queue<String> queue) {
    	String str = queue.poll();
    	if (str.equals(Leaf)) {
    		return null;
    	} else {
    		TreeNode node = new TreeNode(Integer.valueOf(str));
    		node.left = decode(queue);
    		node.right = decode(queue);
    		return node;
    	}
    }
}
