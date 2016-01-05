package MiscQuestions;

import org.junit.Test;
import org.junit.*;

/**
 * http://www.fgdsb.com/2015/01/03/compress-string/
 * @author kkdpan
 *
 */
public class CompressString {

	public String compressString(String origin) {
		int ol = origin.length();
		
		StringBuilder ret = new StringBuilder();
		int c = 0;
		int i = 0;
		while (i < ol) {
			c++;
			if (i == ol - 1 || origin.charAt(i) != origin.charAt(i + 1)) {
				ret.append(origin.charAt(i)).append(c);
				c = 0;
			}
			i++;
		}
		return ol < ret.length() ? origin : ret.toString();
	}
	
	@Test
	public void test() {
		String origin = "aabcccccaaa";
		Assert.assertEquals("a2b1c5a3", compressString(origin));
	}
}
