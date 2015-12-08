package MiscQuestions;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import Common.GraphNode;

/**
 * http://www.fgdsb.com/2015/01/03/check-whether-a-graph-is-bipartite-or-not/
 * @author dipa
 *
 */
public class WhetherGraphIsBipartite {
	
	public static <T> boolean isBipartite(GraphNode<T> g) {
		Queue<GraphNode<T>> queue = new LinkedList<GraphNode<T>>();
		Set<GraphNode<T>> U = new HashSet<>();
		Set<GraphNode<T>> V = new HashSet<>();
		queue.offer(g);
		U.add(g);

		boolean isU = true;
		while (!queue.isEmpty()) {
			GraphNode<T> root = queue.poll();
			for (GraphNode<T> n : root.getChildren()) {
				if ((isU && U.contains(n)) ||(!isU && V.contains(n))) {
					return false;
				}
				if (!U.contains(n) && !V.contains(n)) {
					queue.offer(n);
					if (isU) {
						V.add(n);
					} else {
						U.add(n);
					}
				}
			}
			isU = !isU;
		}
		return true;
	}
}
