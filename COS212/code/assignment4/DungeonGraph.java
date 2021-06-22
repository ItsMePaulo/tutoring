/**
 * Name:
 * Student Number:
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * You may add your own classes and function, but you may not modify any of
 * the given attribute names or given method signatures.
 */
public class DungeonGraph {

    private Vertex[] vertices;
    private int graphHeight;
    private int graphLength;

    /**
     * =============================
     * ===        TASK 1         ===
     * =============================
     */
    public DungeonGraph() {
        vertices = new Vertex[0];
    }

    /**
     * Create a new graph to represent the given dungeon.
     */
    public void createGraph(String filename) {

        File file = new File(filename);
        String line;

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

            int rowNumber = 0;
            while ((line = br.readLine()) != null) {
                graphLength = line.length();

                for (int i = 0; i < line.length(); i++) {
                    Character ch = line.charAt(i);

                    // its a valid character
                    VertexType type = VertexType.getType(ch);
                    if (type != VertexType.WALL) {
                        Vertex newVertex = new Vertex(type, new Coordinates(rowNumber, i));

                        vertices = HelperClass.copyInsert(vertices, newVertex);
                    }
                }

                rowNumber++;
            }

            graphHeight = rowNumber;
            setEdges();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Return the vertex with the given coordinates (row, col)
     * If the vertex does not exist, return null.
     * If the coordinates are out of bounds, return null.
     */
    public Vertex getVertex(Integer row, Integer col) {

        for (Vertex v : vertices) {
            if (v.coords.row.equals(row) && v.coords.col.equals(col))
                return v;
        }

        return null; // Stub line, you can safely remove when required
    }

    /**
     * Return a string representing a depth-first traversal of the graph.
     * The traversal must start from the Entrance vertex. For each tile,
     * visit the adjacent vertices in the following order: left, up, right, down.
     * For each vertex, output its coordinates (comma-separated).
     */
    public String toString() {
        // TODO: Your code here...

        Vertex[] adjVert = getAdjacentVertices(vertices[1]);

        System.out.println(adjVert);

        return "";
    }

    /**
     * Return the vertices adjacent to the given vertex.
     * The vertices in the returned array must be sorted in
     * the following order: left, top, right, bottom.
     * Return an empty array if there are no adjacent vertices.
     */
    public Vertex[] getAdjacentVertices(Vertex vertex) {

        Vertex[] tmpArray = new Vertex[vertex.edges.length];
        int index = 0;

        // left
        for (Edge edge: vertex.edges) {
            if (edge.to.coords.col < vertex.coords.col) {
                tmpArray[index++] = edge.to;
                break;
            }
        }
        // top
        for (Edge edge: vertex.edges) {
            if (edge.to.coords.row < vertex.coords.row) {
                tmpArray[index++] = edge.to;
                break;
            }
        }
        // right
        for (Edge edge: vertex.edges) {
            if (edge.to.coords.col > vertex.coords.col) {
                tmpArray[index++] = edge.to;
                break;
            }
        }
        // bottom
        for (Edge edge: vertex.edges) {
            if (edge.to.coords.row > vertex.coords.row) {
                tmpArray[index] = edge.to;
                break;
            }
        }

        return tmpArray; // Stub line, you can safely remove when required
    }

    /**
     * Return the vertex corresponding to the dungeon entrance.
     */
    public Vertex getDoor() {
        // TODO: Your code here...
        return null; // Stub line, you can safely remove when required
    }

    /**
     * Return the vertex corresponding to the key tile.
     */
    public Vertex getKey() {
        // TODO: Your code here...
        return null; // Stub line, you can safely remove when required
    }

    /**
     * Return the vertex corresponding to the treasure tile.
     */
    public Vertex getTreasure() {
        // TODO: Your code here...
        return null; // Stub line, you can safely remove when required
    }

    /**
     * =============================
     * ===        TASK 2         ===
     * =============================
     */

    /**
     * Return the vertices along the shortest path from the start vertex
     * to the end vertex, as identified by the given coordinates. The start
     * and the end vertex must be included. If no path exists, return an empty array.
     */
    public Vertex[] getShortestPath(Coordinates start, Coordinates end) {
        // TODO: Your code here...
        return null; // Stub line, you can safely remove when required
    }

    /**
     * Return an array of vertices that make up the shortest path from the entrance
     * to the key to the treasure and back to the entrance, in order from start to end.
     * The starting and the ending vertex (entrance) should be included in the path.
     * If there is no path, return an empty array.
     */
    public Vertex[] getShortestPath() {
        // TODO: Your code here...
        return null; // Stub line, you can safely remove when required
    }


    /**
     * Return the length of the shortest path from the given starting vertex coordinates,
     * to the end vertex coordinates. The start and end vertices should be part of the path.
     * If no path exists, return null.
     */
    public Integer getShortestPathLength(Coordinates start, Coordinates end) {
        // TODO: Your code here...
        return null; // Stub line, you can safely remove when required
    }


    /**
     * Return the string representing the shortest path from start vertex to end vertex by
     * indicating the succession of steps (left, right, up, down) that need to be taken.
     * The words must be comma-separated, with a space after each comma, and a full stop at the end.
     * Left-up-right-down movement preference applies.
     */
    public String getShortestPathString(Coordinates start, Coordinates end) {
        // TODO: Your code here...
        return null; // Stub line, you can safely remove when required
    }


    /**
     * This method has the same functionality as getShortestPathString(Coordinates start, Coordinates end),
     * but should return the text representation of the shortest path from entrance
     * to key to treasure and back to the entrance.
     */
    public String getShortestPathString() {
        // TODO: Your code here...
        return null; // Stub line, you can safely remove when required
    }

    /**
     * =============================
     * ===        TASK 3         ===
     * =============================
     */

    /**
     * No additional methods need to be implemented, but you must expand your code to work with traps and teleports.
     * @param newVertex
     */

    /**
     * =============================================
     * HELPER FUNCTIONS
     * =============================================
     */

    public void printVertices() {
        for (Vertex v : vertices) {
            System.out.print(v.type + ": " + v.coords.row + " " + v.coords.col);

            System.out.println();
        }
    }

    private void setEdges() {
        for (Vertex v : vertices) {
            // above neighbour
            if (v.coords.row - 1 >= 0 && getVertex(v.coords.row - 1, v.coords.col) != null) {
                v.addNeighbour(getVertex(v.coords.row - 1, v.coords.col));
            }
            //left neighbour
            if (v.coords.col - 1 >= 0 && getVertex(v.coords.row, v.coords.col - 1) != null) {
                v.addNeighbour(getVertex(v.coords.row, v.coords.col - 1));
            }
            //below neighbour
            if (v.coords.row + 1 < graphHeight && getVertex(v.coords.row + 1, v.coords.col) != null) {
                v.addNeighbour(getVertex(v.coords.row + 1, v.coords.col));
            }
            // right neighbour
            if (v.coords.col + 1 < graphLength && getVertex(v.coords.row, v.coords.col + 1) != null) {
                v.addNeighbour(getVertex(v.coords.row, v.coords.col + 1));
            }
        }
    }
}
