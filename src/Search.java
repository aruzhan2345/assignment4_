import java.util.*;

public abstract class Search<T> {
    protected final MyGraph<T> graph;
    protected final Vertex<T> sourceVertex;
    protected final T sourceData;
    protected final Set<Vertex<T>> marked;
    protected final Map<Vertex<T>, Vertex<T>> edgeTo;

    public Search(MyGraph<T> graph, T sourceData) {
        this.graph = graph;
        this.sourceData = sourceData;
        this.sourceVertex = graph.getVertex(sourceData);

        if (this.sourceVertex == null) {
            throw new IllegalArgumentException("Source vertex '" + sourceData + "' not found in the graph.");
        }

        this.marked = new HashSet<>();
        this.edgeTo = new HashMap<>();
    }

    public boolean hasPathTo(T dataValue) {
        Vertex<T> v = graph.getVertex(dataValue);
        if (v == null) {
            return false;
        }
        return marked.contains(v);
    }

    public Iterable<T> pathTo(T dataValue) {
        Vertex<T> targetVertex = graph.getVertex(dataValue);

        if (!hasPathTo(dataValue)) {
            return null;
        }

        LinkedList<T> path = new LinkedList<>();
        for (Vertex<T> x = targetVertex; x != null && !x.equals(sourceVertex); x = edgeTo.get(x)) {
            path.push(x.getData());
            if (edgeTo.get(x) == null && targetVertex != sourceVertex ) {
                System.err.println("Error in pathTo: Path broken for " + x.getData() + ". Predecessor not found.");
                return Collections.emptyList();
            }
        }
        path.push(sourceVertex.getData());

        return path;
    }
}