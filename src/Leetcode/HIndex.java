package Leetcode;
import java.util.Arrays;

public class HIndex {
	
	public static void main(String[] args) {
		int[] test = {0, 0, 0, 0, 0};
		HIndex o = new HIndex();
		System.out.println(Arrays.toString(test));
		System.out.println(o.hIndex(test));
	}
	
    public int hIndex(int[] citations) {
        int l = citations.length;
        int b = 0, e = l - 1;
        while (b <= e) {
            int m = partition(citations, b, e);
            if (citations[m] == m + 1) {
                return m + 1;
            } else if (citations[m] > m + 1) {
                b = m + 1;
            } else {
                e = m - 1;
            }
        }
        return b;
    }
    
    private int partition(int[] citations, int b, int e) {
        int r = b + (int)(Math.random() * (e - b));
        int p = citations[r];
        swap(citations, b, r);
        int i = b, j = i + 1;
        while (j <= e) {
            if (citations[j] >= p) {
                swap(citations, ++i, j);
            }
            j++;
        }
        swap(citations, b, i);
        return i;
    }
    
    private void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
