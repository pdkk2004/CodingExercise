package test.miscQuestions;

import org.junit.Assert;
import org.junit.Test;

import Leetcode.RangeSumQueryMutable;

public class RangeSumQueryMutableTest {

	@Test
	public void test() {
		int[] array = {1, 3, 5};
		RangeSumQueryMutable numArray = new RangeSumQueryMutable(array);
		Assert.assertEquals(9, numArray.sumRange(0, 2));
		numArray.update(1, 2);
		Assert.assertEquals(8, numArray.sumRange(0, 2));
	}
}
