package answer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
	/**
	 * https://leetcode.com/problems/combination-sum-ii/
	 */
	private List<List<Integer>> result = new ArrayList<List<Integer>>();
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        helper(target, candidates, new ArrayList<Integer>(), 0);
        return result;
    }
	
	private void helper(int target, int[] candidates, List<Integer> current, int begin) {
		if (target == 0) {
			List<Integer> adding = new ArrayList<Integer>();
			adding.addAll(current);
			result.add(adding);
			return;
		}
		
		if (target < 0)
			return;
		
		for (int i = begin; i < candidates.length && target >= candidates[i]; ++i) {
			if (i == begin || candidates[i] != candidates[i - 1]) {
				current.add(candidates[i]);
				helper(target - candidates[i], candidates, current, i + 1);
				current.remove(current.size() - 1);
			}
		}
	}
}
