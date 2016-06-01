package Common;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class UnionFindSet<T> {

	private static class Node<T> {
		private T parent;
		private int rank;
		private T value;
		
		public Node(T value) {
			this.value = value;
			this.rank = 0;
			this.parent = value;
		}
	}
	
	private Map<T, Node<T>> map;
	private int setNum;
	
	public UnionFindSet() {
		map = new HashMap<>();
		setNum = 0;
	}
	
	public UnionFindSet(Collection<T> values) {
		this();
		for (T v: values) {
			makeSet(v);
		}
	}
	
	/**
	 * Add new value into this DisjointSet.
	 * If the value is already exist, do nothing.
	 * @param value
	 */
	public void makeSet(T value) {
		if (!map.containsKey(value)) { 
			map.put(value, new Node<T>(value));
			setNum++;
		}
	}
	
	/**
	 * Find the representative T of the disjoint set that value belongs to.
	 * If value does not exist, return null.
	 * @param value
	 * @return
	 */
	public T findSet(T value) {
		Node<T> node = map.get(value);
		if (node == null) {
			return null;
		}
		while (!node.parent.equals(node.value)) {
			Node<T> pNode = map.get(node.parent);
			node.parent = pNode.parent;
			node = pNode;
		} 
		return node.parent;
	}
	
	/**
	 * Union the two disjoint sets that v1 and v2 belongs to.
	 * @param v1
	 * @param v2
	 */
	public void union(T v1, T v2) {
		T vp1 = findSet(v1);
		T vp2 = findSet(v2);
		if (vp1 == null || vp2 == null || vp1 == vp2) {
			return;
		}
		
		Node<T> n1 = map.get(vp1);
		Node<T> n2 = map.get(vp2);
		if (n1.rank > n2.rank) {
			n2.parent = n1.value;
		} else {
			if (n1.rank == n2.rank) {
				n2.rank += 1;
			}
			n1.parent = n2.value;
		}
		setNum--;
	}
	
	public void removeSet(T o) {
		T set = findSet(o);
		if (set == null) {
			return;
		}
		Iterator<T> iter = map.keySet().iterator();
		while (iter.hasNext()) {
			T v = iter.next();
			// remove v if v == set, and remove set at last.
			// Otherwise, findSet() will fail!!!
			if (v != set && findSet(v) == set) {
				iter.remove();
			}
		}
		map.remove(set);
		setNum--;
	}

	public int getSetNum() {
		return setNum;
	}
}
