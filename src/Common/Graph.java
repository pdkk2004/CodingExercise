package Common;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph<T> {

	private Map<T, GraphNode<T>> verticesMap;
	
	public Graph() {
		this.verticesMap = new HashMap<T, GraphNode<T>>();
	}
	
	public Set<GraphNode<T>> getVertices() {
		return new HashSet<>(this.verticesMap.values());
	}
	
	public void addEdge(T to, T from) {
		verticesMap.putIfAbsent(to, new GraphNode<>(to));
		verticesMap.putIfAbsent(from, new GraphNode<>(from));
		verticesMap.get(from).addChild(verticesMap.get(to));
	}
	
	public void addVertex(T t) {
		if (verticesMap.containsKey(t)) {
			throw new IllegalArgumentException("Value to be add already exist in graph.");
		}
		verticesMap.put(t, new GraphNode<>(t));
	}
	
	public int numOfVertices() {
		return verticesMap.size();
	}
	
	public boolean contains(T t) {
		return verticesMap.containsKey(t);
	}
}
