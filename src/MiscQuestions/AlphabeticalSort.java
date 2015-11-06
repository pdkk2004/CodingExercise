package MiscQuestions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * http://www.fgdsb.com/2015/01/08/alphabetical-sorting/
 * @author kkdpan
 *
 */
public class AlphabeticalSort {
	
	public void sort(String[] strs, String sequence) {
		Arrays.sort(strs, new AlphabeticalComparator(sequence));
	}
	
	private class AlphabeticalComparator implements Comparator<String> {
		
		private Map<Character, Integer> map;
		
		public AlphabeticalComparator(String sequence) {
			char[] chars = sequence.toCharArray();
			map = new HashMap<Character, Integer>();
			for (int i = 0; i < chars.length; i++) {
				map.put(chars[i], i);
			}
		}
		
		public int compare(String s1, String s2) {
			for (int i = 0; i < s1.length() && i < s2.length(); i++) {
				if (s1.charAt(i) != s2.charAt(i)) {
					return map.get(s1.charAt(i)) - map.get(s2.charAt(i));
				}
			}
			
			return s1.length() - s2.length();
		}
	}
	
	@Test
	public void test() {
		String[] strs = {"face", "ball", "apple", "art", "ah"};
		String sequence = "htarfbp";
		sort(strs, sequence);
		System.out.println(Arrays.toString(strs));
	}
}
