package MiscQuestions;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class FactorCombination {

	public static List<List<Integer>> factorCombination(int num) {
		List<List<Integer>> result = new LinkedList<>();
		factorHelper(num, new Stack<Integer>(), result);
		return result;
	}
	
	private static void factorHelper(int num, Stack<Integer> r, List<List<Integer>> result) {
		
		int last = r.isEmpty() ? 2 : r.peek();
		for (int i = last; i < num; i++) {
			if (num % i == 0) {
				r.push(i);
				factorHelper(num / i, r, result);
				r.pop();
			}
		}
		
		//Note: use this way to avoid adding the initial number into the result set.
		if (!r.isEmpty() && num >= last) {
			r.push(num);
			result.add(new LinkedList<Integer>(r));
			r.pop();
		}
	}
	
	public static void main(String[] args) {
		System.out.println(factorCombination(12));
	}
}
