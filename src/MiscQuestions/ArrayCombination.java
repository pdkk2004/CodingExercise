package MiscQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

/**
 * http://www.fgdsb.com/2015/01/17/array-combination/
 * @author dipa
 *
 */
public class ArrayCombination {

	public static ArrayList<ArrayList<Integer>> combine(ArrayList<ArrayList<Integer>> arrays, int n) {
		ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
		merge(ret, arrays, 0, n, new Stack<Integer>());
		return ret;
	}

	private static void merge(ArrayList<ArrayList<Integer>> ret, ArrayList<ArrayList<Integer>> arrays, int index,
			int num, Stack<Integer> r) {
		if (index == num) {
			ret.add(new ArrayList<Integer>(r));
			return;
		}

		ArrayList<Integer> l = arrays.get(index);
		if (l.isEmpty()) {  // Note: need to treat empty arraylist differently.
			merge(ret, arrays, index + 1, num, r);
		} else {
			for (int i = 0; i < l.size(); i++) {
				r.push(l.get(i));
				merge(ret, arrays, index + 1, num, r);
				r.pop();
			}
		}
	}

	@Test
	public void test() {
		Integer[][] arrays = { { 1, 3, 5, 7 }, { 2, 4, 6 }, { 10, 12 } };

		ArrayList<ArrayList<Integer>> input = new ArrayList<>();
		for (int i = 0; i < arrays.length; i++) {
			input.add(new ArrayList<>(Arrays.asList(arrays[i])));
		}

		ArrayList<ArrayList<Integer>> result = combine(input, input.size());
		Set<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();

		for (ArrayList<Integer> l : result) {
			System.out.println(l.toString());
			Assert.assertFalse(set.contains(l));
			set.add(l);
		}

		Assert.assertEquals(arrays[0].length * arrays[1].length * arrays[2].length, result.size());
	}
}
