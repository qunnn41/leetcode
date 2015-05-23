package answer;

import java.util.ArrayList;
import java.util.HashMap;

public class LRUCache {
	/**
	 * https://leetcode.com/problems/lru-cache/
	 */
	private final int maxCapacity;
    private final HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    private final ArrayList<Integer> list = new ArrayList<Integer>();
    
    public LRUCache(int capacity) {
        maxCapacity = capacity;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        
        list.remove(list.indexOf(key));
        list.add(key);
        return map.get(key);
    }
    
    public void set(int key, int value) {
        int val = get(key);
        map.put(key, value);
        if (val == -1) {
            list.add(key);
            if (map.size() > maxCapacity) {
                map.remove(list.get(0));
                list.remove(0);
            }
        }

    }
}
