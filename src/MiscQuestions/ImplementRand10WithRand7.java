package MiscQuestions;

/**
 * http://www.fgdsb.com/2015/01/03/implement-rand10-with-rand7/
 * @author dipa
 *
 */
public class ImplementRand10WithRand7 {
	
	public static int rand10() {
		int r = 0;
		while (r > 40) {
			r = 7 * (rand7() - 1) + rand7();
		}
		return r % 10 + 1;
	}
	
	public static int rand7() {
		return (int)Math.random() * 7 + 1;
	}
}
