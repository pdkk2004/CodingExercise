package MiscQuestions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

import org.junit.Test;

import Common.ListNode;

/**
 * http://www.fgdsb.com/2015/01/17/smallest-range/
 * @author kkdpan
 *
 */
public class SmallestRange {
	
	public static int[] smallestRange(List<ListNode> input) {
		int[] ret = {-1, -1};
		PriorityQueue<ListNode> heap = new PriorityQueue<>();
		
		int max = Integer.MIN_VALUE;
		for (ListNode node : input) {
			heap.offer(node);
			if (max < node.val) {
				max = node.val;
			}
		}
		
		if (heap.isEmpty()) {
			return ret;
		}
		
		int minRange = Integer.MAX_VALUE;
		while (heap.size() == input.size()) {   //Note: need to keep heap.size() == input.size() condition in loop.
			ListNode minNode = heap.poll();
			int range = max - minNode.val;
			if (range < minRange) {
				ret[0] = minNode.val;
				ret[1] = max;
				minRange = range;
			}
			if (minNode.next != null) {
				heap.offer(minNode.next);
				if (minNode.next.val > max) {
					max = minNode.next.val;
				}
			}
		}
		
		return ret;
	}
	
	@Test
	public void test() {
		ListNode l1 = new ListNode(4);
		l1.next = new ListNode(10);
		l1.next.next = new ListNode(15);
		l1.next.next.next = new ListNode(24);
		l1.next.next.next.next = new ListNode(26);
		
		ListNode l2 = new ListNode(0);
		l2.next = new ListNode(9);
		l2.next.next = new ListNode(12);
		l2.next.next.next = new ListNode(20);
		
		ListNode l3 = new ListNode(5);
		l3.next = new ListNode(18);
		l3.next.next = new ListNode(22);
		l3.next.next.next = new ListNode(30);
		
		List<ListNode> list = new LinkedList<>();
		list.add(l1);
		list.add(l2);
		list.add(l3);
		
		int[] range = smallestRange(list);
		System.out.println(Arrays.toString(range));
	}
}
