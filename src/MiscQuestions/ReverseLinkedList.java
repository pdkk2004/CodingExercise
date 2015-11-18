package MiscQuestions;

import org.junit.Test;

import Common.ListNode;

public class ReverseLinkedList {
	
	public static ListNode reverse(ListNode head) {
		ListNode pre = null;
		ListNode p = head;
		while (p != null) {
			ListNode next = p.next;
			p.next = pre;
			pre = p;
			p = next;
		}
		return pre;
	}
	
	public static ListNode reverseM2N(ListNode head, int m, int n) {
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode p = dummy;
		for (int i = 0; i < m - 1; i++) {
			p = p.next;
		}
		ListNode preM = p;
		ListNode pre = null;
		p = p.next;
		for (int i = m; i <= n; i++) {
			ListNode next = p.next;
			p.next = pre;
			pre = p;
			p = next;
		}
		preM.next.next = p;
		preM.next = pre;
		return dummy.next;
	}
	
	@Test
	public void test() {
		//1->2->3->4->5
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		
		print(head);
		print(reverseM2N(head, 2, 4));
		
		
	}
	
	private static void print(ListNode head) {
		ListNode p = head;
		StringBuilder sb = new StringBuilder();
		while (p != null) {
			sb.append(p.val + "->");
			p = p.next;
		}
		sb.append("NULL");
		System.out.println(sb.toString());
	}
}
