package MiscQuestions;

public class GetMedianInStream {
	
	private int[] counters;
	
	private int sum;
	
	private int count;
	
	public GetMedianInStream() {
		counters = new int[10000];
		sum = 0;
		count = 0;
	}
	
	public void add(int num) {
		counters[num] += 1;
		sum += num;
		count++;
	}
	
	public double getMean() {
		return sum / (double)count;
	}
	
	public double getMedian() {
		if (count == 0) {
			throw new RuntimeException();
		}
		
		int m = count / 2;
		int p = 0;
		int s = 0;
		while (p < counters.length && s < m) {
			s += counters[p];
			p++;
		}
		p--;
		
		if (s == m) {
			int next = p + 1;
			while (next < counters.length && counters[next] == 0) {
				next++;
			}
			if (count % 2 == 0) {
				return (next + p) / 2.0;
			} else {
				return next;
			}
		} else {
			return p;
		}
	}
}
