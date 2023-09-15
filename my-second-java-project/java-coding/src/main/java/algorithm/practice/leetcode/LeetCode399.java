package algorithm.practice.leetcode;

import java.util.*;
import java.util.stream.Collectors;

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

            // if the vertex is in the graph
            if (adjacencyListGraph.containsKey(y)) {
                // if the end vertex is not visited
                if (!visitedVertexes.contains(y)) {

                    // visited the connected component from the vertex by bfs, and
                    // update the weight in adjacency vertex
                    String toVertex = y;
                    Queue<String> queue = new LinkedList<>();
                    for (String vertex : adjacencyListGraph.get(toVertex).keySet()) {
                        queue.offer(vertex);
                    }
                    while (!queue.isEmpty()) {
                        String fromVertex = queue.poll();
                        Map<String, Double> edge = adjacencyListGraph.get(fromVertex);
                        Double parentWeight = edge.get(toVertex);

                        for (String vertex : edge.keySet()) {
                            if (!vertex.equals(toVertex)) {
                                adjacencyListGraph.get(vertex).put(toVertex, parentWeight / edge.get(vertex));
                                queue.offer(vertex);
                            }
                        }
                    }
                    visitedVertexes.add(toVertex);


                    // mark visited
                    visitedVertexes.add(x);

                    Map<String, Double> edge = adjacencyListGraph.get(x);
                    result = edge.getOrDefault(y, -1.0);
                }

                // get the weight from x to y
                result = 1 / adjacencyListGraph.get(y).getOrDefault(x, result);
            }

            // store the value
            results[i] = result;
        }

        // return
        return results;
    }

    public static void main(String[] args) {
        String[][] equationStrings = {{"a","b"},{"b","c"}};
        List<List<String>> equations = Arrays.stream(equationStrings).map(Arrays::asList).collect(Collectors.toList());
        System.out.println(equations);
    }
}

/**
 * Adjacency array (weighted graph) + DFS
 */
class LeetCode399_2 {

}
