package MiscQuestions;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import org.junit.Test;

public class FindAllSources {
	
	/** Find all sources. BSF approach.
	 * http://www.fgdsb.com/2015/01/16/find-all-sources/
	 * @param array
	 * @param dest
	 * @return
	 */
	public static List<Integer> findAllSouces(int[] array, int dest) {
		Set<Integer> ret = new HashSet<Integer>();
		if (dest < 0 || dest >= array.length) {
			return Collections.emptyList();
		}
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(dest);
		
		while (!queue.isEmpty()) {
			int d = queue.poll();
			for (int i = 0; i < array.length; i++) {
				if (!ret.contains(i) && (i - array[i] == d || i + array[i] == d)) {
					ret.add(i);
					queue.offer(i);
				}
			}
		}
		return new LinkedList<Integer>(ret);
	}
	
	@Test
	public void test() {
		int[] array = {1, 3, 0, 2, 4, 7};
		System.out.println(findAllSouces(array, 0).toString());
	}
}
