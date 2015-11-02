package MiscQuestions;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

/**
 * http://www.fgdsb.com/2015/01/17/factors-of-product-of-distinct-primes/
 * @author kkdpan
 *
 */
public class AllFactorsProducts {

	public static List<Integer> allFactorsProducts(int[] primes) {
		List<Integer> ret = new LinkedList<>();
		ret.add(1);
//		helper(primes, 0, 1, ret);
		dfs(primes, 0, 1, ret);
		return ret;
	}
	
	//Backtracking solution
	private static void helper(int[] primes, int index, int product, List<Integer> ret) {
		if (index == primes.length) {
			return;
		}
		
		for (int i = index; i < primes.length; i++) {
			product *= primes[i];
			ret.add(product);
			helper(primes, i + 1, product, ret);
			product /= primes[i];
		}
	}
	
	//DFS solution
	private static void dfs(int[] primes, int index, int product, List<Integer> ret) {
		if (index == primes.length) {
			return;
		}
		
		int newProduct = product * primes[index];
		ret.add(newProduct);
		dfs(primes, index + 1, newProduct, ret);
		dfs(primes, index + 1, product, ret);
	}
	
	@Test
	public void test() {
		int[] primes = {2, 3, 7};
		List<Integer> ret = allFactorsProducts(primes);
		System.out.println(ret.toString());
	}
}
