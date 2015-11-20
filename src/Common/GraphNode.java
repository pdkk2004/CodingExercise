package Common;

import java.util.HashSet;
import java.util.Set;

public class GraphNode<V> {
	
	private V value;
	
	private Set<GraphNode<V>> children;

	public GraphNode(V value) {
		this.value = value;
		this.children = new HashSet<>();
	}
	
	public void addChild(GraphNode<V> node) {
		children.add(node);
	}
	
	public Set<GraphNode<V>> getChildren() {
		return this.children;
	}
	
	public V getValue() {
		return this.value;
	}
}
