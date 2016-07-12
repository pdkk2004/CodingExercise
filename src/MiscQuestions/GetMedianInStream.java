package MiscQuestions;

public class GetMedianInStream {
	
	private int[] counter;
	
	private int sum;
	
	private int count;
	
	public GetMedianInStream(int range) {
		counter = new int[range];
		sum = 0;
		count = 0;
	}
	
	public double getMedian() {
		if (count == 0) {
			throw new RuntimeException("No input value yet.");
		}
		int median = count / 2;
		int i = 0;
		int s = 0;
		while (i < counter.length && s < median) {
			s += counter[i];
			i++;
		}
		
		if (s == median) {
			int next = i;
			while (next < counter.length && counter[next] == 0) {
				next++;
			}
			if (count % 2 == 0) {
				return (next + i) / 2.0;
			} else {
				return (double)i;
			}
		} else {
			return i;
		}
		
	}
	
	public double getMean() {
		return sum / (double)count;
	}
	
	public void insert(int v) {
		counter[v] += 1;
		sum += v;
		count++;
	}
}
