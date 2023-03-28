package algorithm.lesson1.graph.traverse;

import algorithm.lesson1.graph.Graph;

/**
 * @author TomAndersen
 */
public class DFS {

    /**
     * depth-first-search from specific vertex
     *
     * @param adjArray
     */
    public static String depthFirstPath(int[][] adjArray, int vertex) {
        return null;
    }

    public static String depthFirstPath(int[][] matrix, int x, int y) {
        // https://leetcode.com/problems/max-area-of-island/description/
        return null;

    }

    /**
     * depth-first-search from vertex v
     *
     * @param g
     * @param v
     */
    public static String depthFirstPath(Graph g, int v) {
        StringBuilder sb = new StringBuilder();
        boolean[] visited = new boolean[g.vertex()];

        depthFirstPath(g, v, visited, sb);
        return sb.toString();
    }

    private static void depthFirstPath(Graph g, int v, boolean[] visited, StringBuilder sb) {
        // traverse the adjacent vertex
        for (int vertex : g.adjacent(v)) {
            if (!visited[vertex]) {
                depthFirstPath(g, vertex, visited, sb);
            }
        }

        // traverse current vertex
        visited[v] = true;
        sb.append(v);
    }

    public static void main(String[] args) {

    }
}
