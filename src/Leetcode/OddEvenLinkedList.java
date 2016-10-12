package Leetcode;

import Common.ListNode;

public class OddEvenLinkedList {

    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode evenHead = new ListNode(-1);
        ListNode evenTail = evenHead;
        ListNode p = head;
        while (p != null && p.next != null) {
            evenTail.next = p.next;
            p.next = p.next.next;
            evenTail = evenTail.next;
            evenTail.next = null;
            if (p.next == null) {  //Pay attention to line 22-24. If the size of list is even, this condition guards p won't move to null.
                break;
            }
            p = p.next;
        }
        p.next = evenHead.next;
        return head;
    }
}
