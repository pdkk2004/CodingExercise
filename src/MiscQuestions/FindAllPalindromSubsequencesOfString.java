package MiscQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.*;

/**
 * Very interesting interview question, and the solution is genius!! 
 * http://www.mitbbs.com/article/JobHunting/33053715_0.html
 * @author kkdpan
 *
 */
public class FindAllPalindromSubsequencesOfString {

	public static List<String> findAllPalindromSubsequence(String str) {
		Map<Character, ArrayList<Integer>> lookToEnd = new HashMap<>();
		Map<Character, ArrayList<Integer>> lookToHead = new HashMap<>();
		Set<Character> charSet = new HashSet<>();
		int len = str.length();
		
		for (int i = 0; i < len; i++) {
			charSet.add(str.charAt(i));
		}
		
		for (int i = 0; i < len; i++) {
			for (char c : charSet) {
				ArrayList<Integer> lookup = lookToHead.get(c);
				if (lookup == null) {
					lookup = new ArrayList<>();
					lookToHead.put(c, lookup);
				}
				if (c == str.charAt(i)) {
					lookup.add(i, i);
				} else {
					if (i == 0) {
						lookup.add(i, null);
					} else {
						lookup.add(i, lookup.get(i - 1));
					}
				}
			}
		}
		
		for (int i = len - 1; i >= 0; i--) {
			for (char c : charSet) {
				ArrayList<Integer> lookup = lookToEnd.get(c);
				if (lookup == null) {
					lookup = new ArrayList<>();
					lookToEnd.put(c, lookup);
				}
				if (c == str.charAt(i)) {
					lookup.add(len - 1 - i, i);
				} else {
					if (i == len - 1) {
						lookup.add(len - 1 - i, null);
					} else {
						lookup.add(len - 1 - i, lookup.get(len - i - 2));
					}
				}
			}
		}
		
		for (char c : charSet) {
			Collections.reverse(lookToEnd.get(c));
		}
		
		List<String> ret = new LinkedList<>();
		findAllPalindromeRec(str, 0, str.length() - 1, charSet, lookToHead, lookToEnd, ret, new StringBuilder());
		return ret;
	}
	
	private static void findAllPalindromeRec(String str, 
			int left,
			int right,
			Set<Character> charSet,
			Map<Character, ArrayList<Integer>> lookToHead,
			Map<Character, ArrayList<Integer>> lookToEnd,
			List<String> ret,
			StringBuilder sb) {

		if (left > right) {
			return;
		}

		for (Character c : charSet) {
			Integer leftMost = lookToEnd.get(c).get(left);
			Integer rightMost = lookToHead.get(c).get(right);
			
			// Core logic!!
			if (leftMost != null && leftMost < right) {
				String s = sb.toString() + c + sb.reverse().toString();
				ret.add(s);
				if (leftMost < rightMost) {
					sb.append(c);
					findAllPalindromeRec(str, left + 1, right - 1, charSet, lookToHead, lookToEnd, ret, sb);
					sb.deleteCharAt(sb.length() - 1);
				}
			}
		}
	}
	
	@Test
	public void Test() {
		String test = "abcbabcba";
		List<String> ret = findAllPalindromSubsequence(test);
		Collections.sort(ret);
		for (String s : ret) {
			System.out.println(s);
		}
	}
}
