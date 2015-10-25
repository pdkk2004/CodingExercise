package MiscQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class ZigZagIterator {
	public static String zigzagIterator(Iterator<Character> it1, Iterator<Character> it2) {
		
		ArrayList<Iterator<Character>> iters = new ArrayList<>();
		iters.add(it1);
		iters.add(it2);
		int count = 0;
		StringBuilder sb = new StringBuilder();
		while (iters.get(0).hasNext() && iters.get(1).hasNext()) {
			sb.append(iters.get(count % 2).next());
			count++;
		}
		
		it1.forEachRemaining(c -> sb.append(c));
		it2.forEachRemaining(c -> sb.append(c));
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
