package answer;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
	/**
	 * https://leetcode.com/problems/permutations/
	 */
	private List<List<Integer>> result;
	private boolean[] isUsed;
	public List<List<Integer>> permute(int[] nums) {
		result = new ArrayList<List<Integer>>();
		isUsed = new boolean[nums.length];
		helper(nums, 0, new ArrayList<Integer>());
		return result;
    }
	
	private void helper(int[] nums, int n, ArrayList<Integer> current) {
		if (n == nums.length) {
			ArrayList<Integer> adding = new ArrayList<Integer>();
			adding.addAll(current);
			result.add(adding);
			return;
		}
		
		for (int i = 0; i < nums.length; ++i) {
			if (!isUsed[i]) {
				isUsed[i] = true;
				current.add(nums[i]);
				helper(nums, n + 1, current);
				current.remove(current.size() - 1);
				isUsed[i] = false;
			}
		}
	}
}
