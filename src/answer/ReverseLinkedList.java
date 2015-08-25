package answer;


import auxiliary.ListNode;

public class ReverseLinkedList {
    /**
     * https://leetcode.com/problems/reverse-linked-list/
     */
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
        if (head.next == null)
            return head;
        ListNode pre = reverseList(head.next);
        ListNode p = pre;
        while (p.next != null)
            p = p.next;
        p.next = new ListNode(head.val);
        return pre;
    }
    
    public ListNode reverseList2(ListNode head) {
    	if (head == null || head.next == null)
    		return head;
    	ListNode h = new ListNode(1);
    	h.next = head;
    	ListNode current = head;
    	while (current.next != null) {
    		ListNode p = current.next;
    		current.next = p.next;
    		p.next = h.next;
    		h.next = p;
    	}
    	return h.next;
    }
}
