package answer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Anagrams {
	/**
	 * https://leetcode.com/problems/anagrams/
	 */
	public List<String> anagrams(String[] strs) {
		ArrayList<String> result = new ArrayList<String>();
		HashMap<String, String> map = new HashMap<String, String>();
		
		for (String str : strs) {
			String s = sort(str);
			if (map.containsKey(s)) {
				if (!result.contains(map.get(s)))
					result.add(map.get(s));
				result.add(str);
			} else
				map.put(s, str);
		}
		
		return result;
    }
    private String sort(String str) {
		char[] c = str.toCharArray();
		Arrays.sort(c);
		return new String(c);
	}
}
