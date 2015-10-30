package MiscQuestions;

import java.util.Set;

import Common.UnionFindSet;

/**
 * http://www.fgdsb.com/2015/02/16/valid-tree/
 * @author kkdpan
 *
 */
		
public class ValidTree {
	
	private static class Pair {
		private int v1;
		private int v2;
		
		public Pair(int v1, int v2) {
			this.v1 = v1;
			this.v2 = v2;
		}
	}
	
	/**
	 * Use Disjoint set solution.
	 * @param n
	 * @param edges
	 * @return
	 */
	public static boolean isValidTree(int n, Set<Pair> edges) {
		if (n == 0 || edges.isEmpty()) {
			return false;
		}
		
		UnionFindSet<Integer> djSet = new UnionFindSet<Integer>();
		for (int i = 0; i < n; i++) {
			djSet.makeSet(i);
		}
		
		for (Pair p : edges) {
			if (djSet.findSet(p.v1) != djSet.findSet(p.v2)) {
				djSet.union(p.v1, p.v2);
			} else {
				return false;
			}
		}
		return djSet.getSetNum() == 1;
	}
	
	/**
	 * Use DFS solution.
	 * @param n
	 * @param edges
	 * @return
	 */
//	public static boolean isValidTreeDFS(int n, Set<Pair> edges) {
//		if (n == 0 || edges.isEmpty()) {
//			return false;
//		}
//		
//		//Build graph
//		Map<Integer, List<Integer>> map = new HashMap<>();
//		for (Pair p : edges) {
//			List<Integer> nbs = map.get(p.v1);
//			if (nbs == null) {
//				nbs = new LinkedList<Integer>();
//			}
//			nbs.add(p.v2);
//			List<Integer> rNbs = map.get(p.v2);
//			if (rNbs == null) {
//				rNbs = new LinkedList<Integer>();
//			}
//			rNbs.add(p.v1);
//		}
//		
//		Set<Integer> visited = new HashSet<Integer>();
//		
//		if (!dfs(n, 0, map, visited)) {
//			return false;
//		}
//		return visited.size() == n;
//	}
//	
//	private static boolean dfs(int n, int start, Map<Integer, List<Integer>> map, Set<Integer> visited) {
//		if (start >= n) {
//			return true;
//		}
//		
//		for (int i = start; i < n; i++) {
//			
//		}
//	}
}
