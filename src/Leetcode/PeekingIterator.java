package Leetcode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class PeekingIterator<E> implements Iterator<E> {

	private Queue<E> queue;
	private Iterator<E> iter;
	
	public PeekingIterator(Iterator<E> iter) {
		this.queue = new LinkedList<E>();
		this.iter = iter;
	}
	
	@Override
	public boolean hasNext() {
		return iter.hasNext() || !queue.isEmpty();
	}

	@Override
	public E next() {
		if (!queue.isEmpty()) {
			return queue.poll();
		}
		return iter.next();
	}
	
	public E peek() {
		if (queue.isEmpty() && iter.hasNext()) {
			queue.offer(iter.next());
		}
		return queue.peek();
	}
	
}
