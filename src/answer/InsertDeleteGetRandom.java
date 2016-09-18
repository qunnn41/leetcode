package answer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class InsertDeleteGetRandom {
    /**
     * https://leetcode.com/problems/insert-delete-getrandom-o1/
     */
    class RandomizedSet {

        ArrayList<Integer> list;
        HashMap<Integer, Integer> map;
        Random random = new Random();
        /** Initialize your data structure here. */
        public RandomizedSet() {
            list = new ArrayList<>();
            map = new HashMap<>();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            boolean contain = map.containsKey(val);
            if (contain) {
                return false;
            }

            map.put(val, list.size());
            list.add(val);
            return true;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            boolean contain = map.containsKey(val);
            if (!contain) {
                return false;
            }

            int location = map.get(val);
            if (location < list.size() - 1) {
                int lastone = list.get(list.size() - 1);
                list.set(location, lastone);
                map.put(lastone, location);
            }

            map.remove(val);
            list.remove(list.size() - 1);
            return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            return list.get(random.nextInt(list.size()));
        }
    }
}
