package MiscQuestions;

/**
 * Valid String. Similar like painting houses problem.
 * http://www.fgdsb.com/2015/01/14/valid-string/
 * @author kkdpan
 *
 */
public class ValidString {
	
	public static int validString(int n) {
		if (n <= 0) {
			return 0;
		}
		
		int s = 3, d = 0;
		int i = 1;
		while (i < n) {
			int newS = s + d;
			d = s * 2 + d;
			s = newS;
		}
		return s + d;
	}
}
