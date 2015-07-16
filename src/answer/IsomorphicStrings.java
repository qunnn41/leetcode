package answer;

import java.util.HashMap;

public class IsomorphicStrings {
	/**
	 * https://leetcode.com/problems/isomorphic-strings/
	 */
	public boolean isIsomorphic(String s, String t) {
        int length = s.length();
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        for (int i = 0; i < length; ++i) {
        	char ss = s.charAt(i);
        	char tt = t.charAt(i);
        	if (!map.containsKey(ss)) {
        		if (map.values().contains(tt))
        			return false;
        		map.put(ss, tt);
        	} else {
        		if (map.get(ss) != tt)
        			return false;
        	}
        }
        
        return true;
    }
}
