package answer;

import java.util.LinkedList;

public class PermutationSequence {
	/**
	 * https://leetcode.com/problems/permutation-sequence/
	 */
	public String getPermutation(int n, int k) {
		LinkedList<Integer> num = new LinkedList<Integer>();
		for (int i = 1; i <= n; ++i)
			num.add(i);
		int[] fact = new int[n];
		fact[0] = 1;
		for (int i = 1; i < n; ++i)
			fact[i] = i * fact[i - 1];
		
		k = k - 1;
		String str = "";
		for (int i = n; i > 0; --i) {
			int index = k / fact[i - 1];
			k = k % fact[i - 1];
			str += num.get(index);
			num.remove(index);
		}
		
		return str;
    }
}
