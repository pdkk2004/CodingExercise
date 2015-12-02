package Common;

import java.util.Arrays;

/**
 * http://www.fgdsb.com/2015/01/03/implement-vector/
 * @author dipa
 *
 * @param <T>
 */
public class Vector<T> {
	
	private Object[] values;
	private static final int DEFAULT_CAPACITY = 15;
	private int capacity;
	private int size;
	
	public Vector() {
		this(DEFAULT_CAPACITY);
	}
	
	public Vector(int capacity) {
		this.capacity = capacity;
		this.values = new Object[this.capacity];
		this.size = 0;
	}
	
	@SuppressWarnings("unchecked")
	public T get(int index) {
		if (index >= this.size) {
			throw new IndexOutOfBoundsException();
		}
		return (T)values[index];
	}
	
	public void insert(int index, T val) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}
		int newSize = size + 1;
		ensureCapacity(newSize);
		for (int i = size - 1; i >= index; i--) {
			this.values[i + 1] = this.values[i];
		}
		this.values[index] = val;
		size++;
	}
	
	public void add(T val) {
		int newSize = size + 1;
		ensureCapacity(newSize);
		this.values[size++] = val;
	}
	
	@SuppressWarnings("unchecked")
	public T delete(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		T ret = (T)this.values[index];
		int movedSize = size - index - 1;
		if (movedSize > 0) {
			System.arraycopy(values, index + 1, values, index, movedSize);
		}
		this.values[--size] = null;
		return ret;
	}
	
	private void ensureCapacity(int minCapacity) {
		if (minCapacity > capacity) {
			int newCapacity = capacity * 3 / 2 + 1;
			Object[] newValues = new Object[newCapacity];
			Arrays.copyOf(values, newCapacity);
			this.values = newValues;
			this.capacity = newCapacity;
		}
	}
}	
