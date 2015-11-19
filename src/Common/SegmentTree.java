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
		double height = (int) Math.ceil(Math.log(l) / Math.log(2));
		int maxLength = (int) Math.pow(2.0, height) * 2 - 1;
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
	 * Get result of range from index b to index e of array based on the operation provided.
	 * 
	 * @param b
	 * @param e
	 * @return sum of the range.
	 */
	public int getOperationOfRange(int b, int e) {
		return getOperationOfRangeUtil(b, e, 0, valArray.length - 1, 0, this.oper);
	}

	private int getOperationOfRangeUtil(int b, int e, int segB, int segE, int segIndex, Operable<Integer> op) {
		if (b <= segB && e >= segE) {
			return this.segArray[segIndex];
		}

		if (b > segE || e < segB) {
			return 0;
		}

		int mid = segB + (segE - segB) / 2;
		return op.operate(getOperationOfRangeUtil(b, e, segB, mid, segIndex * 2 + 1, op),
				getOperationOfRangeUtil(b, e, mid + 1, segE, segIndex * 2 + 2, op));
	}
	
	/**
	 * Update value of array at given index to new value.
	 * 
	 * @param index
	 * @param newVal
	 */
	public void update(int index, int newVal) {
		updateUtil(index, newVal, 0, valArray.length - 1, 0, this.oper);
	}
	
	private int updateUtil(int index, int newVal, int segB, int segE, int segIndex, Operable<Integer> op) {
		if (index < segB && index > segE) {
			return segArray[segIndex];
		}
		
		if (segB == segE) {
			segArray[segIndex] = newVal;
		} else {
			int mid = segB + (segE - segB) / 2;
			segArray[segIndex] = op.operate(updateUtil(index, newVal, segB, mid, segIndex * 2 + 1, op),
					updateUtil(index, newVal, mid + 1, segE, segIndex * 2 + 1, op));
		}
		return segArray[segIndex];

	}
}
