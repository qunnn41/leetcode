package answer;

public class ScrambleString {
	/**
	 * https://leetcode.com/problems/scramble-string/
	 */
	public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2))
        	return true;
        
        int len = s1.length();
        int[]count = new int[256];
        for (int i = 0; i < len; ++i) {
        	count[s1.charAt(i)] ++;
        	count[s2.charAt(i)] --;
        }
        
        for (int i = 0; i < len; ++i) {
        	if (count[s1.charAt(i)] != 0)
        		return false;
        }
        
        for (int i = 1; i < len; ++i) {
        	if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i)))
        		return true;
        	
        	if (isScramble(s1.substring(0, i), s2.substring(len - i)) && isScramble(s1.substring(i), s2.substring(0, len - i)))
        		return true;
        }
        
        return false;
    }
}
