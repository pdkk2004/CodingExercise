package MiscQuestions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

import org.junit.Test;

import org.junit.*;

/**
 * http://www.fgdsb.com/2015/01/03/k-closest-points/
 * @author dipa
 *
 */
public class KClosestPoints {
	
	private static class Point {
		private int x;
		private int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public int distance(Point source) {
			return (int)(Math.pow(source.x - this.x, 2)+ Math.pow(source.y - this.y, 2)); 
		}

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof Point) {
				Point p = (Point)obj;
				return (this.x == p.x && this.y == p.y);
			} else {
				return false;
			}
		}

		@Override
		public int hashCode() {
			return this.x * 23 + this.y;
		}
		
		
	}
	
	public static List<Point> closestPoints(List<Point> points, Point origin, int k) {
		PriorityQueue<Point> heap = new PriorityQueue<>((x1, x2) -> x2.distance(origin) - x1.distance(origin));
		
		for (Point p : points) {
			if (heap.size() < k) {
				heap.offer(p);
			} else {
				if (heap.peek().distance(origin) > p.distance(origin)) {
					heap.poll();
					heap.offer(p);
				}
			}
		}
		return new LinkedList<Point>(heap);
	}
	
	@Test
	public void test() {
		Point[] points = {new Point(-2, -4),
				new Point(0, 0),
				new Point(10, 15),
				new Point(5, 6),
				new Point(7, 8),
				new Point(-10, -30)};
		List<Point> ret = closestPoints(Arrays.asList(points), new Point(5, 5), 2);
		Assert.assertTrue(ret.contains(new Point(5, 6)));
		Assert.assertTrue(ret.contains(new Point(7, 8)));
		Assert.assertTrue(ret.size() == 2);
	}
}
