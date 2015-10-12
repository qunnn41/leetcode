package answer;

public class PerfectSquares {
	/**
	 * https://leetcode.com/problems/perfect-squares/
	 */
	public int numSquares(int n) {
		if (n == 0)
			return 0;
        int[]result = new int[n + 1];
        for (int i = 1; i < result.length; ++i) {
        	if (isSquare(i)) {
        		result[i] = 1;
        	} else {
        		int current = i;
        		for (int j = (int)(Math.sqrt(i)); j > 0; j--)
        			current = Math.min(current, result[i - j * j] + 1);
        		result[i] = current;
        	}
        }
        return result[n];
    }
	
	private boolean isSquare(int n) {
		return ((int)(Math.sqrt(n)) * (int)(Math.sqrt(n))) == n;
	}
}
