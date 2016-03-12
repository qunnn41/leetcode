package answer;

import auxiliary.TreeNode;

public class HouseRobberIII {
    /**
     * https://leetcode.com/problems/house-robber-iii/
     */
    public int rob(TreeNode root) {
        int[] result = helper(root);
        return Math.max(result[0], result[1]);
    }

    private int[] helper(TreeNode node) {
        if (node == null)
            return new int[]{0, 0};

        int[] left = helper(node.left);
        int[] right = helper(node.right);
        int[] result = new int[2];
        //0 means rob
        //1 means not rob
        result[0] = Math.max(node.val + left[1] + right[1], left[0] + right[0]);
        result[1] = left[0] + right[0];
        return result;
    }
}
