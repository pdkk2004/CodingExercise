package test.miscQuestions;

import java.util.Arrays;

import org.junit.Test;

import MiscQuestions.MedianInStream;
import org.junit.*;

public class MedianInStreamTest {
	
	@Test
	public void test() {
		MedianInStream mis = new MedianInStream();
		
		int[] testArray = {1, 2, 3, 4, 5, 6};
		int[] testArray1 = {0, 1, 2, 3, 4, 5, 6, 7};
		
		for (int i : testArray) {
			System.out.println("adding " + i);
			mis.add(i);
			System.out.println("Median is " + mis.getMedian());
		}
		
		MedianInStream mis2 = new MedianInStream();
		for (int i : testArray1) {
			System.out.println("adding " + i);
			mis2.add(i);
			System.out.println("Median is " + mis2.getMedian());
		}
	}
	
	@Test
	public void randomTest() {
		MedianInStream mis = new MedianInStream();
		
		int length = 500;
		int[] array = new int[length];
		for (int i = 0; i < length; i++) {
			array[i] = (int)(Math.random() * 500);
		}
		
		for (int num : array) {
			mis.add(num);
		}
		
		Arrays.sort(array);
		Assert.assertEquals((array[length / 2 - 1] + array[length / 2]) / 2.0, mis.getMedian(), 0.0001);
	}
}
