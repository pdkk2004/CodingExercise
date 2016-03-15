package Leetcode;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class FlipGame {
	
	public static List<String> flipGame(String input) {
		List<String> ret = new LinkedList<String>();
		
		for (int i = 0; i < input.length() - 1; i++) {
			if (input.charAt(i) == '+' && input.charAt(i) == input.charAt(i + 1)) {
				StringBuilder sb = new StringBuilder(input);
				sb.replace(i, i + 2, "--");
				ret.add(sb.toString());
			}
		}
		return ret;
	}
	
	@Test
	public void test() {
		System.out.println(flipGame("++++"));
	}
}
