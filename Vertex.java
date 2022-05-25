import javafx.beans.binding.MapExpression;
import java.util.HashMap;
import java.util.Map;
public class Vertex<V> {
    public MapExpression<V, V> adjacentVertices;
    private V data;
    private Map<Vertex<V>,Double> adjacencyVertices;

    public Vertex(V data){
        this.data=data;
        adjacencyVertices=new HashMap<>();
    }
    public void setSource(V data) {
        this.data = data;
    }
    public V getData(){return data;}
    public void setAdjacencyVertices(){this.adjacencyVertices=adjacencyVertices;}
    public Map<Vertex<V>,Double> getAdjacencyVertices(){return adjacencyVertices;}

    public void add(Vertex<V> destination, double weight){
        adjacencyVertices.put(destination,weight);
    }

    public int size(){return adjacencyVertices.size();}
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex<?> vertex = (Vertex<?>) o;
        return data.equals(vertex.data);
    }

    public boolean contains(Vertex<V> vertex) {
        return adjacencyVertices.containsKey(vertex);
    }
}