package answer;

import auxiliary.TreeNode;

public class SameTree {
	/**
	 * https://leetcode.com/problems/same-tree/
	 */
	public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
        	return true;
        if ((p == null && q != null) || ((p != null) && q == null))
        	return false;
        if (p.val != q.val) 
        	return false;
        if (!isSameTree(p.left, q.left))
        	return false;
        return isSameTree(p.right, q.right);
    }
}
