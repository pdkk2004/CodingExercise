package MiscQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * http://www.fgdsb.com/2015/01/12/valid-triangles/
 * @author dipa
 *
 */
public class ValidTriangle {

	/**
	 * Find first valid triangle;
	 * @param input
	 * @return
	 */
	public static List<Integer> validTriangle(ArrayList<Integer> input) {
		Collections.sort(input);
		
		int l = input.size();
		for (int i = 0; i < l - 2; i++) {
			int k = i + 2;
			for (int j = i + 1; j < k && k < l - 1; j++) {
				if (input.get(i) + input.get(j) > input.get(k)) {
					return Arrays.asList(input.get(i), input.get(j), input.get(k));
				} else {
					k++;
				}
			}
		}
		return Collections.emptyList();
	}
	
	/**
	 * Find the number of all valid triangle;
	 * @param input
	 * @return
	 */
	public static int countValidTriangle(ArrayList<Integer> input) {
		Collections.sort(input);
		
		int l = input.size();
		int count = 0;
		for (int i = 0; i < l - 2; i++) {
			int k = i + 2;
			for (int j = i + 1; j < k && k < l; j++) {
				while (k < l && input.get(i) + input.get(j) > input.get(k)) {
					count++;
					k++;
				}
				k = j + 2;
			}
		}
		return count;
	}
	
	@Test
	public void test() {
		ArrayList<Integer> input = new ArrayList<Integer>();
		input.add(2);
		input.add(4);
		input.add(5);
		input.add(8);
		input.add(9);
		List<Integer> result = validTriangle(input);
		System.out.println(result);
		Assert.assertArrayEquals(new Integer[]{2, 4, 5}, result.toArray(new Integer[3]));
		Assert.assertEquals(5, countValidTriangle(input));
	}
	
	@Test
	public void test1() {
		ArrayList<Integer> input = new ArrayList<Integer>();
		input.add(2);
		input.add(4);
		input.add(7);
		input.add(10);
		List<Integer> result = validTriangle(input);
		System.out.println(result);
		Assert.assertTrue(result.isEmpty());
		Assert.assertEquals(0, countValidTriangle(input));
	}
}
