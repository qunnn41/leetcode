package answer;

public class PermutationSequence {
	/**
	 * https://leetcode.com/problems/permutation-sequence/
	 */
	private boolean[] isUsed;
	private String result;
	private int count = 0;
	public String getPermutation(int n, int k) {
		isUsed = new boolean[n];
		result = "";
		helper("", k, n);
		return result;
    }
	
	private void helper(String str, int k, int n) {
		if (str.length() == n) {
			if (++count == k) {
				result = str;
			}
			return;
		}
		
		for (int i = 0; i < n; ++i) {
			if (!isUsed[i]) {
				isUsed[i] = true;
				helper(str + (i + 1) + "", k, n);
				isUsed[i] = false;
			}
		}
	}
}
