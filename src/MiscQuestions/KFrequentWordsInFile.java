package MiscQuestions;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;

import com.google.common.base.Joiner;

import Common.Heap;

public class KFrequentWordsInFile {
	
	public static class WordCounter implements Comparable<WordCounter> {
		private String word;
		private int count;
		private static Joiner joiner = Joiner.on(' ').skipNulls();
		private boolean flag;
		
		public WordCounter(String word, int count) {
			this.word = word;
			this.count = count;
		}
		
		public WordCounter(String word) {
			this.word = word;
			this.count = 0;
		}
		
		public void incrementCount() {
			this.count++;
		}
		
		@Override
		public int compareTo(WordCounter wc) {
			return this.count - wc.count;
		}
		
		// Override
		public String toString() {
			return joiner.join(this.word, this.count);
		}
		
		public void setFlag(boolean b) {
			this.flag = b;
		}
		
		public boolean flipFlag() {
			this.flag = !this.flag;
			return flag;
		}
		
		public boolean getFlag() {
			return flag;
		}
	}
	
	public static List<WordCounter> findKFrequentWords(String input, int k) {
		Map<String, WordCounter> lookup = new HashMap<String, WordCounter>();
		Heap<WordCounter> heap = new Heap<WordCounter>((w1, w2) -> w2.count - w1.count);

		String[] words = input.split("\\W+");
		for (String word : words) {
			WordCounter wc = lookup.get(word);
			if (wc == null) {
				wc = new WordCounter(word, 0);
				lookup.put(word, wc);
			}
			if (k > heap.size()) {
				wc.incrementCount();
				if (wc.flag) {
					heap.remove(wc);
				}
				heap.add(wc);
				wc.flag = true;
			} else {
				int min = heap.peek().count;
				wc.incrementCount();
				if (wc.count > min) {
					if (!wc.flag) {
						heap.poll().flag = false;
					} else {
						heap.remove(wc);
					}
					heap.add(wc);
					wc.flag = true;
				}
			}
		}
		
		return Arrays.asList(heap.toArray(new WordCounter[heap.size()]));
	}
	
	public static void main(String[] args) throws IOException {
		String fileName = "resource/sampleText.txt";
		String input = FileUtils.fileRead(fileName);
		int K = 20;
		List<WordCounter> result = findKFrequentWords(input, K);
		Collections.sort(result, (r1, r2) -> r2.count - r1.count);
		System.out.println(result);
	}
}
