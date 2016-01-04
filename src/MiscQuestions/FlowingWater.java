package MiscQuestions;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Test;

import Common.Pair;

/**
 * http://www.fgdsb.com/2015/02/09/elevation-matrix/
 * @author dipa
 *
 */
public class FlowingWater {

	private static int[][] offset = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	
	public static List<Pair<Integer, Integer>> flowWater(int[][] array) {
		int r = array.length;
		int c = array[0].length;
		
		Set<Pair<Integer, Integer>> pacific = new HashSet<>();
		for (int i = 0; i < r; i++) {
			BFS(array, r, c, new Pair<Integer, Integer>(i, 0), pacific);
		}
		
		for (int j = 1; j < c; j++) {
			BFS(array, r, c, new Pair<Integer, Integer>(0, j), pacific);
		}
		
		Set<Pair<Integer, Integer>> atlantic = new HashSet<>();
		for (int i = 0; i < r; i++) {
			BFS(array, r, c, new Pair<Integer, Integer>(i, c - 1), atlantic);
		}
		
		for (int j = 0; j < r - 1; j++) {
			BFS(array, r, c, new Pair<Integer, Integer>(r - 1, j), atlantic);
		}
		
		return pacific.stream().filter(x -> atlantic.contains(x)).collect(Collectors.toList());
	}
	
	public static void BFS(int[][] array, int m, int n, Pair<Integer, Integer> start, Set<Pair<Integer, Integer>> visited) {
		Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
		if (!visited.contains(start)) {
			queue.offer(start);
			visited.add(start);
		}
		
		while (!queue.isEmpty()) {
			Pair<Integer, Integer> p = queue.poll();
			for (int[] delt : offset) {
				int x = p.k + delt[0];
				int y = p.v + delt[1];
				if (x >= 0 && x < m && y >= 0 && y < n) {
					Pair<Integer, Integer> neigh = new Pair<>(x, y);
					if (!visited.contains(neigh) && array[x][y] >= array[p.k][p.v]) {
						visited.add(neigh);
						queue.offer(neigh);
					}
				}
			}
		}
	}
	
	@Test
	public void test() {
		int[][] array = {{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}};
		List<Pair<Integer, Integer>> ret = flowWater(array);
		System.out.println(ret.toString());
	}
}
