package algorithm.lesson1.graph.traverse;

import algorithm.lesson1.graph.Graph;

/**
 * @author TomAndersen
 */
public class DFS {
    /**
     * depth-first-search in graph g from vertex v
     *
     * @param g
     * @param v
     */
    public static void depthFirstSearch(Graph g, int v) {
        StringBuilder sb = new StringBuilder();
        boolean[] visited = new boolean[g.vertex()];

        depthFirstSearch(g, v, visited, sb);
        System.out.println(sb);
    }

    private static void depthFirstSearch(Graph g, int v, boolean[] visited, StringBuilder sb) {
        // traverse the adjacent vertex
        for (int vertex : g.adjacent(v)) {
            if (!visited[vertex]) {
                depthFirstSearch(g, vertex, visited, sb);
            }
        }

        // traverse current vertex
        visited[v] = true;
        sb.append(v);

    }

    /**
     * depth-first-search in weighted graph
     *
     * @param matrix
     */
    public static void depthFirstSearch(int[][] matrix) {

    }

    public static void main(String[] args) {

    }
}
