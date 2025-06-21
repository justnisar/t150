package src;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule2 {

    private List<List<Integer>> buildGraph(int numCourses, int[][] prerequisites, int[] indegree) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            result.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            int to = prerequisite[0];
            int from = prerequisite[1];
            indegree[to]++;
            result.get(from).add(to);
        }
        return result;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> graph = buildGraph(numCourses, prerequisites, indegree);
        // Go through the indegree array and find all nodes with indegree 0
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int current = queue.remove();
            result.add(current);
            for (int i : graph.get(current)) {
                indegree[i]--;
                if (indegree[i] == 0) {
                    queue.add(i);
                }
            }
        }

        if(result.size() != numCourses) {
            return new int[0];
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
