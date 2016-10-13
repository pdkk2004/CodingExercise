package MiscQuestions;

import org.junit.Assert;
import org.junit.Test;
public class MinReplaceOperationsToSortArrayWithOnly2Nums {

	/**
	 * The input chars contains only 'a' or 'b'. 
	 * Given an operation to replace a character at certain place from 'a' to 'b' or from 'b' to 'a',
	 * now calculate the minimal replace operation needed to sort the char array with all 'a' are in front of 'b'.
	 * @param chars
	 * @return
	 */
	public int minOperations(char[] chars) {
		int l = chars.length;
		int[] fromLeft = new int[l];
		int cntA = 0;
		for (int i = 0; i < l; i++) {
			fromLeft[i] = cntA;
			if (chars[i] == 'b') {
				cntA++;
			}
		}
		
		int fromRight = 0;
		int ret = l;
		for (int i = l - 1; i >= 0; i--) {
			if (chars[i] == 'a') {
				fromRight++;
			}
			ret = Math.min(fromRight + fromLeft[i], ret);
		}
		return ret;
	}
	
	@Test
	public void test() {
		String input = "aaaaaaabbbbb";
		Assert.assertEquals(0, minOperations(input.toCharArray()));
		
		input = "bbba";
		Assert.assertEquals(1, minOperations(input.toCharArray()));
		
		input = "aabbbaaabbbbb";
		Assert.assertEquals(3, minOperations(input.toCharArray()));
		
		input = "aabbaaabbbbbaa";
		Assert.assertEquals(4, minOperations(input.toCharArray()));
	}
}
