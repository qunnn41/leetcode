package answer;

import auxiliary.ListNode;

public class OddEvenLinkedList {
    /**
     * https://leetcode.com/problems/odd-even-linked-list/
     */
    public ListNode oddEvenList(ListNode head) {
        //length <= 2
        if (head == null || head.next == null || head.next.next == null)
            return head;

        ListNode odd = head, even = head.next;
        ListNode p = even;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }

        odd.next = p;
        return head;
    }
}
