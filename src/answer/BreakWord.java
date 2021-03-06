package answer;

import java.util.Set;

public class BreakWord {
	/**
	 * https://leetcode.com/problems/word-break/
	 */
	public boolean wordBreak(String s, Set<String> dict) {
        boolean[] result = new boolean[s.length() + 1];
        result[0] = true;
        
        for (int i = 1;i <= s.length(); i ++) {
            for (int j = 0; j < i; j ++) {
                if (result[j] && dict.contains(s.substring(j, i))) {
                    result[i] = true;
                    break;
                }
            }
        }
        
        return result[s.length()];
    }
}
