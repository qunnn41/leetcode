package answer;

import java.util.LinkedList;
import java.util.Queue;

import auxiliary.TreeLinkNode;

public class PopulatingNextRightPointerInEachNode {
	/**
	 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
	 */
	public void connect(TreeLinkNode root) {
        if (root == null)
        	return;
        Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
        	TreeLinkNode current = queue.poll();
        	LinkedList<TreeLinkNode> children = new LinkedList<TreeLinkNode>();
        	while (!queue.isEmpty()) {
        		current.next = queue.poll();
        		if (current.left != null) children.add(current.left);
        		if (current.right != null) children.add(current.right);
        		current = current.next;
        	}
        	if (current.left != null) children.add(current.left);
    		if (current.right != null) children.add(current.right);
        	current.next = null;
        	queue.addAll(children);
        }
    }
}
