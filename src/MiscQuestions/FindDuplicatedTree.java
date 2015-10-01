package MiscQuestions;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.google.common.base.Joiner;

import Common.TreeNode;

public class FindDuplicatedTree {
	
	private static final Joiner joiner = Joiner.on('|').skipNulls();
	
	public List<TreeNode> findDuplicatedTree(TreeNode root) {
		Map<String, List<TreeNode>> map = new HashMap<>();
		serialize(root, map);
		Iterator<List<TreeNode>> iter = map.values().iterator();
		List<TreeNode> ret = new LinkedList<TreeNode>();
		while (iter.hasNext()) {
			List<TreeNode> n = iter.next();
			if (n.size() > 1) {
				ret.addAll(n);
			}
		}
		return ret;
	}
	
	private String serialize(TreeNode root, Map<String, List<TreeNode>> map) {
		if (root == null) {
			return "#";
		}
		String left = serialize(root.left, map);
		String right = serialize(root.right, map);
		String key = joiner.join(left, root.val, right);
		List<TreeNode> nodes = map.get(key);
		if (nodes == null) {
			nodes = new LinkedList<TreeNode>();
			map.put(key, nodes);
		}
		nodes.add(root);
		return key;
	}
}
