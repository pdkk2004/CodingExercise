package MiscQuestions;

import java.util.LinkedList;
import java.util.List;

// In the tree, the parent node has value that is smaller than its children.
// The tree is n-ary tree.
public class FindSecondMinNumberInTree {
	
	private static class Node {
		private int val;
		
		private List<Node> children;
		
		public Node(int v) {
			this.val = v;
			children = new LinkedList<>();
		}
	}
	
	public static void main(String[] args) {
		Node root = new Node(2);
		root.children.add(new Node(2));
		root.children.add(new Node(3));
		
		root.children.get(0).children.add(new Node(4));
		root.children.get(0).children.add(new Node(2));
		
		root.children.get(1).children.add(new Node(5));
		root.children.get(1).children.add(new Node(3));
		
		System.out.println(findSecondMin(root));
	}
	
	public static int findSecondMin(Node root) {
		int secondMin = root.val;
		
		for (Node n : root.children) {
			if (n.val < secondMin) {
				secondMin = n.val;
			} else if (n.val == secondMin){
				int secondMinCand = findSecondMin(n);
				if (secondMinCand < secondMin) {
					secondMin = secondMinCand;
				}
			}
		}
		return secondMin;
	}
	
}
