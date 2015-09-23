package answer;

import java.util.LinkedList;
import java.util.Queue;


public class ImplementStackUsingQueues {
	/**
	 * https://leetcode.com/problems/implement-stack-using-queues/ 
	 */
	private Queue<Integer> queue = new LinkedList<Integer>();
	public void push(int x) {
		queue.add(x);
		int n = queue.size();
		while (n > 1) {
			queue.add(queue.poll());
			n --;
		}
    }

    // Removes the element on top of the stack.
    public void pop() {
    	queue.poll();
    }

    // Get the top element.
    public int top() {
    	return queue.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.isEmpty();
    }
}
