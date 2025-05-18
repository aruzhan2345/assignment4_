public class WeightedGraph<T> extends MyGraph<T> {

    private static final double DEFAULT_WEIGHT = 1.0; // Default weight for unweighted edges

    public WeightedGraph(boolean undirected) {
        super(undirected);
    }

    @Override
    public void addEdge(T sourceData, T destData, double weight) {
        Vertex<T> sourceVertex = getOrCreateVertex(sourceData);
        Vertex<T> destVertex = getOrCreateVertex(destData);

        sourceVertex.addAdjacentVertex(destVertex, weight);
        if (undirected) {
            destVertex.addAdjacentVertex(sourceVertex, weight);
        }
    }

    @Override
    public void addEdge(T sourceData, T destData) {
        addEdge(sourceData, destData, DEFAULT_WEIGHT);
    }

    @Override
    public boolean hasEdge(T sourceData, T destData) {
        Vertex<T> sourceVertex = getVertex(sourceData);
        Vertex<T> destVertex = getVertex(destData);
        if (sourceVertex == null || destVertex == null) {
            return false;
        }
        return sourceVertex.getAdjacentVertices().containsKey(destVertex);
    }

    @Override
    public int getEdgesCount() {
        int count = 0;
        for (Vertex<T> vertex : vertices.values()) {
            count += vertex.getAdjacentVertices().size();
        }
        if (undirected) {
            return count / 2;
        }
        return count;
    }
}