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
}
