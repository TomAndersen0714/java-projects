package algorithm.lesson1.graph;

/**
 * @author TomAndersen
 */
public class AdjacencyMatrixGraph implements Graph {

    @Override
    public int vertex() {
        return 0;
    }

    @Override
    public int edge() {
        return 0;
    }

    @Override
    public boolean connect(int v, int w) {
        return false;
    }

    @Override
    public Iterable<Integer> adjacent(int v) {
        return null;
    }
}
