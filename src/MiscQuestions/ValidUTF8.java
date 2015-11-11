package MiscQuestions;

import org.junit.Assert;
import org.junit.Test;

/**
 * http://www.fgdsb.com/2015/01/10/valid-utf8/
 * Note: In java, bitwise operator applied on byte will be automatically promote to Int.
 * @author kkdpan
 *
 */
public class ValidUTF8 {

	public static boolean validUTF8(char[] chars) {
		int size = 0;
		for (char b : chars) {
			if (size == 0) {
				if ((b >> 5) == 0b110) {
					size = 1;
				} else if ((b >> 4) == 0b1110) {
					size = 2;
				} else if ((b >> 3) == 0b11110) {
					size = 3;
				} else if ((b >> 7) == 0b1) {
					return false;
				}
			} else {
				if ((b >>> 6) != 0b10) {
					return false;
				}
				size--;
			}
		}
		return size == 0;
	}
	
	@Test
	public void test() {
		char[] bytes = {(char)0b10101010};
		Assert.assertFalse(validUTF8(bytes));
	}
}
