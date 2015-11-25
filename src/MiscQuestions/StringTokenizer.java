package MiscQuestions;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class StringTokenizer {

	public static List<String> getTokens(String str) {
		int l = str.length();
		char d = ' ';
		
		List<String> ret = new LinkedList<String>();
		int i = 0;
		while (i < l) {
			char c = str.charAt(i);
			if (c == d) {
				i++;
				continue;
			}
			int b = i;
			if (c == '"') {
				b++;
				d = '"';
			}
			while (b < l && str.charAt(b) != d) {
				b++;
			}
			if (b < l && d == '"') {
				ret.add(str.substring(i + 1, b));
			} else {
				ret.add(str.substring(i, b));
			}
			i = b + 1;
			d = ' ';
		}
		return ret;
	}
	
	@Test
	public void test() {
		System.out.println(getTokens("I have a \"faux coat\"").toString());
		System.out.println(getTokens("I have a \" faux coat \"").toString());
		System.out.println(getTokens("I have a faux coat\"").toString());
		System.out.println(getTokens("I have a faux coat").toString());
		System.out.println(getTokens("  I have a faux coat  ").toString());
		System.out.println(getTokens("  I have a faux coat  ").toString());
		System.out.println(getTokens("I have a \"faux coat").toString());
		System.out.println(getTokens("I have a \"\"\"faux coat\"").toString());
	}
}
