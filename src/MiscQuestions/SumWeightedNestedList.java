package MiscQuestions;

import java.util.List;

/**
 * Add sum Weighted Nested List
 * http://www.fgdsb.com/2015/01/03/sum-weighted-nested-list/
 * @author kkdpan
 *
 */
public class SumWeightedNestedList {

	private static interface Node {
		public boolean hasChildren();
		public int height();
		public List<Node> getChildren();
		public int getValue();
	}
	
	private static class ListNode implements Node {
		
		private List<Node> children;
		private int value;
		
		public ListNode() {
			this.value = 0;
			this.children = null;
		}
		
		@Override
		public boolean hasChildren() {
			return children != null && !children.isEmpty();
		}

		@Override
		public int height() {
			if (!hasChildren()) {
				return 1;
			}
			int d = 0;
			for (Node n : children) {
				d = Math.max(d, n.height());
			}
			return d + 1;
		}
		
		@Override
		public List<Node> getChildren() {
			return this.children;
		}
		
		@Override
		public int getValue() {
			return value;
		}
	}
	
	public static int nestedSum(List<Node> nodes) {
		int depth = 0;
		for (Node n : nodes) {
			depth = Math.max(depth, n.height());
		}
		
		return nestedSumHelper(nodes, 1, depth);
	}
	
	private static int nestedSumHelper(List<Node> nodes, int d, int maxDepth) {
		int sum = 0;
		for (Node n : nodes) {
			if (n.hasChildren()) {
				sum += nestedSumHelper(n.getChildren(), d + 1, maxDepth);
			} else {
				sum += n.getValue() * (maxDepth - d + 1);
			}
		}
		return sum;
	}
	
}
