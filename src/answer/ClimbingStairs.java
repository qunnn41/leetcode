package answer;

public class ClimbingStairs {
	/**
	 * https://leetcode.com/problems/climbing-stairs/
	 */
	public int climbStairs(int n) {
        if (n < 3)
        	return n;
        int[] count = new int[n + 1];
        count[0] = 0;
        count[1] = 1;
        count[2] = 2;
        for (int i = 3; i <= n; ++i)
        	count[i] = count[i - 1] + count[i - 2];
        return count[n];
    }
}
