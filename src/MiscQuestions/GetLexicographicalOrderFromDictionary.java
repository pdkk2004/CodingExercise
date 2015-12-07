package MiscQuestions;

import java.util.Iterator;
import java.util.Set;

import Common.Graph;

/**
 * http://www.fgdsb.com/2015/01/03/get-lexicographical-order-from-dictionary/
 * @author dipa
 *
 */
public class GetLexicographicalOrderFromDictionary {
	
	public static Graph<Character> getLexicographicalOrder(Set<String> dict) {
		Graph<Character> graph = new Graph<>();
		Iterator<String> iter = dict.iterator();
		String pre = null;
		while (iter.hasNext()) {
			String s = iter.next();
			if (pre == null) {
				pre = s;
			} else {
				char[] order = compare(pre, s);
				if (order != null) {
					graph.addEdge(order[0], order[1]);
				}
			}
		}
		return graph;
	}
	
	private static char[] compare(String s1, String s2) {
		if (s1.equals(s2)) {
			return null;
		}
		char[] ret = new char[2];
		for (int i = 0, j = 0; i < s1.length() && j < s2.length(); i++) {
			if (s1.charAt(i) != s2.charAt(j)) {
				ret[0] = s1.charAt(i);
				ret[1] = s2.charAt(j);
			}
		}
		return ret;
	}
}
