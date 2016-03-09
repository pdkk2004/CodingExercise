package Common;

/**
 * Binary index Tree implementation. a.k.a FenwickTree
 * Reference: https://www.hrwhisper.me/binary-indexed-tree-fenwick-tree/
 * @author dipa
 *
 */
public class BinaryIndexTree {
	
	private int[] nums;
	
	public BinaryIndexTree(int[] array) {
		int l = array.length;
		nums = new int[l + 1];
		for (int i = 0; i < array.length; i++) {
			add(i + 1, array[i]);
		}
	}
	
	private int lowbit(int n) {
		return n & (-n);
	}
	
	public int sum(int index) {
		if (index < 0 || index >= nums.length) {
			throw new IllegalArgumentException();
		}
		
		int ret = 0;
		while (index > 0) {
			ret += nums[index];
			index -= lowbit(index);
		}
		return ret;
	}
	
	public void add(int index, int v) {
		if (index < 1 || index >= nums.length) {
			throw new IllegalArgumentException();
		}
		
		while (index < nums.length) {
			nums[index] += v;
			index += lowbit(index);
		}
	}
}
