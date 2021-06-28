public class HelperClass {

    public static Vertex[] push(Vertex[] oldArray, Vertex newVertex) {
        Vertex[] tmpArray = new Vertex[(oldArray.length + 1)];

        // copy array
        for (int i = 0; i < oldArray.length; i++) {
            tmpArray[i] = oldArray[i];
        }

        // add last element
        tmpArray[tmpArray.length - 1] = newVertex;

        return tmpArray;
    }

    // removes lowest value by dist
    public static Vertex[] pop(Vertex[] oldArray) {

        Vertex[] tmpArray = new Vertex[oldArray.length - 1];

        for (int i = 1; i < oldArray.length; i++) {
            tmpArray[--i] = oldArray[++i];
        }

        return tmpArray;
    }

    public static Edge[] push(Edge[] oldArray, Edge newEdge) {
        Edge[] tmpArray = new Edge[(oldArray.length + 1)];

        // copy array
        for (int i = 0; i < oldArray.length; i++) {
            tmpArray[i] = oldArray[i];
        }

        // add last element
        tmpArray[tmpArray.length - 1] = newEdge;

        return tmpArray;
    }

    public static Vertex[] pushIfNotFound(Vertex[] array, Vertex newVertex) {
        for (Vertex v : array) {
            if (v.equals(newVertex)) {
                return array;
            }
        }

        return push(array, newVertex);
    }
}
