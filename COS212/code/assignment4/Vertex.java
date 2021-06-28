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

        counter = 0;

        edges = new Edge[0];
    }

    // supposed to add an edge
    public void addNeighbour(Vertex newNeighbour) {

        Edge newEdge = (this.type == VertexType.TRAP || newNeighbour.type == VertexType.TRAP) ?
                new Edge(this, newNeighbour, 2) : new Edge(this, newNeighbour, 1);


        edges = HelperClass.push(edges, newEdge);
    }

    public Vertex[] getNeighbours() {
        Vertex[] tmpArray = new Vertex[edges.length];

        for (int i = 0; i < edges.length; i++) {
            tmpArray[i] = edges[i].to;
        }

        return tmpArray;
    }

    public Edge[] getNonTeleportedEdges() {
        if (type.equals(VertexType.TELEPORT)) {
            Edge[] tmpArray = new Edge[edges.length - 1];
            int counter = 0;

            for (Edge ed : edges) {
                if (!ed.to.type.equals(VertexType.TELEPORT)) {
                    tmpArray[counter++] = ed;
                }
            }

            return tmpArray;
        } else
            return edges;
    }

    // there will be a teleport edge to this vertex
    public Vertex getTeleportedNeighbour() {
        for (Edge ed : edges) {
            if (ed.to.type.equals(VertexType.TELEPORT)) {
                return ed.to;
            }
        }

        // impossible to reach
        return null;
    }

    @Override
    public String toString() {
        return this.type.name();
    }


}
