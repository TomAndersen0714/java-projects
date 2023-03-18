package algorithm.lesson1.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * directed graph
 *
 * @author TomAndersen
 */
public class AdjacencyListGraph implements Graph {
    /**
     * the number of vertex
     */
    private final int v;

    /**
     * the number of edge
     */
    private int e;

    /**
     * the adjacency list
     */
    private List<List<Integer>> adjList;

    public AdjacencyListGraph(int v) {
        this.v = v;
        this.e = 0;
        adjList = new ArrayList<>(v);

        for (int i = 0; i < this.v; i++) {
            adjList.add(new LinkedList<>());
        }
    }

    public AdjacencyListGraph(boolean[][] matrix) {
        this(matrix.length);

        // add edge into graph
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j]) {
                    this.adjList.get(i).add(j);
                    this.e += 1;
                }
            }
        }
    }

    @Override
    public int vertex() {
        return this.v;
    }

    @Override
    public int edge() {
        return this.e;
    }

    /**
     * connect vertex in the graph
     *
     * @param v
     * @param w
     * @return
     */
    @Override
    public boolean connect(int v, int w) {
        if (v >= this.v || w >= this.v) return false;

        adjList.get(v).add(w);
        adjList.get(w).add(v);
        return true;
    }

    @Override
    public Iterable<Integer> adjacent(int v) {
        return adjList.get(v);
    }
}
