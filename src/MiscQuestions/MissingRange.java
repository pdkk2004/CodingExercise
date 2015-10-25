package MiscQuestions;

import java.util.LinkedList;
import java.util.List;

public class MissingRange {
	
	public static void main(String[] args) {
		int[] array = {1, 2, 5, 8, 9, 11, 16};
		System.out.println(findMissingRange(array));
	}
	
	public static List<String> findMissingRange(int[] array) {
		List<String> ret = new LinkedList<String>();
		int i = 0;
		while (i < array.length) {
			if (i == 0 || array[i] - array[i - 1] == 1) {
				i++;
				continue;
			}
			int start = array[i - 1] + 1;
			int end = array[i] - 1;
			StringBuilder sb = new StringBuilder();
			sb.append(start);
			if (start != end) {
				sb.append("-" + end);
			}
			ret.add(sb.toString());
			i++;
		}
		return ret;
	}
}
