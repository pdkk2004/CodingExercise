package MiscQuestions;

import java.util.LinkedList;
import java.util.List;

public class PrimeNumberProduct {
	
	private static final int[] PRIMES = {2, 3, 5, 7, 11, 13, 17, 19};
	
	public static void main(String[] args) {
		List<Integer> ret = generateAllProducts(PRIMES);
		System.out.println(ret.toString());
	}
	
	public static List<Integer> generateAllProducts(int[] primes) {
		List<Integer> ret = new LinkedList<Integer>();
		helper(PRIMES, ret, 0, 1);
		return ret;
	}
	
	private static void helper(int[] primes, List<Integer> result, int index, int product) {
		for (int i = index; i < primes.length; i++) {
			int p = product * primes[i];
			result.add(p);
			helper(primes, result, i + 1, p);
		}
	}
}
