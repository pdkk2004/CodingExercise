package MiscQuestions;

import java.util.Arrays;

/**
 *  Given a set of n jobs with [start time, end time, cost   ] find a subset so that no 2 jobs overlap and the cost is maximum ?
 *  http://www.mitbbs.com/article_t/JobHunting/33160867.html
 *  FB interview question. DP solution.
 * @author kkdpan
 *
 */
public class MaxCostNoOverlappingJobs {

	private static class Job implements Comparable<Job>{
		private int start;
		private int end;
		private int cost;
		
		@Override
		public int compareTo(Job j1) {
			if (this.start != j1.start) {
				return this.start - j1.start;
			} else {
				return this.end - j1.end;
			}
		}
	}
	
	public int maxCost(Job[] jobs) {
		int[] dp = new int[jobs.length + 1];
		
		if (jobs.length <= 0) {
			return 0;
		}
		
		Arrays.sort(jobs);
		dp[1] = jobs[0].cost;
		
		int cost1 = 0, cost2 = 0;
		for (int i = 1; i < jobs.length; i++) {
			int j = findLastNoOverlapping(jobs, i);
			cost2 = dp[j + 1] + jobs[i].cost;
			cost1 = dp[i];
			dp[i + 1] = Math.max(cost2, cost1);
		}
		
		return dp[jobs.length];
	}
	
	private int findLastNoOverlapping(Job[] jobs, int index) {
		Job job = jobs[index];
		for (int i = index - 1; i >= 0; i++) {
			if (!isOverlap(job, jobs[i])) {
				return i;
			}
		}
		return -1;
	}

	private boolean isOverlap(Job j1, Job j2) {
		return Math.min(j1.end, j2.end) > Math.max(j1.start, j2.start);
	}
}
