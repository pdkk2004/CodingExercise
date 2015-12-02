package MiscQuestions;

import java.util.LinkedList;
import java.util.List;

/**
 * http://www.fgdsb.com/2015/01/03/finding-intersection-of-two-sorted-arrays/
 * @author dipa
 *
 */
public class IntersectionOfTwoSortedArray {
	
	public static List<Integer> intersection(int[] A, int[] B) {
		int lenA = A.length;
		int lenB = B.length;
		int ia = 0, ib = 0;
		LinkedList<Integer> ret = new LinkedList<>();
		while (ia < lenA && ib < lenB) {
			if (A[ia] == B[ib]) {
				ret.add(A[ia]);
				ia++;
				ib++;
			} else if (A[ia] < B[ib]) {
				ia++;
			} else {
				ib++;
			}
		}
		return ret;
	}
}
