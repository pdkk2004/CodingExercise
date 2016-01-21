package test.miscQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import MiscQuestions.MergeSortedIterator;

public class MergeSortedIteratorTest {

	@Test
	public void test() {
		Integer[] array1 = {1, 3, 5, 7};
		Integer[] array2 = {2, 4, 6, 8};
		Integer[] array3 = {0, 5, 9};
		List<Iterator<Integer>> iterators = new ArrayList<Iterator<Integer>>();
		iterators.add(Arrays.asList(array1).iterator());
		iterators.add(Arrays.asList(array2).iterator());
		iterators.add(Arrays.asList(array3).iterator());
		MergeSortedIterator<Integer> mIterator = new MergeSortedIterator<>(iterators);
		while (mIterator.hasNext()) {
			System.out.print(mIterator.next() + " ");
		}
	}
}
