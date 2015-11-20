package MiscQuestions;

import org.junit.Test;

import org.junit.*;

/**
 * http://www.fgdsb.com/2015/01/03/number-of-one-in-binary/
 * @author dipa
 *
 */
public class NumberOfOneInBinary {
	
	public static int numberOfOne(int num) {
		int count = 0;
		while (num != 0) {
			count++;
			num = (num - 1) & num;
		}
		return count;
	}
	
	@Test
	public void test() {
		Assert.assertEquals(1, numberOfOne(1));
		Assert.assertEquals(32, numberOfOne(-1));
		Assert.assertEquals(2, numberOfOne(5));

	}
}
