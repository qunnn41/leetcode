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

    public ListNode reverseKGroup2(ListNode head, int k) {
        if (head == null || head.next == null || k < 2)
            return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode tail = dummy, current = dummy;
        int count = 0;
        while (true) {
            count = k;
            while (count > 0 && tail != null) {
                count --;
                tail = tail.next;
            }

            if (tail == null)
                return dummy.next;
            head = current.next;
            while (current.next != tail) {
                ListNode temp = current.next;
                current.next = temp.next;
                temp.next = tail.next;
                tail.next = temp;
            }

            tail = head;
            current = head;
        }
    }
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        System.out.println(new ReverseNodesInKGroups().reverseKGroup2(node, 2));
    }
}
