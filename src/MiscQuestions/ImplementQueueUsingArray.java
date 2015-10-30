package MiscQuestions;

public class ImplementQueueUsingArray {

	public static class ArrayQueue<T> {

		private final static int DEFAULT_CAPACITY = 20;
		
		private T[] array;
		private int front;
		private int tail;
		private int capacity;
		private int size;

		
		public ArrayQueue() {
			this(DEFAULT_CAPACITY);
		}
		
		@SuppressWarnings("unchecked")
		public ArrayQueue(int capacity) {
			array = (T[])new Object[capacity];
			front = -1;
			tail = -1;
		}
		
		public boolean enqueue(T value) {
			if ((tail + 1) % capacity == front) {
				return false;
			} else if (isEmpty()) {
				front++;
				tail++;
			} else {
				tail = (tail + 1) % capacity;
			}
			array[tail] = value;
			size++;
			return true;
		}
		
		public T dequeue() {
			T ret = null;
			if (isEmpty()) {
				return null;
			} else if (front == tail) {
				ret = array[front];
				front = -1;
				tail = -1;
			} else {
				ret = array[front];
				front = (front + 1) % capacity;
			}
			size--;
			return ret;
		}
		
		public boolean isEmpty() {
			return front == -1 && tail == -1;
		}
	}
}
