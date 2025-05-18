import java.util.*;

public class DijkstraSearch<T> extends Search<T> {
    private final Set<Vertex<T>> unsettledNodes;
    private final Map<Vertex<T>, Double> distances;

    public DijkstraSearch(WeightedGraph<T> graph, T sourceData) {
        super(graph, sourceData);
        this.unsettledNodes = new HashSet<>();
        this.distances = new HashMap<>();
        dijkstra();
    }

    private void dijkstra() {
        distances.put(sourceVertex, 0.0);
        unsettledNodes.add(sourceVertex);

        while (!unsettledNodes.isEmpty()) {
            Vertex<T> currentNode = getVertexWithMinimumWeight(unsettledNodes);

            marked.add(currentNode);
            unsettledNodes.remove(currentNode);

            for (Map.Entry<Vertex<T>, Double> adjacencyPair : currentNode.getAdjacentVertices().entrySet()) {
                Vertex<T> adjacentNode = adjacencyPair.getKey();
                Double edgeWeight = adjacencyPair.getValue();

                if (!marked.contains(adjacentNode)) {
                    double newDistance = getShortestDistance(currentNode) + edgeWeight;
                    if (newDistance < getShortestDistance(adjacentNode)) {
                        distances.put(adjacentNode, newDistance);
                        edgeTo.put(adjacentNode, currentNode);
                        unsettledNodes.add(adjacentNode);
                    }
                }
            }
        }
    }

    private double getShortestDistance(Vertex<T> destination) {
        Double d = distances.get(destination);
        return (d == null ? Double.MAX_VALUE : d);
    }

    private Vertex<T> getVertexWithMinimumWeight(Set<Vertex<T>> vertices) {
        Vertex<T> minimum = null;
        for (Vertex<T> vertex : vertices) {
            if (minimum == null) {
                minimum = vertex;
            } else {
                if (getShortestDistance(vertex) < getShortestDistance(minimum)) {
                    minimum = vertex;
                }
            }
        }
        return minimum;
    }
}