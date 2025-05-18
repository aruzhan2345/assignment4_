import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch<T> extends Search<T> {

    public BreadthFirstSearch(MyGraph<T> graph, T sourceData) {
        super(graph, sourceData);
        bfs(this.sourceVertex);
    }

    private void bfs(Vertex<T> startNode) {
        marked.add(startNode);
        Queue<Vertex<T>> queue = new LinkedList<>();
        queue.add(startNode);

        while (!queue.isEmpty()) {
            Vertex<T> v = queue.remove();
            for (Vertex<T> neighbor : v.getAdjacentVertices().keySet()) {
                if (!marked.contains(neighbor)) {
                    marked.add(neighbor);
                    edgeTo.put(neighbor, v);
                    queue.add(neighbor);
                }
            }
        }
    }
}