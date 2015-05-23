package answer;

import auxiliary.ListNode;

public class AddTwoNumbers {
	/**
	 * https://leetcode.com/problems/add-two-numbers/
	 */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return null;
        ListNode result = new ListNode(-1);
        ListNode cur = result;
        boolean flag = false;
        while (l1 != null || l2 != null) {
            int num = 0;
            if (l1 == null) {
                num = l2.val;
                l2 = l2.next;
            } else if (l2 == null) {
                num = l1.val;
                l1 = l1.next;
            } else {
                num = l1.val + l2.val;
                l1 = l1.next;
                l2 = l2.next;
            }
            
            if (flag) num ++;
            if (num > 9) {
                num -= 10;
                flag = true;
            } else
                flag = false;
            
            cur.next = new ListNode(num);
            cur = cur.next;
        }
        
        if (flag) cur.next = new ListNode(1);
        return result.next;
    }
}
