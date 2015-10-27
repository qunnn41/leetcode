package answer;

import auxiliary.TreeNode;

public class ConvertSortedArrayToBinarySearchTree {
	/**
	 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
	 */
	public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0)
        	return null;
        return helper(0, nums.length - 1, nums);
    }
	
	private TreeNode helper(int start, int end, int nums[]) {
		if (start > end)
			return null;
		int mid = (start + end) / 2;
		
		TreeNode left = helper(start, mid - 1, nums);
		TreeNode current = new TreeNode(nums[mid]);
		current.left = left;
		TreeNode right = helper(mid + 1, end, nums);
		current.right = right;
		return current;
	}
}
