package answer;

import java.util.ArrayList;
import java.util.List;

import auxiliary.TreeNode;

public class PathSumII {
	/**
	 * https://leetcode.com/problems/path-sum-ii/
	 */
	ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
    ArrayList<Integer> path = new ArrayList<Integer>();
	private List<List<Integer>> helper(TreeNode root, int sum) {
        path.add(root.val);
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                result.add(new ArrayList<>(path));
            }
        } else {
            if (root.left != null) {
                pathSum(root.left, sum - root.val);
            }
            if (root.right != null) {
                pathSum(root.right, sum - root.val);
            }
        }
        path.remove(path.size()-1);
        return result;
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return result;
        }
        return helper(root, sum);
    }
}
