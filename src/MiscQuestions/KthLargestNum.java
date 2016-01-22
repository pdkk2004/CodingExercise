package MiscQuestions;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestNum {
	
	public static int secondLargestNum(int[] array) {
		int l = array.length;
		if (l <= 1) {
			throw new IllegalArgumentException("Input array contains less than 2 element.");
		}
		
		int max = Math.max(array[0], array[1]);
		int ret = Math.min(array[0], array[1]);
		for (int i = 2; i < l; i++) {
			if (array[i] > max) {
				ret = max;
				max = array[i];
			} else if (array[i] > ret) {
				ret = array[i];
			}
		}
		
		return ret;
	}
	
	public static int kthLargestNum(int[] array, int k) {
		return kthNumHeap(array, k, (x1, x2) -> x2 - x1);
	}
	
	/**
	 * Using heap solution. O(MlogN)
	 * @param array
	 * @return
	 */
	private static int kthNumHeap(int[] array, int k, Comparator<Integer> cmp) {
		if (k > array.length) {
			throw new IllegalArgumentException("");
		}
		
		PriorityQueue<Integer> heap = new PriorityQueue<>(cmp);
		for (int i = 0; i < array.length; i++) {
			if (i < k) {
				heap.offer(array[i]);
			} else {
				if (array[i] > heap.peek()) {
					heap.poll();
					heap.offer(array[i]);
				}
			}
		}
		return heap.peek();
	}
	
	/**
	 * Using quick selection method. O(N)
	 * @param array
	 * @param k
	 * @param cmp
	 * @return
	 */
	private static int kthNumQuickSelect(int[] array, int k, Comparator<Integer> cmp) {
		if (k > array.length) {
			throw new IllegalArgumentException("");
		}
		
		int b = 0, e = array.length - 1;
		while (b < e) {
			int p = quickSelect(array, b, e, cmp);
			if (p == k - 1) {
				break;
			} else if (p >= k) {
				e = p - 1;
			} else {
				b = p + 1;
			}
		}
		return array[k - 1];
	}
	
	private static int quickSelect(int[] array, int b, int e, Comparator<Integer> cmp) {
		int rand = (int)(Math.random() * (e - b + 1)) + b;
		int p = array[rand];
		array[rand] = array[b];
		array[b] = p;
		int i = b, j = i + 1;
		while (j <= e) {
			if (cmp.compare(array[j], p) <= 0) {
				int temp = array[++i];
				array[i] = array[j];
				array[j] = temp;
			}
			j++;
		}
		int temp = array[i];
		array[i] = array[b];
		array[b] = temp;
		return i;
	}
}
