package MiscQuestions;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class IteratorOfIterator<E> implements Iterator<E> {
		
	private Queue<Iterator<E>> queue;
	
	private Iterator<E> iter;
	
	public IteratorOfIterator(Iterator<Iterator<E>> iterator) {
		this.queue = new LinkedList<Iterator<E>>();
		while (iterator.hasNext()) {
			Iterator<E> i = iterator.next();
			if (i.hasNext()) {
				this.queue.offer(i);
			}
		}
		this.iter = this.queue.poll();
	}
	
	public boolean hasNext() {
		return iter != null;
	}
	
	public E next() {
		if (hasNext()) {
			E element = iter.next();
			if (iter.hasNext()) {
				queue.offer(iter);
			}
			iter = queue.poll();
			return element;
		} else {
			throw new NoSuchElementException();
		}
	}
}
