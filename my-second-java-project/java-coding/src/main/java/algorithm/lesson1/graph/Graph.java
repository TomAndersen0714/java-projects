package algorithm.lesson1.graph;

/**
 * @author TomAndersen
 */
public interface Graph {

    /**
     * return the number of vertexes
     *
     * @return
     */
    int vertex();

    /**
     * return the number of edges
     *
     * @return
     */
    int edge();

    /**
     * add an edge into graph
     *
     * @param v
     * @param w
     * @return
     */
    boolean connect(int v, int w);


    /**
     * return the adjacent vertexes of corresponding vertex
     *
     * @param v
     * @return
     */
    Iterable<Integer> adjacent(int v);

    /**
     * iterate the vertexes in graph and print the path
     *
     * @return
     */
    @Override
    public String toString();
}
