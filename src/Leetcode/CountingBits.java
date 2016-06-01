package Leetcode;

public class CountingBits {

	public int[] countingBits(int num) {
		int[] bits = new int[num + 1];
		for (int i = 1; i <= num; i++) {
			if (i % 2 == 0) {
				bits[i] = bits[i / 2];
			} else {
				bits[i] = bits[i / 2] + 1;
			}
		}
		return bits;
	}
}
