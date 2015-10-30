package MiscQuestions;

import java.util.ArrayList;
import java.util.Collections;

/**
 * http://www.fgdsb.com/2015/01/30/meeting-rooms/
 * @author kkdpan
 *
 */
public class MeetingRooms {
	
	private static class Pair implements Comparable<Pair> {
		private int start;
		private int end;
		
		public Pair(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		public int compareTo(Pair p) {
			if (this.start != p.start) {
				return this.start - p.start;
			} else {
				return p.end - this.end;
			}
		}
	}
	
	public static boolean attendAll(ArrayList<Pair> meetings) {
		Collections.sort(meetings);
		
		for (int i = 0; i < meetings.size() - 1; i++) {
			if (Math.max(meetings.get(i).start, meetings.get(i + 1).start) < Math.min(meetings.get(i).end, meetings.get(i + 1).end)) {
				return false;
			}
		}
		return true;
	}
	
	public static int RequiredRooms(ArrayList<Pair> meetings) {
		ArrayList<Integer> points = new ArrayList<Integer>();
		for (Pair p : meetings) {
			points.add(p.start);
			points.add(-p.end);
		}
		
		Collections.sort(points, (p1, p2) -> Math.abs(p1) == Math.abs(p2) ? p1 - p2 : Math.abs(p1) - Math.abs(p2));  //If end point == start point, put end point ahead;
		
		int ret = 0;
		int r = 0;
		for (int i : points) {
			if (i >= 0) {
				r++;
			} else {
				r--;
			}
			if (r > ret) {
				ret = r;
			}
		}
		return ret;
	}
}
