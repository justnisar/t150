package src.not150;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DetonateTheMaximumBombs {

    private int dfs(Map<Integer, List<Integer>> graph, int start, boolean[] visited){

        if (visited[start]) {
            return 0;
        }
        int count = 1;
        visited[start] = true;

        if(graph.containsKey(start)){
            for(int to : graph.get(start)){

                count +=dfs(graph, to, visited);

            }
        }
        return count;
    }

    public int maximumDetonation(int[][] bombs) {
        Map<Integer, List<Integer>> graph = buildGraph(bombs);
        boolean[] visited;
        int max = 0;
        for(int i = 0 ; i < bombs.length ; i++){
            visited = new boolean[bombs.length];
            int current = dfs(graph, i, visited);
            max = Math.max(max, current);
        }
        return max;
    }

    private Map<Integer, List<Integer>> buildGraph(int[][] bombs) {
        // build graph
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int bombCount = bombs.length;
        for(int i = 0 ; i < bombCount; i++){
            for(int j = 0 ; j < bombCount ; j++){
                if(i == j){
                    continue;
                }
                int[] from = bombs[i];
                int[] to = bombs[j];
                double bombRange = Math.pow(from[2], 2);
                double distance = Math.pow(from[0] - to[0], 2) + Math.pow(from[1] - to[1], 2);
                if(distance <= bombRange){
                    graph.putIfAbsent(i, new ArrayList<>());
                    graph.get(i).add(j);
                }
            }
        }
        return graph;
    }
}
