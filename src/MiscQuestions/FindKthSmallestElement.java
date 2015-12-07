package MiscQuestions;

/**
 * http://www.fgdsb.com/2015/01/03/find-kth-smallest-element/
 * @author dipa
 *
 */
public class FindKthSmallestElement {
	
	public static int findKthSmallestElement(int[] array, int k) {
		if (array.length < k) {
			throw new IllegalArgumentException();
		}
		
		int b = 0, e = array.length - 1;
		while (b <= e) {
			int select = randomSelect(array, b, e);
			if (select == k - 1) {
				break;
			} else if (select < k - 1) {
				b = select + 1;
			} else {
				e = select - 1;
			}
		}
		return array[k];
	}
	
	private static int randomSelect(int[] array, int b, int e) {
		int seed = b + (int)(Math.random() * (e - b + 1));
		int pivot = array[seed];
		swap(array, seed, b);
		int i = b, j = i + 1;
		while (j <= e) {
			if (array[j] <= pivot) {
				swap(array, ++i, j);
			}
			j++;
		}
		swap(array, b, i);
		return i;
	}
	
	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
