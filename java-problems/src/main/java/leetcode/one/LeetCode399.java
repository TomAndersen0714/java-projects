package leetcode.one;

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
 * Adjacency list using map-map(weighted graph) + BFS
 */
class LeetCode399_1 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // exclude boundary situation
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
            double valueXX = 1.0, valueYY = 1.0;
            // add the two edges into graph
            Map<String, Double> edgesX = adjacencyListGraph.getOrDefault(x, new HashMap<>());
            Map<String, Double> edgesY = adjacencyListGraph.getOrDefault(y, new HashMap<>());
            edgesX.put(y, valueXY);
            edgesY.put(x, valueYX);
            edgesX.put(x, valueXX);
            edgesY.put(y, valueYY);
            adjacencyListGraph.put(x, edgesX);
            adjacencyListGraph.put(y, edgesY);
        }


        // resolve the queries by bfs, and store the values of iteration path
        int querySize = queries.size();
        double[] results = new double[querySize];
        Set<String> visitedVertexes = new HashSet<>();

        for (int i = 0; i < querySize; i++) {
            String x = queries.get(i).get(0), y = queries.get(i).get(1);
            double result = -1.0;

            // if the vertex is in the graph
            if (adjacencyListGraph.containsKey(x)) {
                // if the start vertex is not visited
                Map<String, Double> startEdges = adjacencyListGraph.get(x);

                if (!visitedVertexes.contains(x)) {

                    // visited the connected component from the specified vertex by bfs, and
                    // update the weight of all accessible vertices for the specified vertex
                    // in adjacency vertex
                    Queue<String> queue = new LinkedList<>();
                    for (String vertex : startEdges.keySet()) {
                        queue.offer(vertex);
                    }

                    while (!queue.isEmpty()) {
                        String currentVertex = queue.poll();
                        Double previousPathWeight = startEdges.get(currentVertex);
                        Map<String, Double> nextEdges = adjacencyListGraph.get(currentVertex);

                        for (String nextVertex : nextEdges.keySet()) {
                            if (!startEdges.containsKey(nextVertex)) {
                                Double nextWeight = nextEdges.get(nextVertex);
                                startEdges.put(nextVertex, previousPathWeight * nextWeight);
                                queue.offer(nextVertex);
                            }
                        }
                    }

                    // mark visited
                    visitedVertexes.add(x);
                }

                // get the weight from x to y
                result = startEdges.getOrDefault(y, result);
            }

            // store the value
            results[i] = result;
        }

        // return
        return results;
    }

    public static void main(String[] args) {
        // test case 1
        String[][] equationStrings = {
            {"a", "b"}, {"b", "c"}
        };
        double[] values = new double[]{2.0, 3.0};
        String[][] queryStrings = {
            {"a", "c"}, {"b", "a"}, {"a", "e"}, {"a", "a"}, {"x", "x"}
        };
        List<List<String>> equations = Arrays.stream(equationStrings).map(Arrays::asList).collect(Collectors.toList());
        List<List<String>> queries = Arrays.stream(queryStrings).map(Arrays::asList).collect(Collectors.toList());
        System.out.println(
            Arrays.equals(
                new LeetCode399_1().calcEquation(equations, values, queries),
                new double[]{6.00000, 0.50000, -1.00000, 1.00000, -1.00000}
            )
        );

        // test case 2
        equationStrings = new String[][]{{"a", "b"}, {"b", "c"}, {"bc", "cd"}};
        values = new double[]{1.5, 2.5, 5.0};
        queryStrings = new String[][]{{"a", "c"}, {"c", "b"}, {"bc", "cd"}, {"cd", "bc"}};
        equations = Arrays.stream(equationStrings).map(Arrays::asList).collect(Collectors.toList());
        queries = Arrays.stream(queryStrings).map(Arrays::asList).collect(Collectors.toList());
        System.out.println(
            Arrays.equals(
                new LeetCode399_1().calcEquation(equations, values, queries),
                new double[]{3.75000, 0.40000, 5.00000, 0.20000}
            )
        );

        // test case 3
        equationStrings = new String[][]{{"a", "b"}};
        values = new double[]{0.5};
        queryStrings = new String[][]{{"a", "b"}, {"b", "a"}, {"a", "c"}, {"x", "y"}};
        equations = Arrays.stream(equationStrings).map(Arrays::asList).collect(Collectors.toList());
        queries = Arrays.stream(queryStrings).map(Arrays::asList).collect(Collectors.toList());
        System.out.println(
            Arrays.equals(
                new LeetCode399_1().calcEquation(equations, values, queries),
                new double[]{0.50000, 2.00000, -1.00000, -1.00000}
            )
        );
    }
}

/**
 * Adjacency list using map-map(weighted graph) + DFS
 */
