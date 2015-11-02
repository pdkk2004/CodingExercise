package MiscQuestions;

import org.junit.Test;
import org.junit.*;

/**
 * http://www.fgdsb.com/2015/01/13/word-distance/
 * @author kkdpan
 *
 */
public class ShortestWordDistance {
	
	public static int shortestWordDistance(String[] strs, String s1, String s2) {
		int l = strs.length;
		int i = 0;
		int minDist = Integer.MAX_VALUE;
		int pre = -1;
		while (i < l) {
			if (strs[i].equals(s1) || strs[i].equals(s2)) {
				if (pre >= 0 && !strs[pre].equals(strs[i])) {
					minDist = Math.min(minDist, i - pre);
				}
				pre = i;
			}
			i++;
		}
		return minDist;
	}
	
	@Test
	public void Test() {
		String[] strs = {"the", "quick", "brown", "fox", "quick"};
		Assert.assertEquals(3, shortestWordDistance(strs, "fox", "the"));
		Assert.assertEquals(1, shortestWordDistance(strs, "fox", "quick"));
	}
}	
