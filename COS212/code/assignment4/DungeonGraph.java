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

        clear();

        File file = new File(filename);
        String line;

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

            int rowNumber = 0;
            while ((line = br.readLine()) != null) {
                line = line.replace(" ", "");
                if (line.length() != 0) {
                    graphLength = line.length();

                    for (int i = 0; i < line.length(); i++) {
                        Character ch = line.charAt(i);

                        // its a valid character
                        VertexType type = VertexType.getType(ch);
                        if (type != VertexType.WALL) {
                            Vertex newVertex = new Vertex(type, new Coordinates(rowNumber, i));

                            vertices = HelperClass.push(vertices, newVertex);
                        }
                    }

                    rowNumber++;
                }
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
        for (Vertex v : vertices) {
            v.counter = -1;
        }

        StringBuilder dfsSearch = new StringBuilder();

        dfsSearch = new StringBuilder(dfsSearch.append(traverseVertex(getDoor(), 0)));

        Vertex unvisited = stillUnvisited();
        while (unvisited != null) {
            dfsSearch.append(traverseVertex(unvisited, findMaxCounter() + 1));
            unvisited = stillUnvisited();
        }

        return dfsSearch.substring(0, dfsSearch.length() - 1);
    }

    private int findMaxCounter() {
        int max = -1;
        for (Vertex v : vertices) {
            if (v.counter > max) {
                max = v.counter;
            }
        }

        return max;
    }

    private Vertex stillUnvisited() {
        for (Vertex v : vertices) {
            if (v.counter == -1) {
                return v;
            }
        }

        return null;
    }

    /**
     * Return the vertices adjacent to the given vertex.
     * The vertices in the returned array must be sorted in
     * the following order: left, top, right, bottom.
     * Return an empty array if there are no adjacent vertices.
     */
    public Vertex[] getAdjacentVertices(Vertex vertex) {

        Vertex[] tmpArray = new Vertex[vertex.getNonTeleportedEdges().length];
        int index = 0;

        // teleport(2,2) = (1,2),(10,8),(2,1),(3,2),(2,3)

        // left
        for (Edge edge : vertex.getNonTeleportedEdges()) {
            if (edge.to.coords.col < vertex.coords.col) {
                tmpArray[index++] = edge.to;
                break;
            }
        }
        // top
        for (Edge edge : vertex.getNonTeleportedEdges()) {
            if (edge.to.coords.row < vertex.coords.row) {
                tmpArray[index++] = edge.to;
                break;
            }
        }
        // right
        for (Edge edge : vertex.getNonTeleportedEdges()) {
            if (edge.to.coords.col > vertex.coords.col) {
                tmpArray[index++] = edge.to;
                break;
            }
        }
        // bottom
        for (Edge edge : vertex.getNonTeleportedEdges()) {
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
        return getVertexType(VertexType.ENTRANCE);
    }

    /**
     * Return the vertex corresponding to the key tile.
     */
    public Vertex getKey() {
        return getVertexType(VertexType.KEY); // correct
    }

    /**
     * Return the vertex corresponding to the treasure tile.
     */
    public Vertex getTreasure() {
        return getVertexType(VertexType.TREASURE); // correct
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

        Vertex[] toBeChecked = new Vertex[0];

        for (Vertex v : vertices) {
            v.dist = Integer.MAX_VALUE;
            v.prev = null;
        }

        Vertex current = getVertex(start.row, start.col);

        if (current == null) {
            return toBeChecked;
        }

        current.dist = 0;
        current.prev = null;

        toBeChecked = HelperClass.push(toBeChecked, current);

        while (toBeChecked.length != 0) {

            current = toBeChecked[0];
            toBeChecked = HelperClass.pop(toBeChecked);

            for (Vertex neighbour : getNeighboursWithTeleportedEdge(current)) {

                int totalDist = current.dist + getDistBetween(current, neighbour);

                if (totalDist < neighbour.dist) {
                    neighbour.dist = totalDist;
                    neighbour.prev = current;

                    toBeChecked = HelperClass.pushIfNotFound(toBeChecked, neighbour);
                }
            }
        }

        Vertex endVertex = getVertex(end.row, end.col);
        if (endVertex != null && endVertex.prev != null) {
            return buildPath(endVertex);
        }

        return toBeChecked; // empty array
    }

    /**
     * Return an array of vertices that make up the shortest path from the entrance
     * to the key to the treasure and back to the entrance, in order from start to end.
     * The starting and the ending vertex (entrance) should be included in the path.
     * If there is no path, return an empty array.
     */
    public Vertex[] getShortestPath() {

        /**
         * 3 shortest calls (call shortest function)
         *
         * 1.) shortest entrance to key
         *      *) call getDoor() & getKey()
         *      *) these are the parameters
         *      *) first array store doorToKey
         *      *) check if empty array if true return empty array
         *
         * 2.) shortest key treasure
         *      *) call getKey() & getTreasure()
         *      *) store this second array keyToTreasure
         *      *) check if empty array if true return empty array
         *
         * 3.) shortest treasure to entrance
         *      *) call getTreasure() & getEntrance
         *      *) store these in 3rd array treasureToEntrance
         *
         *
         * combine all arrays into 1 in order
         *
         * doorToKey use array to push
         * loop through the others 1 by 1 and then call push
         *
         *  return doorToKey
         */
        Vertex[] doorToKey = getShortestPath(getDoor().coords, getKey().coords);
        Vertex[] keyToTreasure = getShortestPath(getKey().coords, getTreasure().coords);
        Vertex[] treasureToEntrance = getShortestPath(getTreasure().coords, getDoor().coords);

        if (doorToKey.length == 0 || keyToTreasure.length == 0)
            return new Vertex[0];
        else {
            for (int i = 1; i < keyToTreasure.length; i++) {
                doorToKey = HelperClass.push(doorToKey, keyToTreasure[i]);
            }
            for (int i = 1; i < treasureToEntrance.length; i++) {
                doorToKey = HelperClass.push(doorToKey, treasureToEntrance[i]);
            }
        }
        return doorToKey; // Stub line, you can safely remove when required
    }


    /**
     * Return the length of the shortest path from the given starting vertex coordinates,
     * to the end vertex coordinates. The start and end vertices should be part of the path.
     * If no path exists, return null.
     */
    public Integer getShortestPathLength(Coordinates start, Coordinates end) {

        Vertex[] pathForLength = getShortestPath(start, end);

        return (pathForLength.length != 0)
                ? pathForLength[pathForLength.length - 1].dist : null;

    }


    /**
     * Return the string representing the shortest path from start vertex to end vertex by
     * indicating the succession of steps (left, right, up, down) that need to be taken.
     * The words must be comma-separated, with a space after each comma, and a full stop at the end.
     * Left-up-right-down movement preference applies.
     */
    public String getShortestPathString(Coordinates start, Coordinates end) {
        Vertex[] shortestPath = getShortestPath(start, end);

        return buildStringPath(shortestPath);
    }

    /**
     * This method has the same functionality as getShortestPathString(Coordinates start, Coordinates end),
     * but should return the text representation of the shortest path from entrance
     * to key to treasure and back to the entrance.
     */
    public String getShortestPathString() {
        Vertex[] shortestPath = getShortestPath();

        return buildStringPath(shortestPath);
    }

    private String buildStringPath(Vertex[] shortestPath) {
        String direction = "";

        for (int i = 0; i < shortestPath.length - 1; i++) {
            String endChar = (i == shortestPath.length - 2) ? "." : ", ";
            direction += getDirection(shortestPath[i], shortestPath[i + 1]) + endChar;
        }


        return direction;
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

    private Vertex[] getNeighboursWithTeleportedEdge(Vertex current) {
        Vertex[] directNeighbours = getAdjacentVertices(current);

        if (current.type.equals(VertexType.TELEPORT)) {
            return HelperClass.push(directNeighbours, current.getTeleportedNeighbour());
        }

        return directNeighbours;
    }

    private Vertex[] buildPath(Vertex vertex) {
        if (vertex != null) {

            Vertex[] va = buildPath(vertex.prev); // add our vertex to what this line returns

            return HelperClass.push(va, vertex);
        } else {
            // if vertex being passed in is null return new vertex array [0]
            return new Vertex[0];
        }
    }

    private Vertex getVertexType(VertexType vt) {
        for (Vertex v : vertices) {
            if (v.type == vt) {
                return v;
            }
        }

        return null;
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

            // connect teleports
            if (v.type == VertexType.TELEPORT) {
                for (int i = 0; i < vertices.length; i++) {
                    if (vertices[i].type == VertexType.TELEPORT && !v.equals(vertices[i])) {
                        v.addNeighbour(vertices[i]);
                        break;
                    }
                }
            }
        }
    }
}
