package MiscQuestions;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArrayConvertBasedOnPattern {

	private Map<Integer, MultiIndex> valMap;
	private Map<Integer, Integer> pMap;
	private int l;
	
	private static class MultiIndex {
		private List<Integer> index;
		private int position;
		
		public MultiIndex() {
			this.index = new ArrayList<Integer>();
			int position = 0;
		}
		
		public int getPositionAndAdvance() {
			return this.position++;
		}
	}
	
	public ArrayConvertBasedOnPattern(int[] nums, int[] pt) {
		int nl = nums.length;
		int pl = pt.length;
		if (nl != pl) {
			throw new IllegalArgumentException();
		}
		this.valMap = new HashMap<>();
		this.pMap = new HashMap<>();
		this.l = nl;
		for (int i = 0; i < nl; i++) {
			MultiIndex mi = valMap.getOrDefault(nums[i], new MultiIndex());
			mi.index.add(i);
			valMap.putIfAbsent(nums[i], mi);
		}
		
		for (int i = 0; i < pl; i++) {
			MultiIndex mi = valMap.get(pt[i]);
			pMap.put(i, mi.index.get(mi.getPositionAndAdvance()));
		}
	}
	
	public int[] convert(int[] numbers) {
		if (numbers.length != l) {
			throw new IllegalArgumentException();
		}
		int[] ret = new int[l];
		for (int i = 0; i < l; i++) {
			ret[i] = numbers[pMap.get(i)];
		}
		return ret;
	}
	
	public static void main(String[] args) {
		ArrayConvertBasedOnPattern acbp = new ArrayConvertBasedOnPattern(new int[]{1, 3, 3, 4}, new int[]{4, 3, 3, 1});
		System.out.println(Arrays.toString(acbp.convert(new int[]{6, 8, 8, 9})));
		
		ArrayConvertBasedOnPattern acbp1 = new ArrayConvertBasedOnPattern(new int[]{1, 2, 3, 4}, new int[]{4, 3, 2, 1});
		System.out.println(Arrays.toString(acbp1.convert(new int[]{6, 7, 8, 9})));
	}
}
