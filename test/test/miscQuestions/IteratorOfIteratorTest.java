package test.miscQuestions;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import MiscQuestions.IteratorOfIterator;

public class IteratorOfIteratorTest {
	
	@Test
	public void TestIteratorOfIterator() {
		Integer[] array1 = {1, 4, 7, 10};
		Integer[] array2 = {2, 5, 8, 11, 14};
		Integer[] array3 = {3, 6, 9};
		List<Integer> l1 = Arrays.asList(array1);
		List<Integer> l2 = Arrays.asList(array2);
		List<Integer> l3 = Arrays.asList(array3);
		List<Iterator<Integer>> iteratorList = new LinkedList<Iterator<Integer>>();
		iteratorList.add(l1.iterator());
		iteratorList.add(l2.iterator());
		iteratorList.add(l3.iterator());
		
		IteratorOfIterator<Integer> iter = new IteratorOfIterator<>(iteratorList.iterator());
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
}