class LeetCode399_2 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // exclude boundary situation
        if (equations == null || equations.isEmpty() || values == null || values.length == 0) {
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
            double valueXX = 1.0, valueYY = 1.0;
            // add the two edges into graph
            Map<String, Double> edgesX = adjacencyListGraph.getOrDefault(x, new HashMap<>());
            Map<String, Double> edgesY = adjacencyListGraph.getOrDefault(y, new HashMap<>());
            edgesX.put(y, valueXY);
            edgesX.put(x, valueXX);
            edgesY.put(y, valueYY);
            edgesY.put(x, valueYX);

            adjacencyListGraph.put(x, edgesX);
            adjacencyListGraph.put(y, edgesY);
        }


        // iterate graph and calculate all weight
        int querySize = queries.size();
        double[] results = new double[querySize];
        Set<String> visitedVertexes = new HashSet<>();

        for (int i = 0; i < querySize; i++) {
            double result = -1.0;
            String x = queries.get(i).get(0), y = queries.get(i).get(1);

            if (adjacencyListGraph.containsKey(x)) {
                Map<String, Double> startVertexEdges = adjacencyListGraph.get(x);

                // if the starting vertex has not been visited,
                // visit it and store all accessible vertices and corresponding weight of it
                if (!visitedVertexes.contains(x)) {
                    // visit from the specified vertexes by DFS
                    for (String vertex : startVertexEdges.keySet().toArray(new String[0])) {
                        dfsRecursion(adjacencyListGraph, startVertexEdges, vertex);
                    }

                    // mark visited
                    visitedVertexes.add(x);
                }

                result = startVertexEdges.getOrDefault(y, result);
            }

            results[i] = result;
        }

        // return
        return results;
    }

    private void dfsRecursion(Map<String, Map<String, Double>> graph, Map<String, Double> startVertexEdges, String vertex) {
        Double previousPathWeight = startVertexEdges.get(vertex);
        Map<String, Double> currentEdges = graph.get(vertex);
        Set<String> nextVertexes = currentEdges.keySet();

        for (String nextVertex : nextVertexes) {
            if (!startVertexEdges.containsKey(nextVertex)) {
                Double weight = currentEdges.get(nextVertex);
                startVertexEdges.put(nextVertex, previousPathWeight * weight);
                dfsRecursion(graph, startVertexEdges, nextVertex);
            }
        }
    }

    public static void main(String[] args) {
        // test case 1
        String[][] equationStrings = {
            {"a", "b"}, {"b", "c"}
        };
        double[] values = new double[]{2.0, 3.0};
        String[][] queryStrings = {
            {"a", "c"}, {"b", "a"}, {"a", "e"}, {"a", "a"}, {"x", "x"}
        };
        List<List<String>> equations = Arrays.stream(equationStrings).map(Arrays::asList).collect(Collectors.toList());
        List<List<String>> queries = Arrays.stream(queryStrings).map(Arrays::asList).collect(Collectors.toList());
        System.out.println(
            Arrays.equals(
                new LeetCode399_2().calcEquation(equations, values, queries),
                new double[]{6.00000, 0.50000, -1.00000, 1.00000, -1.00000}
            )
        );

        // test case 2
        equationStrings = new String[][]{{"a", "b"}, {"b", "c"}, {"bc", "cd"}};
        values = new double[]{1.5, 2.5, 5.0};
        queryStrings = new String[][]{{"a", "c"}, {"c", "b"}, {"bc", "cd"}, {"cd", "bc"}};
        equations = Arrays.stream(equationStrings).map(Arrays::asList).collect(Collectors.toList());
        queries = Arrays.stream(queryStrings).map(Arrays::asList).collect(Collectors.toList());
        System.out.println(
            Arrays.equals(
                new LeetCode399_2().calcEquation(equations, values, queries),
                new double[]{3.75000, 0.40000, 5.00000, 0.20000}
            )
        );

        // test case 3
        equationStrings = new String[][]{{"a", "b"}};
        values = new double[]{0.5};
        queryStrings = new String[][]{{"a", "b"}, {"b", "a"}, {"a", "c"}, {"x", "y"}};
        equations = Arrays.stream(equationStrings).map(Arrays::asList).collect(Collectors.toList());
        queries = Arrays.stream(queryStrings).map(Arrays::asList).collect(Collectors.toList());
        System.out.println(
            Arrays.equals(
                new LeetCode399_2().calcEquation(equations, values, queries),
                new double[]{0.50000, 2.00000, -1.00000, -1.00000}
            )
        );
    }

}


/**
 * Union-find
 */
class LeetCode399_3 {

}


/**
 * Floyd-Warshall
 */
class LeetCode399_4 {

}