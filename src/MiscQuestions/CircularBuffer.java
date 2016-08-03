package MiscQuestions;

import java.util.NoSuchElementException;

public class CircularBuffer {

	private int[] array;
	private int capacity;
	private int b;
	private int e;
	private int size;
	
	public CircularBuffer(int capacity) {
		this.capacity = capacity;
		this.array = new int[capacity];
		this.b = -1;
		this.e = -1;
		this.size = 0;
	}
	
	public void add(int v) {
		if ((e + 1) % capacity == b) {
			removeFirst();
		}
		
		if (isEmpty()) {
			b = 0;
			e = 0;
		} else {
			e = (e + 1) % capacity;
		}
		array[e] = v;
		size++;
	}
	
	public int removeFirst() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		int ret = array[b];
		if (b == e) {
			b = -1;
			e = -1;
		} else {
			b = (b + 1) % capacity;
		}
		size--;
		return ret;
	}
	
	public boolean isEmpty() {
		return b == -1 && e == -1;
	}
}
