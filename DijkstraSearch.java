import java.util.*;

public class DijkstraSearch<V> extends Search<V> {
    private final Set<V> unsettledNodes;
    private final Map<V, Double> distances;
    private final MyWeightedGraph<V> graph;

    public DijkstraSearch(MyWeightedGraph<V> graph, V source) {
        super(source);
        unsettledNodes = new HashSet<>();
        distances = new HashMap<>();
        this.graph = graph;
        dijkstra();
    }

    public void dijkstra() {
        distances.put(source, 0D);
        unsettledNodes.add(source);

        while (unsettledNodes.size() > 0) {
            V node = getVertexWithMinimumWeight(unsettledNodes);
            marked.add((V) node);
            unsettledNodes.remove(node);
            for (V target : graph.adjacencyList(node)) {
                if (getShortestDistance(target) > getShortestDistance(node)
                        + getDistance(node, target)) {
                    distances.put(target, getShortestDistance(node)
                            + getDistance(node, target));
                    edgeTo.put(target, node);
                    unsettledNodes.add(target);
                }
            }
        }
    }

    private double getDistance(V node, V target) {
        for (Edge<V> edge : graph.getEdges(node)) {
            if (edge.getDest().equals(target))
                return edge.getWeight();
        }
        throw new RuntimeException("Not found!");
    }

    private V getVertexWithMinimumWeight(Set<V> vertices) {
        V minimum = null;
        for (V vertex : vertices) {
            if (minimum == null)
                minimum = vertex;
            else {
                if (getShortestDistance(vertex) < getShortestDistance(minimum))
                    minimum = vertex;
            }
        }
        return minimum;
    }

    private double getShortestDistance(V destination) {
        Double d = distances.get(destination);
        return (d == null ? Double.MAX_VALUE : d);
    }
}

