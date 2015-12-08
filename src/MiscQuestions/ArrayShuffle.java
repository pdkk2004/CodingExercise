package MiscQuestions;

/**
 * http://www.fgdsb.com/2015/01/03/array-shuffle/
 * @author dipa
 *
 */
public class ArrayShuffle {
	
	public static void shuffle(int[] array) {
		int l = array.length;
		for (int i = 0; i < l; i++) {
			int random = (int)(Math.random() * (l - i)) + i;
			int temp = array[i];
			array[i] = array[random];
			array[random] = temp;
		}
	}
}
