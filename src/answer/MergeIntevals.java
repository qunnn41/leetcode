package answer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import auxiliary.Interval;

public class MergeIntevals {
	/**
	 * https://leetcode.com/problems/merge-intervals/
	 */
	public List<Interval> merge(List<Interval> intervals) {
		ArrayList<Integer> array = new ArrayList<Integer>();
		int last = Integer.MIN_VALUE;
		Collections.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval a, Interval b) {
				return a.start - b.start;
			}
		});
		
		for (Interval val : intervals) {
			int left = val.start;
			int right = val.end;
			if (last == Integer.MIN_VALUE) {
				array.add(left);
				array.add(right);
				last = right;
			} else {
				if (left > last) {
					array.add(left);
					array.add(right);
					last = right;
				} else if (right > last) {
					array.remove(array.size() - 1);
					array.add(right);
					last = right;
				}
			}
		}

		ArrayList<Interval> result = new ArrayList<Interval>();
		for (int i = 0; i < array.size(); i += 2) {
			Interval val = new Interval(array.get(i), array.get(i + 1));
			result.add(val);
		}
		
		return result;
    }
}
