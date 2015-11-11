package MiscQuestions;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * http://www.fgdsb.com/2015/01/06/recover-quack-data-structure/
 * @author dipa
 *
 */
public class RecoverQuackDataStructure {

	private static interface Quack {
		public int peek();
		public int poll();
		public void push();
		public boolean isEmpty();
	}
	
	public static List<Integer> quackToArrayNoDup(Quack quack) {
		Queue<Integer> head = new LinkedList<>();
		Stack<Integer> tail = new Stack<>();
		
		while (!quack.isEmpty()) {
			int toAdd = quack.poll();
			if (!quack.isEmpty()) {
				int cmp = quack.peek();
				if (cmp > toAdd) {
					head.add(toAdd);
				} else {
					tail.push(toAdd);
				}
			} else {
				head.add(toAdd);
			}
		}

		while (!tail.isEmpty()) {
			head.offer(tail.pop());
		}
		return (LinkedList<Integer>)head;
	}
	
	public static List<Integer> quackToArrayHasDup(Quack quack) {
		Queue<Integer> head = new LinkedList<>();
		Stack<Integer> tail = new Stack<>();
		
		int count = 0;
		while (!quack.isEmpty()) {
			int toAdd = quack.poll();
			count++;
			if (quack.isEmpty()) {
				while (count >= 1) {
					head.add(toAdd);
					count--;
				}
				break;
			} 
			int pk = quack.peek();
			if (pk < toAdd) {
				while (count >= 1) {
					tail.push(toAdd);
					count--;
				}
			} else if (pk > toAdd) {
				while (count >= 1) {
					head.add(toAdd);
					count--;
				}
			} else {
				count++;
			}
		}
		
		while (!tail.isEmpty()) {
			head.offer(tail.pop());
		}
		return (LinkedList<Integer>)head;
	}
}
