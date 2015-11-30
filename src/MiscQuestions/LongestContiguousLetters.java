package MiscQuestions;

import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * http://www.mitbbs.com/article_t/JobHunting/32407699.html
 * @author dipa
 *
 */
public class LongestContiguousLetters {
	
	/**
	 * Two pass solution
	 * @param str
	 * @return
	 */
	public static List<Character> longestContiguousLetters2Pass(String str) {
		List<Character> ret = new LinkedList<>();
		
		int l = str.length();
		int i = 0;
		int max = 0;
		while (i < l) {
			if (str.charAt(i) == ' ') {
				i++;
				continue;
			}
			int j = i + 1;
			while (j < l && str.charAt(j) == str.charAt(i)) {
				j++;
			}
			max = Math.max(j - i, max);
			i = j;
		}
		
		i = 0;
		while (i < l) {
			if (str.charAt(i) == ' ') {
				i++;
				continue;
			}
			int j = i + 1;
			while (j < l && str.charAt(j) == str.charAt(i)) {
				j++;
			}
			if (j - i == max) {
				ret.add(str.charAt(i));
			}
			i = j;
		}
		return ret;
	}

	public static List<Character> longestContiguousLetters1Pass(String str) {
		LinkedList<Character> ret = new LinkedList<>();
		int max = 0;
		int i = 0, l = str.length();
		while (i < l) {
			if (str.charAt(i) == ' ') {
				i++;
				continue;
			}
			int j = i + 1;
			while (j < l && str.charAt(j) == str.charAt(i)) {
				j++;
			}
			if (j - i >= max) {
				if (j - i > max) {
					ret.clear();
					max = j - i;
				}
				ret.addLast(str.charAt(i));
			}
			i = j;
		}
		return ret;
	}
	
	
	@Test
	public void test() {
		String test1 = "this is a sentence";
		Character[] expected1 = {'t', 'h', 'i', 's', 'i', 's', 'a', 's', 'e', 'n', 't', 'e', 'n', 'c', 'e'};
		
		//Verify 2 pass
		Character[] actual1 = new Character[expected1.length];
		longestContiguousLetters2Pass(test1).toArray(actual1);
		Assert.assertArrayEquals(expected1, actual1);
		
		//Verify 1 pass;
		Character[] actual11 = new Character[expected1.length];
		longestContiguousLetters1Pass(test1).toArray(actual11);
		Assert.assertArrayEquals(expected1, actual11);
		
		String test2 = "thiis iss a senntencee";
		Character[] expected2 = {'i', 's', 'n', 'e'};
		Character[] actual2 = new Character[expected2.length];
		
		//Verify 1 pass
		List<Character> ret = longestContiguousLetters2Pass(test2);
		System.out.println(ret.toString());
		ret.toArray(actual2);
		Assert.assertArrayEquals(expected2, actual2);
		
		//Verify 2 pass
		List<Character> ret1 = longestContiguousLetters1Pass(test2);
		Character[] actual22 = new Character[expected2.length];
		ret1.toArray(actual22);
		Assert.assertArrayEquals(expected2, actual22);
	}
	
}
