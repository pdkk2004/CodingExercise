package MiscQuestions;

import java.util.HashSet;
import java.util.Set;
import org.junit.*;

/**
 * http://www.fgdsb.com/2015/01/16/valid-rolling-string/
 * Rolling hash: hash = a0*C^0 + a1*C^1 + a2*C^2...+ak*C^k
 * @author kkdpan
 *
 */
public class ValidRollingHashString {
	
	public boolean validRollingHashString(String str, int a, int k) {
		long allComb = (long)Math.pow((double)a, (double)k);
		long length = allComb + k - 1;
		if (str.length() < length) {
			return false;
		}
		
		int p = 29;
		long hash = 0;
		int base = 1;
		for (int i = 0; i < k; i++) {
			int num = str.charAt(i) - '0';
			if (num >= a) {
				return false;
			}
			hash += num * base;
			base *= p;
		}
		base /= p;
		
		Set<Long> set = new HashSet<Long>();
		set.add(hash);
		for (int i = k; i < str.length(); i++) {
			int num = str.charAt(i) - '0';
			if (num >= a) {
				return false;
			}
			hash = hash / p + base * num;
			set.add(hash);
		}
		return set.size() == allComb;
	}
	
	@Test
	public void Test() {
		Assert.assertEquals(false, validRollingHashString("0011",2,2));
		Assert.assertEquals(false, validRollingHashString("001103",2,2));
		Assert.assertEquals(false, validRollingHashString("10110",2,2));
		Assert.assertEquals(true, validRollingHashString("00110",2,2));
		Assert.assertEquals(false, validRollingHashString("00111",2,2));
		Assert.assertEquals(true, validRollingHashString("4537860129",10,1));
		Assert.assertEquals(false, validRollingHashString("0123456789",10,2));

	}
}
