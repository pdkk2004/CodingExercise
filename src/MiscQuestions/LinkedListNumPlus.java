package MiscQuestions;

import Common.ListNode;

public class LinkedListNumPlus {

	/**
	 * The number is represented as a linkedlist, the head of which is the most significant digit of the number.
	 * This function add 1 to the number presented by the list.
	 * @param head
	 * @return
	 */
	public static ListNode plusOne(ListNode head) {
		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;
		ListNode notNine = dummy;
		ListNode p = head;
		while (p != null) {
			tail.next = new ListNode(p.val);
			if (p.val != 9) {
				notNine = tail.next;
			}
			tail = tail.next;
			p = p.next;
		}
		
		notNine.val += 1;
		p = notNine.next;
		while (p != null) {
			p.val = 0;
			p = p.next;
		}
		if (notNine == dummy) {
			return dummy;
		} else {
			return dummy.next;
		}
	}
	
	
	public static ListNode add(ListNode n1, ListNode n2) {
		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;
		ListNode p1 = n1;
		ListNode p2 = n2;
		ListNode notNine = dummy;
		int l1 = 0, l2 = 0;
		while (p1 != null || p2 != null) {
			if (p1 != null) {
				l1++;
				p1 = p1.next;
			}
			if (p2 != null) {
				l2++;
				p2 = p2.next;
			}
		}
		
		if (l2 > l1) {
			ListNode tmp = n1;
			n1 = n2;
			n2 = tmp;
		}
		
		if (l1 > l2) {
			for (int i = 0; i < l1 - l2; i++) {
				tail.next = new ListNode(n1.val);
				n1 = n1.next;
				tail = tail.next;
				if (tail.val != 9) {
					notNine = tail;
				}
			}
		}
		
		while (n1 != null && n2 != null) {
			int v = n1.val + n2.val;
			tail.next = new ListNode(v % 10);
			tail = tail.next;
			n1 = n1.next;
			n2 = n2.next;
			if (v > 9) {
				notNine.val += 1;
				notNine = notNine.next;
				while (notNine != tail) {
					notNine.val = 0;
					notNine = notNine.next;
				}
			} else if (v < 9) {
				notNine = tail;
			}
		}
		
		return notNine == dummy ? dummy.next : dummy;
	}
	
	public static ListNode fromInteger(int num) {
		int div = 1;
		while (num / div >= 10) {
			div *= 10;
		}
		
		ListNode dummy = new ListNode(-1);
		ListNode tail = dummy;
		while (div != 0) {
			tail.next = new ListNode(num / div);
			tail = tail.next;
			num = num % div;
			div /= 10;
		}
		
		return dummy.next;
	}
	
	public static int fromList(ListNode head) {
		ListNode p = head;
		int n = 0;
		while (p != null) {
			n = n * 10 + p.val;
			p = p.next;
		}
		return n;
	}
}
