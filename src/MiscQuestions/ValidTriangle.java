package MiscQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class ValidTriangle {

	public static List<Integer> validTriangle(ArrayList<Integer> input) {
		Collections.sort(input);
		
		int l = input.size();
		for (int i = 0; i <= l - 2; i++) {
			int k = l - 1;
			int j = i + 1;
			while (j < k) {
				if (input.get(i) + input.get(j) <= input.get(k)) {
					j++;
				} else {
					
				}
			}
		}
		return Collections.emptyList();
	}
	
	@Test
	public void test() {
		ArrayList<Integer> input = new ArrayList<Integer>();
		input.add(2);
		input.add(3);
		input.add(5);
		input.add(8);
		System.out.println(validTriangle(input));
	}
}
