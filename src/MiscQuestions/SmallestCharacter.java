package MiscQuestions;

import org.junit.*;

public class SmallestCharacter {

	public static char findSmallestCharacter(char[] chars, char key) {
		int l = chars.length;
		if (l == 0) {
			throw new IllegalArgumentException("Input char array is empty!");
		}
		int b = 0, e = l - 1;
		while (b <= e) {
			int m = b + (e - b) / 2;
			if (chars[m] > key && (m == 0 || chars[m - 1] <= key)) {
				return chars[m];
			} else if (chars[m] > key) {
				e = m - 1;
			} else {
				b = m + 1;
			}
		}
		return chars[0];
	}
	
	public static void main(String[] args) {
		char[] chars = {'c', 'f', 'j', 'p', 'v'};
		Assert.assertEquals('c', findSmallestCharacter(chars, 'x'));
		Assert.assertEquals('c', findSmallestCharacter(chars, 'a'));
		Assert.assertEquals('f', findSmallestCharacter(chars, 'd'));
	}
}
