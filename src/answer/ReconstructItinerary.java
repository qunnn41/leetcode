package answer;

import java.util.*;

public class ReconstructItinerary {
    /**
     * https://leetcode.com/problems/reconstruct-itinerary/
     */
    public List<String> findItinerary(String[][] tickets) {
        List<String> result = new LinkedList<String>();
        if (tickets == null || tickets.length == 0)
            return result;
        Map<String, PriorityQueue<String>> map = new HashMap<String, PriorityQueue<String>>();
        for (int i = 0; i < tickets.length; ++i) {
            if (!map.containsKey(tickets[i][0]))
                map.put(tickets[i][0], new PriorityQueue<String>());
            map.get(tickets[i][0]).add(tickets[i][1]);
        }

        Stack<String> stack = new Stack<String>();
        stack.push("JFK");
        while (!stack.isEmpty()) {
            while (map.containsKey(stack.peek()) && !map.get(stack.peek()).isEmpty())
                stack.push(map.get(stack.peek()).poll());
            result.add(0, stack.pop());
        }
        return result;
    }
}
