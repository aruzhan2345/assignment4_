Graph Algorithms: BFS and Dijkstra with Vertex-Centric Adjacency

This project provides a Java implementation of graph data structures and two common graph traversal/search algorithms: Breadth-First Search (BFS) and Dijkstra's Algorithm. The core design emphasizes a `Vertex` class that directly stores its adjacent vertices and the weights of the edges leading to them.

## Project Structure

The project consists of the following main Java classes:

* **`Vertex<T>`**: Represents a generic vertex in the graph. Each vertex holds its data and a map of its adjacent vertices to the corresponding edge weights (`Map<Vertex<T>, Double>`).
* **`Graph<T>`**: An abstract base class for graph representations. It manages a collection of vertices and provides common functionalities like adding and retrieving vertices. It defines abstract methods for adding edges and querying graph properties.
* **`WeightedGraph<T>`**: A concrete implementation of `Graph<T>`. It represents an edge-weighted graph. It implements methods to add edges with specified weights and also supports adding edges without explicit weights, making it usable for algorithms that don't rely on weights, like BFS.
* **`Search<T>`**: An abstract base class for search algorithms. It initializes common structures like `marked`  and `edgeTo`. It requires a graph instance and a source vertex data for initialization. It provides `hasPathTo(T data)` and `pathTo(T data)` methods.
* **`BreadthFirstSearch<T>`**: An implementation of the Breadth-First Search algorithm, extending `Search<T>`. It can operate on any `Graph<T>` instance, effectively ignoring edge weights if present.
* **`DijkstraSearch<T>`**: An implementation of Dijkstra's algorithm for finding the shortest paths in a weighted graph, extending `Search<T>`. It specifically requires a `WeightedGraph<T>` to access edge weights.
* **`DepthFirstSearch<T>`**: An implementation of the Depth-First Search algorithm, extending `Search<T>`. Similar to BFS, it can operate on any `Graph<T>` instance.
* **`Main.java`**: An example class demonstrating the usage of the graph structures and search algorithms. It showcases how to create graphs, add edges, and find paths using BFS, DFS, and Dijkstra's algorithm.

## Key Design Choice: Vertex-Centric Adjacency

Unlike traditional graph representations where edges might be distinct objects managed by the graph class, this implementation embeds adjacency information directly within each `Vertex` object.

Modifications Summary
This version of the code has moved away from a separate UnweightedGraph class.

BaseGraph has been renamed to Graph and is an abstract class.
WeightedGraph is now the primary concrete graph implementation and extends Graph.
WeightedGraph handles both addEdge(source, dest, weight) and addEdge(source, dest). This allows it to serve as the graph structure for both weight-sensitive algorithms and weight-agnostic algorithms (like BFS and DFS).
Search algorithm classes (BreadthFirstSearch, DepthFirstSearch) now expect a Graph<T> in their constructors, making them compatible with WeightedGraph.
This refactoring simplifies the class hierarchy while maintaining the core functionality and the vertex-centric design.
