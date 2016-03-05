package Leetcode;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class GeneralizedAbbreviation {
	
	public static List<String> generalizedAbbreviation(String word) {
		LinkedList<String> ret = new LinkedList<String>();
		dfs(word, 0, new StringBuilder(), ret, 0);
		return ret;
	}
	
	private static void dfs(String word, int index, StringBuilder sb, LinkedList<String> ret, int count) {
		if (index == word.length()) {
			ret.add(sb.toString());
			return;
		}
		
		sb.append(word.charAt(index));
		dfs(word, index + 1, sb, ret, 0);
		sb.deleteCharAt(sb.length() - 1);
		
		if (count == 0) {
			sb.append(count + 1);
		} else {
			sb.deleteCharAt(sb.length() - 1);
			sb.append(count + 1);
		}
		dfs(word, index + 1, sb, ret, count + 1);
		if (count == 0) {
			sb.deleteCharAt(sb.length() - 1);
		}
	}
	
	@Test
	public void test() {
		List<String> ret = generalizedAbbreviation("word");
		System.out.println(ret.toString());
	}
}
