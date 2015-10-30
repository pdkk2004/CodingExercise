package Common;

public class ListNode implements Comparable<ListNode>{
	
	public int val;
	
	public ListNode next;
	
	public ListNode(int v) {
		this.val = v;
		this.next = null;
	}
	
	@Override
	public int compareTo(ListNode node) {
		return this.val - node.val;
	}
}
