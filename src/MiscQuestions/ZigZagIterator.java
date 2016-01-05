package MiscQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * http://www.fgdsb.com/2015/01/30/zigzag-iterator/
 * Extended to K iterators case.
 * @author kkdpan
 *
 */
public class ZigZagIterator<E> {
	
	private ArrayList<Iterator<E>> iterators;
	private int n;
	private int pointer;
	
	public ZigZagIterator(Collection<Iterator<E>> iterators) {
		this.iterators = new ArrayList<>(iterators);
		this.n = iterators.size();
		this.pointer = 0;
		initialize();
	}
	
	private void initialize() {
		int oldPointer = pointer;
		while (!iterators.get(pointer).hasNext() && pointer != oldPointer) {
			pointer = ++pointer % n;
		}
	}
	
	public boolean hasNext() {
		return iterators.get(pointer).hasNext();
	}
	
	public E next() {
		E ret = iterators.get(pointer).next();
		int oldPointer = pointer;
		
		do {
			pointer = ++pointer % n;
		} while (!iterators.get(pointer).hasNext() && pointer != oldPointer);
		
		return ret;
	}
	
	public static String zigzagIterator(Iterator<Character> it1, Iterator<Character> it2) {
		
		ZigZagIterator<Character> zzIterator = new ZigZagIterator<Character>(Arrays.asList(it1, it2));
		StringBuilder sb = new StringBuilder();
		while (zzIterator.hasNext()) {
			char c = zzIterator.next();
			sb.append(c);
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		Character[] s1 = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};
		Character[] s2 = {'1', '2', '3', '4'};
		Iterator<Character> it1 = Arrays.asList(s1).iterator();
		Iterator<Character> it2 = Arrays.asList(s2).iterator();
		
		System.out.println(zigzagIterator(it1, it2));
		
	}
}
