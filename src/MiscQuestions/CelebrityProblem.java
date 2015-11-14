package MiscQuestions;

/**
 * http://www.fgdsb.com/2015/01/03/the-celebrity-problem/
 * @author dipa
 *
 */
public class CelebrityProblem {

	public static int findCelebrity(int[] people) {
		int l = people.length;
		if (l < 2) {
			return -1;
		}
		
		int c = 0, n = 1;
		while (n < l) {
			if (doesAKnowB(people[c], people[n])) {
				c = n;
			}
			n++;
		}
		
		for (int i = 0; i < l; i++) {
			if (i != c) {
				if (!doesAKnowB(people[i], people[c]) || doesAKnowB(people[c], people[i])) {
					return -1;
				}
			}
		}
		return people[c];
	}
	
	private static boolean doesAKnowB(int a, int b) {
		return true;
	}
}
