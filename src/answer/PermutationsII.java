package answer;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class PermutationsII {
	/**
	 * https://leetcode.com/problems/permutations-ii/
	 */
	private List<List<Integer>> result;
	public List<List<Integer>> permuteUnique(int[] nums) {
		result = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int n : nums) list.add(n);
		helper(0, list);
		return result;
    }
	
	private void helper(int n, ArrayList<Integer> current) {
		if (n == current.size() - 1) {
			result.add(new ArrayList<Integer>(current));
			return;
		}
		
		for (int i = n; i < current.size(); ++i) {
			if (i > n && current.get(i) == current.get(i - 1)) continue;
			current.add(n, current.get(i));
			current.remove(i + 1);
			helper(n + 1, current);
			current.add(i + 1, current.get(n));
			current.remove(n);
		}
	}
}
