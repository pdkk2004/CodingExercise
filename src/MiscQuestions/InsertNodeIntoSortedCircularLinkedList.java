package MiscQuestions;

import Common.ListNode;

public class InsertNodeIntoSortedCircularLinkedList {
	
	public static ListNode insert(int value, ListNode head) {
		// When input LinkedList is null,
		// need to create new list when input Linkedlist is empty
		if (head == null) {
			head = new ListNode(value);
			head.next = head;
			return head;
		}
		
		ListNode p = head;
		while (p.next != head) {
			if (value >= head.val && value <= head.next.val) {
				break;
			} else if (p.val > p.next.val && (value < p.next.val || value > p.val)) { //Note this edge case when value is bigger than largest or smaller than smallest value.  
				break;
			} else {
				p = p.next;
			}
		}
		
		ListNode temp = p.next;
		p.next = new ListNode(value);
		p.next.next = temp;
		return head;
	}
}
