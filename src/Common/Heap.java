package Common;

import java.util.Arrays;
import java.util.Comparator;

public class Heap<T> {
	
	private int capacity;
	private T[] data;
	private int size;
	private Comparator<? super T> comparator;
	private static final int DEFAULT_CAPACITY = 5;
	
	public Heap(int capacity) {
		this(capacity, null);
	}
	
	@SuppressWarnings("unchecked")
	public Heap(int capacity, Comparator<? super T> comparator) {
		this.capacity = capacity;
		this.comparator = comparator;
		this.data = (T[])new Object[this.capacity + 1];
	}
	
	public Heap() {
		this(DEFAULT_CAPACITY, null);
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public Heap(Comparator<? super T> comparator) {
		this(DEFAULT_CAPACITY, comparator);
	}
	
	private void heapify(int n) {
		int left = getLeftIndex(n);
		int right = getRightIndex(n);
		int maxPos = n;
		if ( hasLeft(n) && compare(data[left], data[n]) > 0) {
			maxPos = left;
		}
		if (hasRight(n) && compare(data[right], data[maxPos]) > 0) {
			maxPos = right;
		}
		if (maxPos != n) {
			T temp = data[maxPos];
			data[maxPos] = data[n];
			data[n] = temp;
			heapify(maxPos);
		}
	}
	
	public T peek() {
		return size > 0 ? data[1] : null;
	}
	
	public int size() {
		return this.size;
	}
	
	public T poll() {
		if (size == 0) {
			return null;
		}
		T ret = data[1];
		data[1] = data[size--];
		heapify(1);
		return ret;
	}
	
	public boolean remove(T value) {
		int i = 1;
		while (i <= size && compare(value, data[i]) != 0) {
			i++;
		}
		if (i < size) {
			data[i] = data[size];
			data[size--] = null;
			heapify(i);
			return true;
		} else if (i == size) {
			data[i] = null;
			size--;
			return true;
		}
		else {
			return false;
		}
	}
	
	private void SiftUp() {
		int p = size;
		while (hasParent(p)) {
			int parent = getParentIndex(p);
			if (compare(data[parent], data[p]) < 0) {
				T temp = data[parent];
				data[parent] = data[p];
				data[p] = temp;
				p = parent;
			} else {
				break;
			}
		}
	}
	
	public void add(T value) {
		if (size >= capacity) {
			T[] newData = Arrays.copyOf(data, size * 2 + 1);
			this.capacity = size * 2;
			data = newData;
		}
		size++;
		data[size] = value;
		this.SiftUp();
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		int i = 1;
		while (i < size) {
			sb.append(data[i] + ",");
			i++;
		}
		sb.append(data[i]);
		return sb.toString();
	}
	
	public T[] toArray(T[] array) {
		for (int i = 0; i < array.length; i++) {
			if (i + 1 <= size) {
				array[i] = (T)data[i + 1];
			} else {
				break;
			}
		}
		return array;
	}
	
	private boolean hasParent(int index) {
		return index > 1;
	}
	
	private boolean hasLeft(int index) {
		return index > 0 && 2 * index <= size;
	}
	
	private boolean hasRight(int index) {
		return index > 0 && 2 * index + 1 <= size;
	}
	
	private int getLeftIndex(int index) {
		return 2 * index;
	}
	
	private int getRightIndex(int index) {
		return 2 * index + 1;
	}
	
	private int getParentIndex(int index) {
		return index / 2;
	}
	
	@SuppressWarnings("unchecked")
	private int compare(T t1, T t2) {
		if (this.comparator != null) {
			return comparator.compare(t1, t2);
		} else {
			Comparable<? super T> cmp = (Comparable<? super T>) t1;
			return cmp.compareTo(t2);
		}
	}
	
}
