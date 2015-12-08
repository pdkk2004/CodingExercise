package MiscQuestions;

import org.junit.Assert;
import org.junit.Test;

/**
 * http://www.fgdsb.com/2015/01/03/abbreviation-match/
 * @author dipa
 *
 */
public class AbbreviationMatch {
	
	public static boolean match(String origin, String abbre) {
		
		int oi = 0, ai = 0;
		while (ai < abbre.length()) {
			if (isAlpha(abbre.charAt(ai))) {
				if (oi >= origin.length() || abbre.charAt(ai) != origin.charAt(oi)) {
					return false;
				}
				ai++;
				oi++;
			} else {
				int n = 0, j = ai;
				while (j < abbre.length() && isNum(abbre.charAt(j))) {
					n = n * 10 + abbre.charAt(j) - '0';
					j++;
				}
				ai = j;
				oi += n;
			}
		}
		return oi == origin.length() && ai == abbre.length();
	}
	
	private static boolean isAlpha(char c) {
		return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z';
	}
	
	private static boolean isNum(char c) {
		return c >= '0' && c <= '9';
	}
	
	@Test
	public void test() {
		String origin = "apple";
		//Positive cases
		Assert.assertTrue(match(origin, "5"));
		Assert.assertTrue(match(origin, "a4"));
		Assert.assertTrue(match(origin, "4e"));
		Assert.assertTrue(match(origin, "a3e"));
		//Negative cases
		Assert.assertFalse(match(origin, "a4e"));
		Assert.assertFalse(match(origin, "6"));
		Assert.assertFalse(match(origin, "a5"));
		Assert.assertFalse(match(origin, "5e"));
		Assert.assertFalse(match(origin, "3e"));
		
		origin = "internationalization";
		Assert.assertTrue(match(origin, "i5a11o1"));

	}
}
