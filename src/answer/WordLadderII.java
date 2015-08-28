package answer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordLadderII {
	/**
	 * https://leetcode.com/problems/word-ladder-ii/
	 */
	public List<List<String>> findLadders(String start, String end, Set<String> dict) {
		Set<String> set1 = new HashSet<String>();
		Set<String> set2 = new HashSet<String>();
	    set1.add(start);
	    set2.add(end);

	    Map<String, List<String>> map = new HashMap<String, List<String>>();
	    helper(dict, set1, set2, map, false);
	    
	    List<List<String>> res = new ArrayList<List<String>>();
	    List<String> sol = new ArrayList<String>(Arrays.asList(start));
	    generateList(start, end, map, sol, res);

	    return res;
	}
	
	private boolean helper(Set<String> dict, Set<String> set1, Set<String> set2, Map<String, List<String>> map, boolean flip) {
		if (set1.isEmpty()) {
			return false;
		}

		if (set1.size() > set2.size()) {
			return helper(dict, set2, set1, map, !flip);
		}

		dict.removeAll(set1);
		dict.removeAll(set2);

		boolean done = false;
		Set<String> set = new HashSet<String>();

		for (String str : set1) {
			for (int i = 0; i < str.length(); ++i) {
				char[] chars = str.toCharArray();

				for (char  ch = 'a'; ch <= 'z'; ++ch) {
					chars[i] = ch;
					String word = new String(chars);

					String key = flip ? word : str;
					String val = flip ? str : word;
					List<String> list = map.containsKey(key) ? map.get(key) : new ArrayList<String>();

					if (set2.contains(word)) {
						done = true;
						list.add(val);
						map.put(key, list);
					}

					if (!done && dict.contains(word)) {
						set.add(word);
						list.add(val);
						map.put(key, list);
					}
				}
			}
		}

		return done || helper(dict, set2, set, map, !flip);
	}

	void generateList(String start, String end, Map<String, List<String>> map, List<String> sol, List<List<String>> res) {
		if (start.equals(end)) {
			res.add(new ArrayList<String>(sol));
			return;
		}

		if (!map.containsKey(start)) {
			return;
		}

		for (String word : map.get(start)) {
			sol.add(word);
			generateList(word, end, map, sol, res);
			sol.remove(sol.size() - 1);
		}
	}
}
