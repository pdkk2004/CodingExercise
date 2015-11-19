package MiscQuestions;

import org.junit.Test;

import org.junit.*;

/**
 * http://www.fgdsb.com/2015/01/03/replace-string/
 * @author dipa
 *
 */
public class ReplaceString {
	
	public static String replaceString(String str, String orgin, String newStr) {
		StringBuilder sb = new StringBuilder();
		int i = 0;
		while (i < str.length()) {
			int j = 0;
			while (j < orgin.length() && i + j < str.length()) {
				if (str.charAt(i + j) != orgin.charAt(j)) {
					break;
				}
				j++;
			}
			if (j == orgin.length()) {
				sb.append(newStr);
				i = i + orgin.length();
			} else {
				sb.append(str.charAt(i));
				i++;
			}
		}
		return sb.toString();
	}
	
	@Test
	public void test() {
		String s = "abcideidhpoeababpia";
		String orgin = "ab";
		String newStr = "ABC";
		String replaced = replaceString(s, orgin, newStr);
		Assert.assertEquals("ABCcideidhpoeABCABCpia", replaced);
	}
}
