package answer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {
    /**
     * https://leetcode.com/problems/top-k-frequent-elements/
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int n : nums)
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);

        for (int key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        List<Integer> result = new ArrayList<>();
        for (int pos = bucket.length - 1; pos >= 0 && result.size() < k; pos --)
            if (bucket[pos] != null)
                result.addAll(bucket[pos]);
        return result;
    }
}
