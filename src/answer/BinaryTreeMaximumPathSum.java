package answer;

import auxiliary.TreeNode;

public class BinaryTreeMaximumPathSum {
    /**
     * https://leetcode.com/problems/binary-tree-maximum-path-sum/
     */
    int max = 0;
    public int maxPathSum(TreeNode root) {
        if (root == null)
            return 0;
        max = root.val;
        helper(root);
        return max;
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);

        left = left > 0 ? left : 0;
        right = right > 0 ? right : 0;

        max = Math.max(max, root.val + left + right);
        //will be used by its parents
        return Math.max(left, right) + root.val;
    }
}
