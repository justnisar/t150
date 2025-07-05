package src;

import java.util.*;

public class EvaluateDivision {

    private Map<String, Map<String, Double>> buildGraph(List<List<String>> equations, double[] values) {

        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String from = equation.get(0);
            String to = equation.get(1);
            graph.computeIfAbsent(from, k -> new HashMap<>()).put(to, values[i]);
            graph.computeIfAbsent(to, k -> new HashMap<>()).put(from, 1 / values[i]);
        }
        return graph;
    }

    private double dfs(String source, String target, double product, Map<String, Map<String, Double>> graph, Set<String> visited){
        // If a variable is not in the graph, no path can exist.
        if (!graph.containsKey(source)) {
            return -1.0;
        }

        // Base case: We have reached the target node.
        if (source.equals(target)) {
            return product;
        }

        visited.add(source);

        // Explore all neighbors of the current node.
        for (Map.Entry<String, Double> neighborEntry : graph.get(source).entrySet()) {
            String neighbor = neighborEntry.getKey();
            if (!visited.contains(neighbor)) {
                double edgeValue = neighborEntry.getValue();
                double result = dfs(neighbor, target, product * edgeValue, graph, visited);

                // If a valid path was found down this branch, return the result immediately.
                if (result != -1.0) {
                    return result;
                }
            }
        }
        return -1.0;

    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        Map<String, Map<String, Double>> graph = buildGraph(equations, values);
        double[] result = new double[queries.size()];
        for(int i = 0 ; i < queries.size() ; i++) {
            List<String> query = queries.get(i);
            String source = query.get(0);
            String target = query.get(1);
            result[i] = dfs(source, target, 1.00000, graph, new HashSet<>());
        }
        return result;
    }

}

