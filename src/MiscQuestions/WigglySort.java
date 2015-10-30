package MiscQuestions;

public class WigglySort {

	//http://www.fgdsb.com/2015/01/20/special-sorting/
	public static void wigglySort(int[] array) {
		int l = array.length;
		boolean smallHead = true;
		
		for (int i = 0; i < l - 1; i++) {
			if (smallHead && array[i] > array[i + 1] || !smallHead && array[i] < array[i + 1]) {
				int temp= array[i];
				array[i] = array[i + 1];
				array[i + 1] = temp;
			}
			smallHead = !smallHead;
		}
	}
}
