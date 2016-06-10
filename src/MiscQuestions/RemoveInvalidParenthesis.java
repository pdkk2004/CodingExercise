package MiscQuestions;

import org.junit.Test;

public class RemoveInvalidParenthesis {

	@Test
	public void test() {
		String test = "()())(()";
		System.out.println(test);
		System.out.println(removeInvalidParenthesis(test));
		
		test = "()))(()";
		System.out.println(test);
		System.out.println(removeInvalidParenthesis(test));
		
		test = "((()())()";
		System.out.println(test);
		System.out.println(removeInvalidParenthesis(test));
	}
	
	public static String removeInvalidParenthesis(String input) {
		StringBuilder sb = new StringBuilder();
		int leftCnt = 0;
		int rightCnt = 0;
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == ')') {
				rightCnt++;
			}
		}
		
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (c == '(' && rightCnt > 0) {
				sb.append(c);
				leftCnt++;
				rightCnt--;
			} else if (c == '(' && rightCnt <= 0) {
				continue;
			} else if (c == ')' && leftCnt > 0) {
				sb.append(c);
				leftCnt--;
			} else {
				rightCnt--;
			}
		}
		
		return sb.toString();
	}
}
