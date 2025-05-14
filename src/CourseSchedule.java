package src;

import java.util.ArrayList;

public class CourseSchedule {

    /*
    private boolean[][] buildGraph(int numCourses, int[][] prerequisites){
        boolean[][] graph = new boolean[numCourses][numCourses];
        for(int[] prerequisite : prerequisites){
            graph[prerequisite[1]][prerequisite[0]] = true;
        }
        return graph;
    }

    private boolean hasCycle(boolean[] visited, int start, boolean[][] graph){
        visited[start] = true;
        for(int i = 0 ; i < graph.length; i++){
            if(graph[start][i]){
                if(visited[i]){
                    return true;
                }
                if(hasCycle(visited, i , graph)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        boolean[][] graph = buildGraph(numCourses, prerequisites);
        for(int i = 0 ; i < numCourses ; i++){
            boolean[] visited = new boolean[graph.length];
            if(hasCycle(visited, i, graph)){
                return false;
            }
        }

        return true;
    }

     */

    public boolean checkCycle(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int course){

        if(visited[course] == true)
            return false;
        else
            visited[course] = true;
        for(int i = 0 ; i < graph.get(course).size() ; i++){
            if(!checkCycle(graph,visited,graph.get(course).get(i)))
                return false;
        }
        visited[course] = false;
        return true;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        if(numCourses <= 1)
            return true;

        // Declare a graph. ArrayList of ArrayLists
        ArrayList< ArrayList<Integer> > graph = new ArrayList<ArrayList<Integer> >(numCourses);
        // boolean array to check if node of a graph is visited
        boolean[] visited = new boolean[numCourses];

        for(int i = 0 ; i < numCourses ; i++){
            graph.add(new ArrayList<Integer>());
        }
        for(int i = 0 ; i < prerequisites.length ; i++){
            int destination = prerequisites[i][0];
            int source = prerequisites[i][1];
            graph.get(source).add(destination);
        }
        for(int i = 0 ; i < numCourses ; i++){
            if(!checkCycle(graph,visited,i))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] prerequisites = {{1,0},{2,0},{0,2}};
        System.out.println(new CourseSchedule().canFinish(3, prerequisites));
    }
}
