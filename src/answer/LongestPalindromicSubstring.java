package answer;

public class LongestPalindromicSubstring {
	/**
	 * https://leetcode.com/problems/longest-palindromic-substring/
	 */
	public String longestPalindrome(String s) {
		if (s.length() == 0 || s.length() == 1)
			return s;
		char[] array = s.toCharArray();
		int longest = 0;
		int L = 0, R = 0;
		
		for (int l = 0; l < array.length; ++l) {
			int r = array.length - 1;
			while (r >= l) {
				while (array[r] != array[l] && r >= l)
					--r;
				if (r < l)
					break;
				int len = r - l + 1;
				if (len < longest) {
					r = l - 1;
					continue;
				}
				
				int p = l, q = r;
				while (p <= q) {
					if (array[p] != array[q])
						break;
					++p;
					--q;
				}
				
				if (p > q && len > longest) {
					longest = len;
					L = l;
					R = r;
				}
				
				--r;
			}
		}
		
		return s.substring(L, R + 1);
    }
}
