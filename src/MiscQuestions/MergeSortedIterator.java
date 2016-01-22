package MiscQuestions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class MergeSortedIterator<V extends Comparable<? super V>> {

	private ArrayList<Iterator<V>> iterList;
	
	private PriorityQueue<Pair<V, Integer>> heap;
	
	private static class Pair<K, T> {
		
		private K first;
		private T second;
		
		public Pair(K k, T t) {
			this.first = k;
			this.second = t;
		}
	}
	
	public MergeSortedIterator(Collection<Iterator<V>> iterators) {
		this.iterList = new ArrayList<Iterator<V>>(iterators);
		this.heap = new PriorityQueue<Pair<V, Integer>>((p1, p2) -> p1.first.compareTo(p2.first));
		for (int i = 0; i < iterators.size(); i++) {
			if (iterList.get(i).hasNext()) {
				heap.offer(new Pair<V, Integer>(iterList.get(i).next(), i));
			}
		}
		
		Comparator<Integer> c = Comparator.comparing(x -> x);
	}
	
	public boolean hasNext() {
		return !heap.isEmpty();
	}
	
	public V next() {
		Pair<V, Integer> p = heap.poll();
		Iterator<V> iter = this.iterList.get(p.second);
		if (iter.hasNext()) {
			heap.offer(new Pair<>(iter.next(), p.second));
		}
		return p.first;
	}
}
