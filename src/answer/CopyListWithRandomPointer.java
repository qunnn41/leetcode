package answer;

public class CopyListWithRandomPointer {
	/**
	 * https://leetcode.com/problems/copy-list-with-random-pointer/
	 */
	class RandomListNode {
		int label;
		RandomListNode next, random;
		RandomListNode(int x) { this.label = x; }
	};
	public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)
            return null;
            
        RandomListNode p = head, pp = null;
        //copy one
        while (p != null) {
            pp = p.next;
            RandomListNode q = new RandomListNode(p.label);
            p.next = q;
            q.next = pp;
            p = pp;
        }
        
        //fix random pointer
        p = head;
        while (p != null) {
            if (p.random != null) {
                p.next.random = p.random.next;
            }
            p = p.next.next;
        }
        
        //remove original one
        RandomListNode result = new RandomListNode(-1);
        RandomListNode r, rr = result;
        p = head;
        while (p != null) {
            pp = p.next.next;
            
            r = p.next;
            rr.next = r;
            rr = r;
            
            p.next = pp;
            p = pp;
        }
        result = result.next;
        return result;
    }
}
