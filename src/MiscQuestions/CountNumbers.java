package MiscQuestions;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/*
 * http://www.fgdsb.com/2015/01/03/count-numbers/#more
 */
public class CountNumbers {
	
	public static Map<Integer, Integer> countNumbers(int[] array) {
		int l = array.length;
		int i = 0;
		int c = 0;
		Map<Integer, Integer> ret = new HashMap<>();
		while (i < l) {
			c++;
			if (i == l - 1 || array[i] != array[i + 1]) {
				ret.put(array[i], c);
				c = 0;
			}
			i++;
		}
		return ret;
	}
	
	@Test
	public void test() {
		int[] input = {8,8,8,9,9,11,15,16,16,16};
		Map<Integer, Integer> ret = countNumbers(input);
		System.out.println(ret.toString());
	}
}
