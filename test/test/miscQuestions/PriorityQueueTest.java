package test.miscQuestions;

import java.util.PriorityQueue;

import org.junit.Test;

import MiscQuestions.KFrequentWordsInFile.WordCounter;

public class PriorityQueueTest {

	
	
	@Test
	public void TestPriorityQueue() {
		PriorityQueue<WordCounter> pq = new PriorityQueue<WordCounter>();
		pq.offer(new WordCounter("Five", 5));
		pq.offer(new WordCounter("Three", 3));
		pq.poll();
		pq.offer(new WordCounter("Ten", 10));
		pq.offer(new WordCounter("Eight", 8));
		pq.offer(new WordCounter("Two", 2));
		pq.offer(new WordCounter("Six", 6));
		pq.offer(new WordCounter("One", 1));
		
		while (!pq.isEmpty()) {
			System.out.println(pq.poll());
		}
	}
}
