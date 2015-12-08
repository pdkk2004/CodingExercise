package MiscQuestions;

import java.util.HashMap;
import java.util.Map;

/**
 * http://www.fgdsb.com/2015/01/03/check-permutation/
 * @author dipa
 *
 */
public class CheckPermutation {
	
	public static boolean isPermutation(String s1, String s2) {
		if (s1 == null || s2 == null) {
			return s1 == s2;
		}
		
		if (s1.length() != s2.length()) {
			return false;
		}
		
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (char c : s1.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		
		for (char c : s2.toCharArray()) {
			int count = map.getOrDefault(c, 0);
			if (count == 0) {
				return false;
			} else {
				map.put(c, count - 1);
			}
		}
		return true;
	}
}
