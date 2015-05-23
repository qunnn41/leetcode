package answer;

import auxiliary.ListNode;

public class InsertionSortList {
	/**
	 * https://leetcode.com/problems/insertion-sort-list/
	 */
	public ListNode insertionSortList(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        
        ListNode sortHead = head, sortTail = head;
        
        while (sortTail.next != null) {
            ListNode unsortHead = sortTail.next;
            if (sortHead.val > unsortHead.val) {
                //adding in the head
                sortTail.next = unsortHead.next;
                unsortHead.next = sortHead;
                sortHead = unsortHead;
            } else {
                ListNode p = sortHead.next;
                while (p != sortTail.next && p.val < unsortHead.val)
                    p = p.next;
                if (p == sortTail.next) {
                    //adding in the tail
                    sortTail.next = unsortHead;
                    sortTail = sortTail.next;
                } else {
                    //addint in front of p
                    ListNode s = sortHead;
                    while (s.next != p)
                        s = s.next;
                    sortTail.next = unsortHead.next;
                    s.next = unsortHead;
                    unsortHead.next = p;
                }//end if
            }//end if
        }//end while
        
        return sortHead;
    }
}
