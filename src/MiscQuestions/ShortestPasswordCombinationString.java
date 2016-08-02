package MiscQuestions;

import java.util.HashSet;
import java.util.Set;

public class ShortestPasswordCombinationString {
	
	public String shortestPassword(String[] input) {
		
		for (int i = 0; i < input.length; i++) {
			Set<String> visited = new HashSet<>();
			StringBuilder sb = new StringBuilder(input[i]);
			boolean success = dfs(input[i], visited, sb);
			if (success) {
				return sb.toString();
			}
		}
		return "";
	}
	
	private boolean dfs(String start, Set<String> visited, StringBuilder sb) {
		if (visited.size() == 10000) {
			return true;
		}
		visited.add(start);
		String last3 = start.substring(1);
		for (char c = '0'; c <= '9'; c++) {
			String next = last3 + c;
			if (visited.contains(next)) {
				continue;
			}
			sb.append(c);
			if (dfs(next, visited, sb)) {
				return true;
			}
			sb.deleteCharAt(sb.length() - 1);
		}
		visited.remove(start);
		return false;
	}
}
