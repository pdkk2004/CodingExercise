package Leetcode;

import Common.ListNode;

public class Add2Numbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int s = carry;
            if (l1 != null) {
                s += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                s += l2.val;
                l2 = l2.next;
            }
            
            carry = s / 10;
            int residue = s % 10;
            tail.next = new ListNode(residue);
            tail = tail.next;
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return dummy.next;
    }
}
