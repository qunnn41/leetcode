package answer;

public class LongestSubstringWithoutRepeatingCharaters {
	/**
	 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
	 */
	public int lengthOfLongestSubstring(String s) {
        boolean[] map = new boolean[128];
        int max = 0;
        int i = 0, j = 0, n = s.length();
        while (j < n) {
            if (!map[(int)s.charAt(j)]) {
                map[(int)s.charAt(j)] = true;
                ++j;
                max = Math.max(max, j - i);
            } else {
                while (s.charAt(i) != s.charAt(j)) {
                    map[s.charAt(i)] = false;
                    ++i;
                }
                
                while (s.charAt(i) == s.charAt(j) && i < j) {
                	++i;
                }
                
                map[(int)s.charAt(j)] = true; 
                ++j;
                max = Math.max(max, j - i);
            }//end if
        }//end while
        return max;
    }
}
