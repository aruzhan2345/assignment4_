public class DepthFirstSearch<T> extends Search<T> {

    public DepthFirstSearch(MyGraph<T> graph, T sourceData) {
        super(graph, sourceData);
        dfs(this.sourceVertex);
    }

    private void dfs(Vertex<T> current) {
        marked.add(current);

        for (Vertex<T> neighbor : current.getAdjacentVertices().keySet()) {
            if (!marked.contains(neighbor)) {
                edgeTo.put(neighbor, current);
                dfs(neighbor);
            }
        }
    }
}