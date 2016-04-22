package answer;

import java.util.*;

public class WordLadderII {
	/**
	 * https://leetcode.com/problems/word-ladder-ii/
	 */
	private Map<String, List<String>> map = new HashMap<>();
	private List<List<String>> results = new LinkedList<>();
	public List<List<String>> findLadders(String start, String end, Set<String> dict) {
		if (dict.size() == 0)
			return results;
		Queue<String> queue = new ArrayDeque<>();
		queue.add(start);

		Map<String, Integer> ladder = new HashMap<>();
        dict.add(end);
		for (String str : dict) {
			ladder.put(str, Integer.MAX_VALUE);
		}
		ladder.put(start, 0);


		int min = Integer.MAX_VALUE;
		while (!queue.isEmpty()) {
			String word = queue.poll();
			int step = ladder.get(word) + 1;

			if (step > min)
				break;

			for (int i = 0; i < word.length(); ++i) {
				StringBuilder stringBuilder = new StringBuilder(word);
				for (char ch = 'a'; ch <= 'z'; ++ch) {
					stringBuilder.setCharAt(i, ch);
					String newWord = stringBuilder.toString();
					if (ladder.containsKey(newWord)) {
                        if (step > ladder.get(newWord)) {
                            continue;
                        } else if (step < ladder.get(newWord)) {
                            queue.add(newWord);
							ladder.put(newWord, step);
						}

                        if (map.containsKey(newWord)) {
                            map.get(newWord).add(word);
                        } else {
                            List<String> list = new LinkedList<>();
                            list.add(word);
                            map.put(newWord, list);
                        }

                        if (newWord.equals(end)) {
                            min = step;
                        }
					}
				}
			}
		}

		backTrace(end, start, new LinkedList<>());

		return results;
	}

	private void backTrace(String word, String start, List<String> list) {
		if (word.equals(start)) {
			list.add(0, start);
			results.add(new LinkedList<>(list));
			list.remove(0);
			return;
		}

		list.add(0, word);
		if (map.containsKey(word)) {
			for (String str : map.get(word)) {
				backTrace(str, start, list);
			}
		}
        list.remove(0);
	}

	/*
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
	}*/
}
