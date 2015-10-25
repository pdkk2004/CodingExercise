package test.miscQuestions;

import org.junit.Test;

import Common.QuadTree;
import MiscQuestions.IntersectionOfQuadTree;
import org.junit.Assert;

public class QuadTreeTest {
	
	@Test
	public void TestBuildQuadTree() {
		int[][] matrix = {{0, 1, 1, 0}, {1, 0, 0, 1}, {0, 0, 1, 0}, {1, 1, 1, 0}};
		QuadTree quadTree = IntersectionOfQuadTree.matrix2QuadTree(matrix, matrix.length);
		Assert.assertEquals(8, quadTree.num);
		Assert.assertNotNull(quadTree.children.get(0).children.get(0));
		Assert.assertEquals(0, quadTree.children.get(0).children.get(0).num);
	}
	
	@Test
	public void TestIntersectionQuadTree() {
		int[][] matrix = {{0, 1, 1, 0}, {1, 0, 0, 1}, {0, 0, 1, 0}, {1, 1, 1, 0}};
		QuadTree t1 = IntersectionOfQuadTree.matrix2QuadTree(matrix, matrix.length);

		int[][] matrix1 = {{0, 1, 1, 0}, {0, 1, 1, 0}, {0, 0, 1, 0}, {1, 1, 1, 0}};
		QuadTree t2 = IntersectionOfQuadTree.matrix2QuadTree(matrix1, matrix1.length);
		
		Assert.assertEquals(6, IntersectionOfQuadTree.findIntersection(t1, t2));
	}
}	
