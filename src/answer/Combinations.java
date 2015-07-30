package answer;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
	/**
	 * https://leetcode.com/problems/combinations/
	 */
	private List<List<Integer>> result;
	public List<List<Integer>> combine(int n, int k) {
		result = new ArrayList<List<Integer>>();
		helper(1, n, k, new ArrayList<Integer>(n));
        return result;
    }

	private void helper(int c, int n, int k, List<Integer> list) {
		if (list.size() > k)
			return;
		if (list.size() == k) {
			//get a result
			ArrayList<Integer> adding = new ArrayList<Integer>(list);
			result.add(adding);
			return;
		}

		for (int i = c; i <= n; ++i) {
			list.add(i);
			helper(i + 1, n, k, list);
			list.remove(list.size() - 1);
		}
	}

	public static void main(String[] args) {
		List<List<Integer>> result = new Combinations().combine(4, 2);
		for (List<Integer> r : result) {
			for (Integer n : r)
				System.out.print(n + "\t");
			System.out.println();
		}
	}
}
