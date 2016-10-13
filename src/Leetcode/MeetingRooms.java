package Leetcode;

import java.util.Arrays;

import Common.Interval;

public class MeetingRooms {
    public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, (i1, i2) -> (i1.start == i2.start ? i2.end - i1.end : i1.start - i2.start));
        for (int i = 0; i < intervals.length - 1; i++) {
            Interval itv1 = intervals[i];
            Interval itv2 = intervals[i + 1];
            if (itv2.start < itv1.end) {
                return false;
            }
        }
        return true;
    }
}
