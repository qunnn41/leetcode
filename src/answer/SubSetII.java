package answer;

import java.util.*;

public class SubSetII {
	/**
	 * https://leetcode.com/problems/subsets-ii/
	 */
	public List<List<Integer>> subsetsWithDup(int[] S) {
		List<List<Integer>> result = new ArrayList<>();

		if(S.length == 0){
			return result;
		}

		Arrays.sort(S);
		dfs(S, 0, new ArrayList<>(), result);
		return result;
	}

	public void dfs(int[] s, int index, List<Integer> path, List<List<Integer>> result){
		result.add(new ArrayList<>(path));

		for(int i = index; i < s.length; i++){
			if (i > index && s[i] == s[i - 1])
				continue;
			path.add(s[i]);
			dfs(s, i+1, path, result);
			path.remove(path.size()-1);
		}
	}
}
