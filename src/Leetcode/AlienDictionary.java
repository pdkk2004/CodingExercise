package Leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AlienDictionary {
	public String alienOrder(String[] words) {
        if (words.length == 1) {
            return words[0];
        }
		// Compose graph
		Map<Character, List<Character>> graph = new HashMap<>();
		for (int i = 0; i < words.length - 1; i++) {
			compareWords(words[i], words[i + 1], graph);
		}

		// topological sort
		Map<Character, Integer> status = new HashMap<>();
		StringBuilder ret = new StringBuilder();
		for (Character c : graph.keySet()) {
			if (status.getOrDefault(c, 0) == 0) {
				StringBuilder order = new StringBuilder();
				boolean isValid = topSort(graph, c, status, order);
				if (!isValid) {
					return "";
				} else {
					ret.insert(0, order.toString());
				}
			}
		}

		return ret.toString();
	}

	private boolean topSort(Map<Character, List<Character>> graph, char start, Map<Character, Integer> status,
			StringBuilder order) {
		if (!graph.containsKey(start) || status.getOrDefault(start, 0) == -1) {
			return false;
		} else if (status.getOrDefault(start, 0) == 1) {
			return true;
		}

		List<Character> adj = graph.get(start);
		status.put(start, -1);
		boolean isValid = true;
		for (char c : adj) {
			isValid = isValid && topSort(graph, c, status, order);
			if (!isValid) {
				return false;
			}
		}
		order.insert(0, start);
		status.put(start, 1);
		return isValid;
	}

	private void compareWords(String w1, String w2, Map<Character, List<Character>> graph) {
		if (w1 == null || w2 == null) {
			return;
		}
		int i1 = 0, i2 = 0, l1 = w1.length(), l2 = w2.length();
		while (i1 < l1 && i2 < l2) {
			graph.putIfAbsent(w1.charAt(i1), new LinkedList<>());
			graph.putIfAbsent(w2.charAt(i2), new LinkedList<>());
			if (w1.charAt(i1) != w2.charAt(i2)) {
				graph.get(w1.charAt(i1)).add(w2.charAt(i2));
				i1++;
				i2++;
				break;
			} else {
				i1++;
				i2++;
			}
		}

		while (i1 < l1) {
			graph.putIfAbsent(w1.charAt(i1), new LinkedList<>());
			i1++;
		}
		while (i2 < l2) {
			graph.putIfAbsent(w2.charAt(i2), new LinkedList<>());
			i2++;
		}
	}
}
