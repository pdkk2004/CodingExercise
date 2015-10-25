package test.miscQuestions;

import org.junit.Test;

import MiscQuestions.FrogJumpRiver;

public class FrogJumpTest {
	
	@Test
	public void testHappyCase() {
		int[] stones = {0, 1, 3, 5, 6, 8, 12, 17};
		System.out.println(FrogJumpRiver.canJumpCross(stones));
	}
	
	@Test
	public void testNegativeCase() {
		int[] stones = {0, 1, 2, 3, 4, 8, 9, 11};
		System.out.println(FrogJumpRiver.canJumpCross(stones));
	}
}
