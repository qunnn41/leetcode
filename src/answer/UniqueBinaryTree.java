package answer;

public class UniqueBinaryTree {
	/**
	 * https://leetcode.com/problems/unique-binary-search-trees/
	 */
	public int numTrees(int n) {
		int[]c = new int[n + 1];
		c[0] = 1;
		c[1] = 1;
		
		for (int i = 2; i <=n; ++i) {
			int sum = 0;
			for (int j = 1; j <= i; ++j)
				sum += c[j - 1] * c[i - j];
			c[i] = sum;
		}
		return c[n];
    }
}
