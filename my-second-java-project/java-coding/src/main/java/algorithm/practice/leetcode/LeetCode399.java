package algorithm.practice.leetcode;

import java.util.*;

/**
 * 399. Evaluate Division: https://leetcode.com/problems/evaluate-division/
 *
 * @author TomAndersen
 */
public class LeetCode399 {
}

/**
 * Adjacency array (weighted graph) + BFS
 */
class LeetCode399_1 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // exclude boundary situations
        if (equations == null || values == null || equations.isEmpty() || values.length == 0 ||
            equations.size() != values.length) {
            double[] res = new double[queries.size()];
            Arrays.fill(res, -1.0);
            return res;
        }

        // build initial weighted graph (adjacency list) using map-map
        Map<String, Map<String, Double>> adjacencyListGraph = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            // get the edge and weight
            String x = equations.get(i).get(0), y = equations.get(i).get(1);
            double valueXY = values[i], valueYX = 1 / values[i];
            // add the two edges into graph
            Map<String, Double> edgesX = adjacencyListGraph.getOrDefault(x, new HashMap<>());
            Map<String, Double> edgesY = adjacencyListGraph.getOrDefault(y, new HashMap<>());
            edgesX.put(y, valueXY);
            edgesY.put(x, valueYX);
        }


        // resolve the queries by bfs, and store the values of iteration path
        Set<String> visitedVertexes = new HashSet<>();
        int querySize = queries.size();
        double[] results = new double[querySize];
        for (int i = 0; i < querySize; i++) {
            String x = queries.get(i).get(0), y = queries.get(i).get(1);
            double result = -1.0;

            // if the start vertex is in the graph
            if (adjacencyListGraph.containsKey(x)) {
                // if the vertex is visited
                if (!visitedVertexes.contains(x)) {

                    // visited the connected component from the vertex by bfs, and update the adjacency list


                    // mark visited
                    visitedVertexes.add(x);

                    Map<String, Double> edge = adjacencyListGraph.get(x);
                    result = edge.getOrDefault(y, -1.0);
                }
            }

            // store the value
            results[i] = result;
        }

        // return
        return results;
    }
}

/**
 * Adjacency array (weighted graph) + DFS
 */
class LeetCode399_2 {

}
