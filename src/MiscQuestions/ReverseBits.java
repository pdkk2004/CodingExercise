package MiscQuestions;

import org.junit.Test;

public class ReverseBits {

	public static int reverseBits(int num) {
		int ret = num;
		for (int i = 0, j = Integer.SIZE - 1; i < j; i++, j--) {
			ret = swapBits(ret, i, j);
		}
		return ret;
	}
	
	private static int swapBits(int num, int i, int j) {
		int bi = (num >>> i) & 1;
		int bj = (num >>> j) & 1;
		if ((bi ^ bj) == 1) {
			num ^= ((1 << i) | (1 << j));
		}
		return num;
	}
	
	@Test
	public void test() {
		int t = 1687;
		System.out.println(Integer.toBinaryString(t));
		System.out.println(Integer.toBinaryString(reverseBits(t)));

	}
}
