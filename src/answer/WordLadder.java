package answer;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
	/**
	 * https://leetcode.com/problems/word-ladder/
	 */
	public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
        Map<String, Integer> dis = new HashMap<String, Integer>();
        Queue<String> q = new LinkedList<String>();
        dis.put(beginWord, 1);
        q.add(beginWord);

        while (!q.isEmpty()) {
            String word = q.remove();
            int len = dis.get(word);
            if (word.equals(endWord)) break;
            for (int i = 0; i < word.length(); i++) {
                String temp = word;
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char[] arr = temp.toCharArray();
                    arr[i] = ch;
                    temp = new String(arr);
                    if (!dis.containsKey(temp) && wordDict.contains(temp)) {
                        dis.put(temp, len + 1);
                        q.add(temp);
                    }
                }
            }
        }
        if (dis.get(endWord) == null) return 0;
        return dis.get(endWord);
    }
}
