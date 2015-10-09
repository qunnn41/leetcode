package answer;

public class WildcardMatching {
	/**
	 * https://leetcode.com/problems/wildcard-matching/
	 */
	public boolean isMatch(String s, String p) {
        int i = 0, j = 0, match = 0, starIndex = -1;
        while (i < s.length()) {
        	if (j < p.length() && (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j))) {
        		++i;
        		++j;
        	} else if (j < p.length() && p.charAt(j) == '*') {
        		starIndex = j;
        		match = i;
        		++j;
        	} else if (starIndex != -1) {
        		j = starIndex + 1;
        		match ++;
        		i = match;
        	} else
        		return false;
        }
        
        while (j < p.length() && p.charAt(j) == '*')
        	++j;
        return j == p.length();
    }
}
