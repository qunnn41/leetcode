package auxiliary;

public class ListNode {
	public int val;
	public ListNode next;
	public ListNode(int x) {
		val = x;
		next = null;
	}
	
	public String toString() {
		String str = val + "\t";
		if (next != null)
			str += this.next;
		return str;
	}
}