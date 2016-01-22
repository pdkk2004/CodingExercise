package MiscQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * http://www.fgdsb.com/2015/01/13/design-special-container/
 * Solution: Use Map and Vector, or Use Map and Double LinkedList.
 * @author dipa
 *
 */
public class DesignSpecialContainer {

	public static class Container<V> {
		private Map<V, Integer> map;
		private ArrayList<V> vector;
		private int size;
		
		public Container() {
			this.map = new HashMap<V, Integer>();
			this.vector = new ArrayList<V>();
		}
		
		public void add(V v) {
			if (size < vector.size()) {
				vector.set(size++, v);
				map.put(v, size - 1);
			} else {
				vector.add(v);
				map.put(v, size++);
			}
		}
		
		public void delete(V v) {
			int index = map.getOrDefault(v, -1);
			if (index >= 0) {
				vector.set(index, vector.get(--size));
				map.put(vector.get(index), index);
				map.remove(v);  // Remeber to remove v from map.
			} else {
				throw new NoSuchElementException();
			}
		}
		
		public boolean isEmpty() {
			return size == 0;
		}
		
		public V getRandom() {
			if (isEmpty()) {
				throw new NoSuchElementException();
			} else {
				int rand = (int)(Math.random() * size);
				return vector.get(rand);				
			}
		}
	}
	
}
