
public class Edge {

    public Vertex from;
    public Vertex to;

    public int weight;

    Edge(Vertex f, Vertex t, int w) {
        from = f;
        to = t;

        weight = w;
    }
}
