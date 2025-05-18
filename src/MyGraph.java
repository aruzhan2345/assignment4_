import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public abstract class MyGraph<T> {
    protected final Map<T, Vertex<T>> vertices; // Map data to Vertex object
    protected final boolean undirected;

    public MyGraph(boolean undirected) {
        this.undirected = undirected;
        this.vertices = new HashMap<>();
    }

    public Vertex<T> getVertex(T data) {
        return vertices.get(data);
    }

    public Vertex<T> getOrCreateVertex(T data) {
        return vertices.computeIfAbsent(data, Vertex::new);
    }

    public void addVertex(T data) {
        getOrCreateVertex(data);
    }

    public boolean hasVertex(T data) {
        return vertices.containsKey(data);
    }

    public int getVerticesCount() {
        return vertices.size();
    }

    public Collection<Vertex<T>> getAllVertices() {
        return vertices.values();
    }

    // Abstract methods to be implemented by concrete graph classes
    public abstract void addEdge(T sourceData, T destData, double weight);
    public abstract void addEdge(T sourceData, T destData); // For adding edges without explicit weight
    public abstract boolean hasEdge(T sourceData, T destData);
    public abstract int getEdgesCount();
}