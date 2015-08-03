package answer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumIII {
	/**
	 * https://leetcode.com/problems/combination-sum-iii/
	 */
	private List<List<Integer>> result = new ArrayList<List<Integer>>();
	public List<List<Integer>> combinationSum3(int k, int n) {
		int[] candidates = new int[] {1,2,3,4,5,6,7,8,9};
		Arrays.sort(candidates);
        helper(n, candidates, new ArrayList<Integer>(), 0, k);
        return result;
    }
	
	private void helper(int target, int[] candidates, List<Integer> current, int begin, int size) {
		if (target == 0) {
			if (size != 0)
				return;
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
				helper(target - candidates[i], candidates, current, i + 1, size - 1);
				current.remove(current.size() - 1);
			}
		}
	}
}
