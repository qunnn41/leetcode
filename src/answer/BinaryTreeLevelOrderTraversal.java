package answer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import auxiliary.TreeNode;

public class BinaryTreeLevelOrderTraversal {
	/**
	 * https://leetcode.com/problems/binary-tree-level-order-traversal/
	 */
	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) return result;
        LinkedList<TreeNode> q = new LinkedList<TreeNode>();
        
        q.add(root);
        while (!q.isEmpty()) {
            List<Integer> ti = new ArrayList<Integer>();
            List<TreeNode> tt = new ArrayList<TreeNode>();
            while (!q.isEmpty())
                tt.add(q.poll());
            for (TreeNode t : tt) {
                if (t.left != null) q.add(t.left);
                if (t.right != null) q.add(t.right);
                ti.add(t.val);
            }
            
            result.add(ti);
        }
        
        return result;
    }
}
