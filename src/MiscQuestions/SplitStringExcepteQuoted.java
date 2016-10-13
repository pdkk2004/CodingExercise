package MiscQuestions;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class SplitStringExcepteQuoted {
	
	public List<String> splitString(String str) {
		int l = str.length();
		List<String> ret = new LinkedList<>();
		
		int i = 0;
		boolean metQuote = false;
		while (i < l) {
			while (i < l && str.charAt(i) == ' ') {
				i++;
			}
			if (i < l && str.charAt(i) == '"') {
				i++;
				metQuote = true;
			}
			int j = i + 1;
			while (j < l && (metQuote && str.charAt(j) != '"' || (!metQuote && str.charAt(j) != ' '))) {
				j++;
			}
			ret.add(str.substring(i, j));
			if (j < l && str.charAt(j) == '"') {
				metQuote = false;
			}
			i = j + 1;
		}
		return ret;
	}
	
	@Test
	public void test() {
		System.out.println(splitString("i would like to go to seattle today").toString());
		System.out.println(splitString("i would \"like to go to\" seattle today").toString());
		System.out.println(splitString("\"i would \"\"like to go to\" seattle today").toString());
	}
}
