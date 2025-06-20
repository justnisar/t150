package src;

import java.util.*;

public class CourseSchedule {

    private List<List<Integer>> buildGraph(int numCourses, int[][] prerequisites){
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0 ; i < numCourses ; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] prerequisite : prerequisites){
            int x = prerequisite[0];
            int y = prerequisite[1];
            graph.get(y).add(x);
        }
        return graph;
    }

    private boolean dfs(int start, List<List<Integer>> graph, Set<Integer> visited, boolean[] track){
        if(visited.contains(start)){
            return false;
        }
        if(track[start]){
            return true;
        }
        visited.add(start);
        track[start] = true;
        boolean result = true;
        for(int i : graph.get(start)){
            if(dfs(i, graph, visited, track) == false){
                return false;
            }
        }
        visited.remove(start);
        return result;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        boolean[] track = new boolean[numCourses];
        List<List<Integer>> graph = buildGraph(numCourses, prerequisites);
        for(int i = 0 ; i < numCourses ; i++){
            if(dfs(i, graph, new HashSet<Integer>(), track) == false){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] prerequisites = {{1,4},{2,4},{3,1},{3,1},{3,2}};
        System.out.println(new CourseSchedule().canFinish(5, prerequisites));
    }
}
