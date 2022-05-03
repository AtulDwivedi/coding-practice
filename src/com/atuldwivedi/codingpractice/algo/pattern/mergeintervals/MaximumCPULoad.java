package com.atuldwivedi.codingpractice.algo.pattern.mergeintervals;

import java.util.*;

/**
 * @author Atul Dwivedi
 * <p>
 * Reference
 * https://www.educative.io/courses/grokking-the-coding-interview/YVwln9kYxV2
 */
public class MaximumCPULoad {

    /**
     * @param jobs
     * @return maxCPULoad
     * <p>
     * TC: O(nlogn)
     * SC: O(n)
     */
    public static int findMaxCPULoad(List<Job> jobs) {
        if (jobs == null || jobs.size() == 0) {
            return 0;
        }

        //TC: O(nlogn) and SC: O(n)
        Collections.sort(jobs, (a, b) -> Integer.compare(a.start, b.start));
        System.out.println(jobs);

        int currentCPULoad = 0;
        int maxCPULoad = 0;
        PriorityQueue<Job> minHeap = new PriorityQueue<>(jobs.size(), (a, b) -> Integer.compare(a.end, b.end));

        for (Job job : jobs) {
            while (!minHeap.isEmpty() && minHeap.peek().end < job.start) {
                Job polledJob = minHeap.poll();
                currentCPULoad = currentCPULoad - polledJob.cpuLoad;
            }

            minHeap.offer(job);
            currentCPULoad = currentCPULoad + job.cpuLoad;
            maxCPULoad = Math.max(maxCPULoad, currentCPULoad);
            System.out.println(minHeap + "    maxCPULoad: " + maxCPULoad);
        }
        return maxCPULoad;
    }

    public static void main(String[] args) {
        List<Job> input = new ArrayList<Job>(Arrays.asList(new Job(1, 4, 3), new Job(2, 5, 4), new Job(7, 9, 6)));
        System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));
        System.out.println("----");
        input = new ArrayList<Job>(Arrays.asList(new Job(6, 7, 10), new Job(2, 4, 11), new Job(8, 12, 15)));
        System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));
        System.out.println("----");
        input = new ArrayList<Job>(Arrays.asList(new Job(1, 4, 2), new Job(2, 4, 1), new Job(3, 6, 5)));
        System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));
    }
}

class Job {
    int start;
    int end;
    int cpuLoad;

    public Job(int start, int end, int cpuLoad) {
        this.start = start;
        this.end = end;
        this.cpuLoad = cpuLoad;
    }

    @Override
    public String toString() {
        return "Job{" +
                "start=" + start +
                ", end=" + end +
                ", cpuLoad=" + cpuLoad +
                '}';
    }
}
