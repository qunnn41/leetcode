package answer;

public class PalindromePartitionII {
	/**
	 * https://leetcode.com/problems/palindrome-partitioning-ii/
	 */
	public int minCut(String s) {
        boolean [][]palindrome = new boolean[s.length()][s.length() + 1];
        
        for (int i = 0; i < s.length(); i ++) {
            palindrome[i][i] = true;
            palindrome[i][i + 1] = true;
        }
        
        for (int i = 2; i <= s.length(); i ++)
            for (int j = 0; j + i <= s.length(); j ++)
                palindrome[j][j + i] = (s.charAt(j) == s.charAt(j + i - 1)) && palindrome[j + 1][j + i - 1];
        
        int[] cut = new int[s.length() + 1];
        for (int i = 0; i <= s.length(); i ++)
            if (palindrome[0][i])
                cut[i] = 0;
            else {
                cut[i] = i - 1;
                for (int j = 1; j < i; j ++)
                    cut[i] = Math.min(cut[i], cut[j] + (palindrome[j][i] ? 1 : i - j));
            }
        return cut[s.length()];
    }
}
