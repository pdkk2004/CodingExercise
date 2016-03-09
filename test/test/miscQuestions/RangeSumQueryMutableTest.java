package test.miscQuestions;

import org.junit.Assert;
import org.junit.Test;

import Leetcode.RangeSumQueryMutableBITTree;
import Leetcode.RangeSumQueryMutable;

public class RangeSumQueryMutableTest {

	@Test
	public void testSegmentTreeSolution() {
		int[] array = {1, 3, 5};
		RangeSumQueryMutable numArray = new RangeSumQueryMutable(array);
		Assert.assertEquals(9, numArray.sumRange(0, 2));
		numArray.update(1, 2);
		Assert.assertEquals(8, numArray.sumRange(0, 2));
	}
	
	@Test
	public void testBITSolution() {
		int[] array = {1, 3, 5};
		RangeSumQueryMutableBITTree numArray = new RangeSumQueryMutableBITTree(array);
		Assert.assertEquals(9, numArray.sumRange(0, 2));
		numArray.update(1, 2);
		Assert.assertEquals(8, numArray.sumRange(0, 2));
	}
}
