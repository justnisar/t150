package src.not150;

import java.util.*;
import java.util.Map;
import java.util.PriorityQueue;

public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {
        // 1. Count the frequency of each task.
        Map<Character, Integer> taskCountMap = new HashMap<>();
        for (char task : tasks) {
            taskCountMap.put(task, taskCountMap.getOrDefault(task, 0) + 1);
        }

        // 2. Load frequencies into a max-heap to always have the most frequent task available.
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.addAll(taskCountMap.values());

        int totalTime = 0;
        // Loop as long as there are tasks to be scheduled.
        while (!pq.isEmpty()) {
            // A temporary list to hold the tasks for the current execution cycle.
            List<Integer> tasksInCycle = new ArrayList<>();

            // A cycle's length is n+1. We try to execute n+1 tasks.
            for (int i = 0; i < n + 1; i++) {
                if (!pq.isEmpty()) {
                    tasksInCycle.add(pq.poll());
                }
            }

            // For each task executed in the cycle, decrement its count
            // and add it back to the heap if it's not finished.
            for (int count : tasksInCycle) {
                if (count - 1 > 0) {
                    pq.add(count - 1);
                }
            }

            // Calculate the time elapsed in this cycle.
            // If the heap is empty, the last cycle was not full.
            // The time taken is just the number of tasks in that last cycle.
            // Otherwise, a full cycle of (n + 1) time units passed.
            totalTime += pq.isEmpty() ? tasksInCycle.size() : n + 1;
        }

        return totalTime;
    }

    public static void main(String[] args) {
        new TaskScheduler().leastInterval(new char[]{'A','A','A','B','B','B'}, 2);
    }
}