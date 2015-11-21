package MiscQuestions;

import java.util.Arrays;
import java.util.Comparator;

public class MinSumMahattanDistance {
	
	private static class Point {
		private int x;
		private int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static int minDist(Point[] points) {
		int l = points.length;
		Arrays.sort(points, (p1, p2) -> p1.x - p2.x);
		Point px = find(points, l / 2, (p1, p2) -> p1.x - p2.x);
		Arrays.sort(points, (p1, p2) -> p1.y - p2.y);
		Point py = find(points, 1 / 2, (p1, p2) -> p1.y - p2.y);
		int dist = 0;
		for (Point p : points) {
			dist += Math.abs(px.x - p.x) + Math.abs(py.y - p.y);
		}
		return dist;
	}
	
	private static Point find(Point[] points, int rank, Comparator<Point> cmp) {
		return findHelper(points, rank, 0, points.length - 1, cmp);
	}
	
	private static Point findHelper(Point[] points, int rank, int b, int e, Comparator<Point> cmp) {
		if (b < e) {
			int randomSeed = (int)(Math.random() * (b - e) + b);
			int pos = partition(points, randomSeed, b, e, cmp);
			if (pos == rank) {
				return points[pos];
			} else if (pos > rank) {
				return findHelper(points, rank, b, pos - 1, cmp);
			} else {
				return findHelper(points, rank, pos + 1, e, cmp);
			}
		} else if (b == e){
			return points[b];
		} else {
			throw new RuntimeException();
		}
	}
	
	private static int partition(Point[] points, int pvt, int b, int e, Comparator<Point> cmp) {
		swap(points, b, pvt);
		Point p = points[b];
		int i = b;
		int j = i + 1;
		while (j <= e) {
			if (cmp.compare(points[j], p) <= 0) {
				swap(points, ++i, j);
			} 
			j++;
		}
		swap(points, b, i);
		return i;
	}
	
	private static void swap(Point[] points, int b, int e) {
		Point temp = points[b];
		points[b] = points[e];
		points[e] = temp;
	}
	
	public void test() {
		
	}
}
