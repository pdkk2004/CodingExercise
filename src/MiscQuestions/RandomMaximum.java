package MiscQuestions;

/**
 * http://www.fgdsb.com/2015/01/15/random-maximum/
 * Use reservoir sampling to do one pass.
 * https://en.wikipedia.org/wiki/Reservoir_sampling
 * @author kkdpan
 *
 */
public class RandomMaximum {
	
	public static int randomMaxium(int[] array) {
		int l = array.length;
		int max = Integer.MIN_VALUE;
		int count = 0;
		int ret = 0;
		for (int i = 0; i < l; i++) {
			if (array[i] > max) {
				max = array[i];
				count = 1;
				ret = i;
			} else if (array[i] == max) {
				int rand = (int)(Math.random() * (count + 1));
				if (rand == count) {
					ret = i;
				}
			}
		}
		return ret;
	}
}
