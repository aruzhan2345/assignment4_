public class Main {
    public static void main(String[] args) {
        WeightedGraph<String> weightedGraph = new WeightedGraph<>(true);
        fillWithWeights(weightedGraph);

        System.out.println("Dijkstra:");
        Search<String> djk = new DijkstraSearch<>(weightedGraph, "Almaty");
        outputPath(djk, "Kyzylorda");

        WeightedGraph<String> graphForBfsDfs = new WeightedGraph<>(true);
        fillWithoutWeights(graphForBfsDfs);

        System.out.println("DFS:");
        Search<String> dfs = new DepthFirstSearch<>(graphForBfsDfs, "Almaty");
        outputPath(dfs, "Kyzylorda");

        System.out.println("BFS:");
        Search<String> bfs = new BreadthFirstSearch<>(graphForBfsDfs, "Almaty");
        outputPath(bfs, "Kyzylorda");
    }

    public static void fillWithoutWeights(WeightedGraph<String> graph) {
        graph.addEdge("Almaty", "Astana");
        graph.addEdge("Shymkent", "Atyrau");
        graph.addEdge("Atyrau", "Astana");
        graph.addEdge("Almaty", "Shymkent");
        graph.addEdge("Shymkent", "Astana");
        graph.addEdge("Astana", "Kostanay");
        graph.addEdge("Shymkent", "Kyzylorda");
    }

    public static void fillWithWeights(WeightedGraph<String> graph) {
        graph.addEdge("Almaty", "Astana", 2.1);
        graph.addEdge("Shymkent", "Atyrau", 7.8);
        graph.addEdge("Atyrau", "Astana", 7.1);
        graph.addEdge("Almaty", "Shymkent", 7.2);
        graph.addEdge("Shymkent", "Astana", 3.9);
        graph.addEdge("Astana", "Kostanay", 3.5);
        graph.addEdge("Shymkent", "Kyzylorda", 5.4);
    }

    public static void outputPath(Search<String> search, String key) {
        if (search == null) {
            System.out.println("Search object is null.");
            return;
        }
        Iterable<String> path = search.pathTo(key);
        if (path == null) {
            System.out.println("No path found to " + key);
            return;
        }

        boolean first = true;
        for (String v : path) {
            if (!first) {
                System.out.print(" -> ");
            }
            System.out.print(v);
            first = false;
        }
        System.out.println();
    }
}