package MiscQuestions;

import java.util.Arrays;

import org.junit.Test;

public class BowlingScore {
	
	public int[] score(int[] hits) {
		int[] scores = new int[10];
		int cur = 0;
		for (int i = 0; i < 10; i++) {
			if (hits[cur] == 10) {
				scores[i] = 10 + hits[++cur] + hits[cur + 1];
			} else {
				scores[i] = hits[cur] + hits[++cur];
				if (scores[i] == 10) {
					scores[i] += hits[cur + 1];
				}
				cur++;
			}
		}
		return scores;
	}
	
	@Test
	public void test() {
		int[] hits = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
		int[] scores = score(hits);
		System.out.println(Arrays.toString(scores));
	}
}
 
