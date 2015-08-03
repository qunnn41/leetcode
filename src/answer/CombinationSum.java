package answer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
	/**
	 * https://leetcode.com/problems/combination-sum/
	 */
	private List<List<Integer>> result = new ArrayList<List<Integer>>();
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        helper(target, candidates, new ArrayList<Integer>(), 0);
        System.out.println(result.size());
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
			current.add(candidates[i]);
			helper(target - candidates[i], candidates, current, i);
			current.remove(current.size() - 1);
		}
	}
}
