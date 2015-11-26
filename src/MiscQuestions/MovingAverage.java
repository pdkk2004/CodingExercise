package MiscQuestions;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {
	
	private int size;

	private Queue<Integer> queue;
	
	private double sum;
	
	public MovingAverage(int size) {
		this.size = size;
		this.queue = new LinkedList<>();
		this.sum = 0;
	}
	
	public double getNext(int number) {
		queue.add(number);
		sum += number;
		if (queue.size() > size) {
			sum -= queue.poll();
		}
		return sum / queue.size();
	}
}
