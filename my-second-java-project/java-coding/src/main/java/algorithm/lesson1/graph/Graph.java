package algorithm.lesson1.graph;

import java.util.Iterator;

/**
 * @author TomAndersen
 */
interface Graph<E> {

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
     */
    void addEdge();


    /**
     * return the adjacent vertexes of corresponding vertex
     *
     * @param v
     * @return
     */
    Iterator<E> adjacent(int v);

    /**
     * iterate the vertexes in graph and print the path
     *
     * @return
     */
    @Override
    public String toString();
}
