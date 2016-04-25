package answer;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianFromDataStream {
	/**
	 * https://leetcode.com/problems/find-median-from-data-stream/
	 */

	PriorityQueue<Integer> queue1 = new PriorityQueue<Integer>(Collections.reverseOrder());
	PriorityQueue<Integer> queue2 = new PriorityQueue<Integer>();

	// Adds a number into the data structure.
	public void addNum(int num) {
		if (queue1.isEmpty()) {
			//first one
			queue1.add(num);
			return;
		} else if (queue2.isEmpty()) {
			//second one
			if (num > queue1.peek()) {
				queue2.add(num);
			} else {
				queue2.add(queue1.poll());
				queue1.add(num);
			}

			return;
		}

		if (num > queue2.peek()) {
			queue2.add(num);
		} else {
			queue1.add(num);
		}

		if (queue2.size() > queue1.size() + 1) {
			queue1.add(queue2.poll());
		} else if (queue1.size() > queue2.size() + 1) {
			queue2.add(queue1.poll());
		}
	}

	// Returns the median of current data stream
	public double findMedian() {
		if (queue1.size() == queue2.size())
			return (queue1.peek() + queue2.peek()) / 2.0;
		return queue1.size() > queue2.size() ? queue1.peek() : queue2.peek();
	}

}
