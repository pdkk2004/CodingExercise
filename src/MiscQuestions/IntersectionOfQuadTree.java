package MiscQuestions;

import Common.QuadTree;

/**
 * http://www.fgdsb.com/2015/01/25/intersection-of-two-quadtrees/
 * @author kkdpan
 *
 */
public class IntersectionOfQuadTree {
	
	public static QuadTree matrix2QuadTree(int[][] matrix, int n) {
		if (n <= 0 || (n & (n - 1)) != 0) {
			throw new IllegalArgumentException("The dimension of input matrix must be power of 2.");
		}
		if (matrix.length != n || matrix[0].length != n) {
			throw new IllegalArgumentException("The matrix size does not match the input dimension.");
		}
		
		return helper(matrix, 0, 0, n);
	}
	
	private static QuadTree helper(int[][] matrix, int r, int c, int n) {
		if (n == 1) {
			return new QuadTree(matrix[r][c]);
		}
		
		QuadTree node = new QuadTree();
		n = n / 2;
		int count = 0;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				node.children.add(helper(matrix, r + i * n, c + j * n, n));
				count += node.children.get(i * 2 + j).num;
			}
		}
		node.num = count;
		return node;
	}
	
	public static int findIntersection(QuadTree t1, QuadTree t2) {
		if (t1 == null || t2 == null || t1.num == 0 || t2.num == 0) {
			return 0;
		}
		
		if (t1.children.size() == 0 && t2.children.size() == 0) {
			return Math.min(t1.num, t2.num);
		}
		int count = 0;
		for (int i = 0; i < 4; i++) {
			count += findIntersection(t1.children.get(i), t2.children.get(i));
		}
		return count;
	}
}
