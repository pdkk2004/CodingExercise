package Common;

import java.util.HashSet;
import java.util.Set;

public class Graph<T> {

	private Set<GraphNode<T>> roots;
	
	public Graph() {
		this.roots = new HashSet<GraphNode<T>>();
	}
	
	public Set<GraphNode<T>> getRoots() {
		return this.roots;
	}
}
