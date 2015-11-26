package test.miscQuestions;

import org.junit.Assert;
import org.junit.Test;

import MiscQuestions.MovingAverage;

public class MovingAverageTest {

	@Test
	public void test() {
		MovingAverage mavg = new MovingAverage(2);
		double delta = 0.00001;
		Assert.assertEquals(1.0, mavg.getNext(1), delta);
		Assert.assertEquals(1.5, mavg.getNext(2), delta);
		Assert.assertEquals(2.5, mavg.getNext(3), delta);
		Assert.assertEquals(3.5, mavg.getNext(4), delta);
	}
}
