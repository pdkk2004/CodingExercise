package MiscQuestions;

import java.util.Arrays;

import org.junit.Test;

/**
 * http://www.fgdsb.com/2015/01/03/non-overlapping-jobs/
 * @author kkdpan
 *
 */
public class NonoverlappingJobs {
	
	private static class Job implements Comparable<Job> {
		private int start;
		private int end;
		private int cost;
		
		public Job(int start, int end, int cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}

		@Override
		public int compareTo(Job o) {
			if (this.end != o.end) {
				return this.end - o.end;
			} else {
				return this.start - o.start;
			}
		}
	}
	
	public static int nonoverlappingJobs(Job[] jobs) {
		Arrays.sort(jobs);
		int[] C = new int[jobs.length + 1];
		C[0] = 0;
		
		for (int i = 0; i < jobs.length; i++) {
			int pi = findPi(jobs, jobs[i], 0, i - 1);
			C[i + 1] = Math.max(jobs[i].cost + C[pi + 1], C[i - 1]);
		}
		return C[jobs.length];
	}
	
	private static int findPi(Job[] jobs, Job job, int b, int e) {
		while (b <= e) {
			int mid = b + (e - b) / 2;
			if (jobs[mid].end <= job.start && (mid == e || jobs[mid + 1].end > job.start)) {
				return mid;
			} else if (jobs[mid].end > job.start) {
				e = mid - 1;
			} else {
				b = mid + 1;
			}
		}
		return e;
	}
	
	@Test
	public void test() {
		
	}
}
