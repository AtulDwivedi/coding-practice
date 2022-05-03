package com.atuldwivedi.codingpractice.algo.pattern.mergeintervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Atul Dwivedi
 *
 * Reference
 * https://www.educative.io/courses/grokking-the-coding-interview/qVV79nGVgAG
 */
public class ConflictingAppointments {
    public static void main(String[] args) {
        Interval[] intervals = {new Interval(1, 4), new Interval(2, 5), new Interval(7, 9)};
        boolean result = ConflictingAppointments.canAttendAllAppointments(intervals);
        System.out.println("Can attend all appointments: " + result);

        Interval[] intervals1 = {new Interval(6, 7), new Interval(2, 4), new Interval(8, 12)};
        result = ConflictingAppointments.canAttendAllAppointments(intervals1);
        System.out.println("Can attend all appointments: " + result);

        Interval[] intervals2 = {new Interval(4, 5), new Interval(2, 3), new Interval(3, 6)};
        result = ConflictingAppointments.canAttendAllAppointments(intervals2);
        System.out.println("Can attend all appointments: " + result);
    }

    public static boolean canAttendAllAppointments(Interval[] intervals) {
        int length = intervals.length;
        if (intervals == null || length < 2) {
            return true;
        }

        //TC: O(nlogn), SC: O(n)
        Arrays.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

        //TC: O(n)
        for (int i = 1; i < length; i++) {
            if (intervals[i].start < intervals[i - 1].end) {
                return false;
            }
        }

        return true;
    }

    //TODO: complete the implementation
    public static Interval[] findConflictingAppointments(Interval[] intervals) {
        if (intervals == null) {
            return null;
        }

        if (intervals.length < 2) {
            return intervals;
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
        List<Integer> conflictingAppointments = new ArrayList<>();
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i].start < intervals[i - 1].end){
                //conflictingAppointments.
            }
        }
return null;
    }
}

class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
