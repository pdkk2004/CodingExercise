package MiscQuestions;

import Common.Heap;
import org.junit.*;

/*
 * http://www.geeksforgeeks.org/kth-smallest-element-in-a-row-wise-and-column-wise-sorted-2d-array-set-1/
 */
public class FindKthElementIn2DMatrix {

	public int findKthElement(int[][] grid, int k) {
		int r = grid.length;
		if (r == 0) {
			throw new IllegalArgumentException();
		}
		int c = grid[0].length;

		if (r * c < k) {
			throw new IllegalArgumentException();
		}

		Heap<HeapNode> heap = new Heap<>();
		for (int i = 0; i < c; i++) {
			heap.add(new HeapNode(grid[0][i], 0, i));
		}

		for (int i = 1; i < k; i++) {
			HeapNode n = heap.poll();
			if (n.x < r - 1) {
				heap.add(new HeapNode(grid[n.x + 1][n.y], n.x + 1, n.y));
			}
		}
		return heap.peek().value;
	}

	private static class HeapNode implements Comparable<HeapNode> {
		private int value;
		private int x;
		private int y;

		public HeapNode(int v, int x, int y) {
			this.value = v;
			this.x = x;
			this.y = y;
		}

		public int compareTo(HeapNode node) {
			return node.value - this.value;
		}
	}

	@Test
	public void test() {
		int mat[][] = { { 10, 20, 30, 40 }, { 15, 25, 35, 45 }, { 25, 29, 37, 48 }, { 32, 33, 39, 50 }, };
		Assert.assertEquals(10, findKthElement(mat, 1));
		Assert.assertEquals(25, findKthElement(mat, 4));
		Assert.assertEquals(25, findKthElement(mat, 5));
		Assert.assertEquals(30, findKthElement(mat, 7));
		Assert.assertEquals(50, findKthElement(mat, 16));
	}
}
