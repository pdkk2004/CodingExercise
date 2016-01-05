package MiscQuestions;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class SumAllSubtrees {
	
	private static class TreeNode {
		private int v;
		private int id;
		private int pid;
		
		private TreeNode(int id, int pid, int v) {
			this.id = id;
			this.v = v;
			this.pid = pid;
		}
	}

	public static Map<Integer, Integer> sumAllSubtrees(Collection<TreeNode> nodes) {
		Map<Integer, Integer> ret = new HashMap<>();
		Map<Integer, TreeNode> id2Node = new HashMap<>();
		Map<Integer, List<Integer>> tree = new HashMap<>();
		
		Integer rootId = null;
		for (TreeNode node : nodes) {
			id2Node.put(node.id, node);
			if (node.pid >= 0) {
				tree.putIfAbsent(node.pid, new LinkedList<Integer>());  // The tree does not contains leaf node!!!
				tree.get(node.pid).add(node.id);
			} else {
				rootId = node.id;
			}
		}
		
		calculateAllSubtreeSum(tree, id2Node, ret, rootId);
		return ret;
	}
	
	private static int calculateAllSubtreeSum(Map<Integer, List<Integer>> tree, Map<Integer, TreeNode> id2Node, Map<Integer, Integer> ret, int rootId) {		
		int sum = id2Node.get(rootId).v;
		for (Integer childId : tree.getOrDefault(rootId, Collections.emptyList())) {  //NOTE: if tree does not contain a nodeId, then this node is leaf so return an empty list. 
			sum += calculateAllSubtreeSum(tree, id2Node, ret, childId);
		}
		ret.put(rootId, sum);
		return sum;
	}
	
	@Test
	public void test() {
		Collection<TreeNode> nodes = new LinkedList<TreeNode>();
		nodes.add(new TreeNode(0, -1, 1));
		nodes.add(new TreeNode(1, 0, 2));
		nodes.add(new TreeNode(2, 0, 3));
		nodes.add(new TreeNode(3, 1, 4));
		nodes.add(new TreeNode(4, 1, 5));
		
		Map<Integer, Integer> ret = sumAllSubtrees(nodes);
		System.out.println(ret.toString());
	}
}
