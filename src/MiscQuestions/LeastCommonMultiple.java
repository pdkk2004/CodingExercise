package MiscQuestions;

public class LeastCommonMultiple {
	
	public static int LCM(int a, int b) {
		int gcd = GreatCommonDivisor.GCD(a, b);
		return a * b / gcd;
	}
}
