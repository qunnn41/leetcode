package answer;

import auxiliary.ListNode;

public class PalindromeLinkedList {
	/**
	 * https://leetcode.com/problems/palindrome-linked-list/
	 */
	public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
        	return true;
        ListNode p = head, q = head;
        while (p.next != null && p.next.next != null) {
        	p = p.next.next;
        	q = q.next;
        }
        
        //flag is true->odd
        //flag is false->even
        boolean flag = (p.next == null) ? true : false;
        ListNode cur = q.next.next, pre = q.next;
        while (cur != null) {
        	pre.next = cur.next;
        	cur.next = q.next;
        	q.next = cur;
        	cur = pre.next;
        }
        
        ListNode node1 = head;
        ListNode node2 = q.next;
        cur = flag ? q : q.next;
        while (node1 != cur && node2 != null) {
        	if (node1.val != node2.val)
        		return false;
        	node1 = node1.next;
        	node2 = node2.next;
        }
        
        return true;
    }
}
