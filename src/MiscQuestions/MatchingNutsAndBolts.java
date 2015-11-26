package MiscQuestions;

import java.util.Arrays;

import org.junit.Test;

/**
 * 
 * @author dipa
 *
 */
public class MatchingNutsAndBolts {
	
	// use order statistics solution Choosing nut size as pivot and use divide conquer approach to find bolt that matches the pivot nut. 
	public static void matchNutsAndBolts(int[] nuts, int[] bolts) {
		if (nuts.length != bolts.length) {
			return;
		}
		
		match(nuts, bolts, 0, bolts.length - 1);
	}
	
	private static void match(int[] nuts, int[] bolts, int b, int e) {
		if (b < e) {
			int random = b + (int)(Math.random() * (e - b));
			int pivot = partition(nuts[random], bolts, b, e);
			partition(bolts[pivot], nuts, b, e);
			match(nuts, bolts, b, pivot - 1);
			match(nuts, bolts, pivot + 1, e);
		}
	}
	
	private static int partition(int target, int[] array, int b, int e) {
		int i = b, j = i;
		while (j < e ) {
			if (array[j] < target) {
				swap(array, i, j);
				i++;
			} else if (target == array[j]) {
				swap(array, e, j);
				j--;
			}
			j++;
		}
		swap(array, e, i);
		return i;
	}
	
	private static void swap(int[] A, int ai, int bi) {
		int temp = A[ai];
		A[ai] = A[bi];
		A[bi] = temp;
	}
	
	@Test
	public void test() {
		int[] nuts = {3, 5, 1, 2, 4};
		int[] bolts = {1, 4, 2, 3, 5};
		matchNutsAndBolts(nuts, bolts);
		System.out.println(Arrays.toString(nuts));
		System.out.println(Arrays.toString(bolts));
	}
}
