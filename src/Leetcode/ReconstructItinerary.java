package Leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

import org.junit.Test;

public class ReconstructItinerary {

	// More general solution, which use TreeMap as ordered map, but slower.
	public List<String> findItinerary1(String[][] tickets) {
		Map<String, Map<String, Integer>> map = new HashMap<>();
		for (int i = 0; i < tickets.length; i++) {
			String[] pair = tickets[i];
			Map<String, Integer> dests = map.getOrDefault(pair[0], new TreeMap<String, Integer>());
			dests.put(pair[1], dests.getOrDefault(pair[1], 0) + 1);
			map.putIfAbsent(pair[0], dests);
		}

		LinkedList<String> ret = new LinkedList<String>();
		if (dfs1(map, "JFK", ret, tickets.length)) {
			ret.addFirst("JFK");
		}
		return ret;
	}

	private boolean dfs1(Map<String, Map<String, Integer>> map, String start, LinkedList<String> ret, int l) {
		if (l == 0) {
			return true;
		}

		Map<String, Integer> dests = map.get(start);
		if (dests == null) {
			return false;
		}

		for (Map.Entry<String, Integer> d : dests.entrySet()) {
			if (d.getValue() != 0) {
				ret.add(d.getKey());
				dests.put(d.getKey(), d.getValue() - 1);
				if (dfs1(map, d.getKey(), ret, l - 1)) {
					return true;
				}
				ret.removeLast();
				dests.put(d.getKey(), d.getValue() + 1);
			}
		}
		return false;
	}

	// Use priority Queue to maintain order, faster and cleaner impplementation.
	public List<String> findItinerary(String[][] tickets) {
		Map<String, PriorityQueue<String>> map = new HashMap<>();
		for (int i = 0; i < tickets.length; i++) {
			String[] pair = tickets[i];
			PriorityQueue<String> dest = map.getOrDefault(pair[0], new PriorityQueue<String>());
			dest.offer(pair[1]);
			map.putIfAbsent(pair[0], dest);
		}

		LinkedList<String> ret = new LinkedList<String>();
		dfs(map, "JFK", ret);
		return ret;
	}

	private void dfs(Map<String, PriorityQueue<String>> map, String start, LinkedList<String> ret) {
		PriorityQueue<String> dests = map.get(start);
		while (dests != null && !dests.isEmpty()) {
			dfs(map, dests.poll(), ret);
		}
		ret.addFirst(start);
	}

	@Test
	public void test() {
		ReconstructItinerary sol = new ReconstructItinerary();
		String[][] input = { { "JFK", "KUL" }, { "JFK", "NRT" }, { "NRT", "JFK" } };
		List<String> output = sol.findItinerary(input);
		System.out.println(output.toString());
	}
}
