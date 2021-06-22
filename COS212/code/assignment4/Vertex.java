/**
 * Name:
 * Student Number:
 */

public class Vertex {

    public Coordinates coords;
    public VertexType type;

    public Edge[] edges;

    public Vertex() {

    }

    public Vertex(VertexType vt, Coordinates coordinates) {
        type = vt;
        coords = coordinates;

        edges = new Edge[0];
    }

    // supposed to add an edge
    public void addNeighbour(Vertex newNeighbour) {

        Edge newEdge = (this.type == VertexType.TRAP || newNeighbour.type == VertexType.TRAP) ?
                new Edge(this, newNeighbour, 2) : new Edge(this, newNeighbour, 1);


        edges = HelperClass.copyInsert(edges, newEdge);
    }

    public Vertex[] getNeighbours() {
        Vertex[] tmpArray = new Vertex[edges.length];

        for (int i = 0; i < edges.length; i++) {
            tmpArray[i] = edges[i].to;
        }

        return tmpArray;
    }
}
