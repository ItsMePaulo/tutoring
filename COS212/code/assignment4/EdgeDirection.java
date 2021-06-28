public enum EdgeDirection {

    // This order is very important its the order specified by the spec
    LEFT {
        @Override
        public Vertex getDirectionalNeighbour(Edge[] edges, Vertex vertex) {
            for (Edge edge : edges) {
                if (edge.to.coords.col.compareTo(vertex.coords.col) < 0) {
                    return edge.to;
                }
            }

            return null;
        }
    },
    TOP {
        @Override
        public Vertex getDirectionalNeighbour(Edge[] edges, Vertex vertex) {
            for (Edge edge : edges) {
                if (edge.to.coords.row.compareTo(vertex.coords.row) < 0) {
                    return edge.to;
                }
            }

            return null;
        }
    },
    RIGHT {
        @Override
        public Vertex getDirectionalNeighbour(Edge[] edges, Vertex vertex) {
            for (Edge edge : edges) {
                if (edge.to.coords.col.compareTo(vertex.coords.col) > 0) {
                    return edge.to;
                }
            }

            return null;
        }
    },
    BOTTOM {
        @Override
        public Vertex getDirectionalNeighbour(Edge[] edges, Vertex vertex) {
            for (Edge edge : edges) {
                if (edge.to.coords.row.compareTo(vertex.coords.row) > 0) {
                    return edge.to;
                }
            }

            return null;
        }
    };

    abstract public Vertex getDirectionalNeighbour(Edge[] edges, Vertex vertex);
}
