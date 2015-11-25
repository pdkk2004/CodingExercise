package MiscQuestions;

import java.util.PriorityQueue;

/**
 * http://www.fgdsb.com/2015/01/03/median-in-stream/
 * @author dipa
 *
 */
public class MedianInStream {
	
	private PriorityQueue<Integer> maxHeap;
	private PriorityQueue<Integer> minHeap;
	
	public MedianInStream() {
		this.maxHeap = new PriorityQueue<Integer>((x1, x2) -> x2 - x1);
		this.minHeap = new PriorityQueue<Integer>((x1, x2) -> x1 - x2);
	}
	
	public double getMedian() {
		if (maxHeap.isEmpty()) {
			throw new RuntimeException();
		} else if (maxHeap.size() == minHeap.size()) {
			return (minHeap.peek() + maxHeap.peek()) / 2.0;
		} else {
			return maxHeap.peek();
		}
	}
	
	public void add(int num) {
		if (maxHeap.isEmpty() || num < maxHeap.peek()) {  //NOTE: need to check whether heap is empty first!!!
			maxHeap.offer(num);
		} else {
			minHeap.offer(num);
		}
		
		if (minHeap.size() > maxHeap.size()) {
			maxHeap.offer(minHeap.poll());
		} else if (maxHeap.size() - 1 > minHeap.size()) {
			minHeap.offer(maxHeap.poll());
		}
	}
}
