package answer;

import java.util.Stack;

import auxiliary.ListNode;

public class ReverseNodesInKGroups {
	/**
	 * https://leetcode.com/problems/reverse-nodes-in-k-group/
	 */
	public ListNode reverseKGroup(ListNode head, int k) {
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode p = head;
        ListNode start = null, current = null, temp = null;
        int count = 0;
        while (p != null) {
            stack.push(p);
            p = p.next;
            count ++;
            if (count == k) {
                if (start == null) {
                    //first time
                    start = stack.pop();
                    current = start;
                }
                while (!stack.empty()) {
                    temp = stack.pop();
                    current.next = temp;
                    current = current.next;
                }
                current.next = p;
                count = 0;
            }//end if
        }//end while
        
        return (start == null) ? head : start;
    }
}
