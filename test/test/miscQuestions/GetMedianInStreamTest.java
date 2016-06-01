package test.miscQuestions;

import MiscQuestions.GetMedianInStream;

import java.util.Arrays;

import org.junit.*;

public class GetMedianInStreamTest {
	
	@Test
	public void testOdd() {
		GetMedianInStream median = new GetMedianInStream();
		median.add(1);
		median.add(1);
		median.add(2);
		median.add(2);
		median.add(3);
		Assert.assertTrue(median.getMedian() == 2);
	}
	
	@Test
	public void testEven() {
		GetMedianInStream median = new GetMedianInStream();
		median.add(1);
		median.add(2);
		median.add(3);
		median.add(4);
		median.add(4);
		median.add(4);
		Assert.assertEquals(3.5, median.getMedian(), 0.001);
	}
	
	@Test
	public void test() {
		int lengh = 3000;
		int[] input = new int[lengh];
		for (int i = 0; i < input.length; i++) {
			input[i] = (int)(Math.random() * 10000);
		}
		
		GetMedianInStream median = new GetMedianInStream();
		for (int v : input) {
			median.add(v);
		}
		
		Arrays.sort(input);
		double expectedMedian = lengh % 2 == 0 ? (double)((input[lengh / 2] + input[lengh / 2 - 1]) / 2.0) : input[lengh / 2 + 1];
		Assert.assertEquals(expectedMedian, median.getMedian(), 0.0001);
	}
}
