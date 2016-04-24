package answer;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import auxiliary.TreeNode;

public class BinaryTreeRightSideView {
	/**
	 * https://leetcode.com/problems/binary-tree-right-side-view/
	 */
	public List<Integer> rightSideView(TreeNode root) {
		if (root == null) return new LinkedList<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        LinkedList<Integer> result = new LinkedList<Integer>();
        LinkedList<TreeNode> children = new LinkedList<TreeNode>();
        while (!queue.isEmpty()) {
        	TreeNode current = queue.poll();
        	if (current.left != null) children.add(current.left);
        	if (current.right != null) children.add(current.right);
        	
        	if (queue.isEmpty()) {
        		result.add(current.val);
        		queue.addAll(children);
        		children.clear();
        	}
        }
        return result;
    }

    //each depth only select one node
    //view path is current size of result list
    public List<Integer> rightSideView2(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        rightView(root, result, 0);
        return result;
    }

    public void rightView(TreeNode curr, List<Integer> result, int currDepth){
        if(curr == null){
            return;
        }
        if(currDepth == result.size()){
            result.add(curr.val);
        }

        rightView(curr.right, result, currDepth + 1);
        rightView(curr.left, result, currDepth + 1);

    }
}
