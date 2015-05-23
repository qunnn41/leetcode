package answer;

import auxiliary.ListNode;

public class InsertionOfTwoLinkedList {
	/**
	 * https://leetcode.com/problems/intersection-of-two-linked-lists/
	 */
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        
        int lengthA = length(headA);
        int lengthB = length(headB);
        
        ListNode p, q;
        int d;
        if (lengthA > lengthB) {
            p = headA;
            q = headB;
            d = lengthA - lengthB;
        } else {
            p = headB;
            q = headA;
            d = lengthB - lengthA;
        }
        
        for (int i = 0; i < d; i ++) {
            p = p.next;
        }
        
        while (p != null && q != null) {
            if (p == q)
                return p;
            p = p.next;
            q = q.next;
        }
        
        return null;
        
    }
    
    private int length(ListNode list) {
        if (list == null)
            return 0;
        int l = 0;
        ListNode p = list;
        while (p.next != null) {
            p = p.next;
            l ++;
        }
        return l;
    }
}
