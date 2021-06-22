public class HelperClass{

    public static Vertex[] copyInsert(Vertex[] oldArray, Vertex newVertex) {
        Vertex[] tmpArray = new Vertex[(oldArray.length + 1)];

        // copy array
        for (int i = 0; i < oldArray.length; i++) {
            tmpArray[i] = oldArray[i];
        }

        // add last element
        tmpArray[tmpArray.length - 1] = newVertex;

        return tmpArray;
    }

    public static Edge[] copyInsert(Edge[] oldArray, Edge newEdge) {
        Edge[] tmpArray = new Edge[(oldArray.length + 1)];

        // copy array
        for (int i = 0; i < oldArray.length; i++) {
            tmpArray[i] = oldArray[i];
        }

        // add last element
        tmpArray[tmpArray.length - 1] = newEdge;

        return tmpArray;
    }
}
