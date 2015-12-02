package MiscQuestions;

/**
 * http://www.fgdsb.com/2015/01/03/hamming-distance/
 * @author dipa
 *
 */
public class HammingDistance {

	public static int hammingDistance(int a, int b) {
		int dist = 0;
		while (a > 0 && b > 0) {
			if (a == 0 || b == 0 || a % 10 != b % 10) {
				dist++;
			}
			a /= 10;
			b /= 10;
		}
		return dist;
	}
}
