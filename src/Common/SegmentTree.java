package Common;

public class SegmentTree {
	
	private int[] segArray;
	private int[] valArray;
	private Operable<Integer> oper;
	
	public SegmentTree(int[] valArray) {
		this(valArray, (v1, v2) -> v1 + v2);
	}
	
	public SegmentTree(int[] valArray, Operable<Integer> op) {
		int l = valArray.length;
		this.valArray = valArray;
		this.oper = op;
		double height = (int)Math.ceil(Math.log(l) / Math.log(2));
		int maxLength = (int)Math.pow(2.0, height) * 2 - 1;
		segArray = new int[maxLength];
		this.build(valArray, 0, l - 1, segArray, 0);
	}
	
	private int build(int[] vals, int b, int e, int[] segs, int root) {
		if (b == e) {
			segs[root] = vals[b];
		}
		int mid = b + (e - b) / 2;
		int left = build(vals, b, mid, segs, 2 * root + 1);
		int right = build(vals, mid + 1, e, segs, 2 * root + 2);
		segs[root] = oper.operate(left, right);
		return segs[root];
	}
	
	/**
	 * Get sum of range from index b to index e of array.
	 * @param b
	 * @param e
	 * @return sum of the range.
	 */
	public int getSum(int b, int e) {
		return getSumUtil(b, e, 0, valArray.length - 1, 0);
	}
	
	private int getSumUtil(int b, int e, int seqB, int seqE, int seqIndex) {
		if (b <= seqB && e >= seqE) {
			return this.segArray[seqIndex];
		}
		
		if (b > seqE || e < seqB) {
			return 0;
		}
		
		int mid = seqB + (seqE - seqB) / 2;
		return getSumUtil(b, e, seqB, mid, seqIndex * 2 + 1) + getSumUtil(b, e, mid + 1, seqE, seqIndex * 2 + 2);
	}
}
