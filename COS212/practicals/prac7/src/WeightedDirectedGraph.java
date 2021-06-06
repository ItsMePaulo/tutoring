import java.util.ArrayList;
import java.util.List;

public class WeightedDirectedGraph {

	private List<Vertex> verticesList; //contains all vertices in this graph

	public WeightedDirectedGraph() {
		this.verticesList = new ArrayList<>();
	}

	public void addVertex(Vertex vertex) {
		this.verticesList.add(vertex);
	}

	////// Implement the methods below this line //////

	public List<Vertex> getShortestPath(Vertex sourceVertex, Vertex targetVertex) {
		// your code goes here


		int size = sourceVertex.getAdjacenciesList().size();

		sourceVertex.getDistance()

		for (Vertex neighbour: getNeighbors(sourceVertex.getAdjacenciesList())) {
			neighbour.getDistance()
		}

	}
	
	private List<Vertex> getNeighbors(List<Edge> adjList) {
		ArrayList<Vertex> neighbours = new ArrayList<>();

		for (Edge edge: adjList) {
			neighbours.add(edge.getEndVertex());
		}

		return neighbours;
	}
}
