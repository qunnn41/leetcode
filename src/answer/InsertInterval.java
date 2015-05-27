package answer;


import auxiliary.Interval;

import java.util.LinkedList;
import java.util.List;

public class InsertInterval {
    /**
     * https://leetcode.com/problems/insert-interval/
     */
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new LinkedList<Interval>();
        for (Interval i : intervals) {
            if (newInterval == null || i.end < newInterval.start)
                result.add(i);
            else if (i.start > newInterval.end) {
                result.add(newInterval);
                result.add(i);
                newInterval = null;
            } else {
                newInterval.start = Math.min(newInterval.start, i.start);
                newInterval.end = Math.max(newInterval.end, i.end);
            }
        }
        if (newInterval != null)
            result.add(newInterval);
        return result;
    }
}
