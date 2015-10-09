package answer;

import java.util.Iterator;

public class PeekingIterator {
	/**
	 * https://leetcode.com/problems/peeking-iterator/
	 */
	private Iterator<Integer> it;
	private Integer cache;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
		it = iterator;
		cache = it.next();
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
		return cache;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	public Integer next() {
	    int result = cache;
	    if (it.hasNext()) {
	    	cache = it.next();
	    } else {
	    	cache = null;
	    }
	    return result;
	}

	public boolean hasNext() {
	    return cache != null;
	}

}
