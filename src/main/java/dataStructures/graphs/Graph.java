package dataStructures.graphs;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private final int nodes;
    private final List<List<Integer>> adjacencyList;

    public Graph(int nodes) {
        this.nodes = nodes;
        adjacencyList = new ArrayList<>();
        for (int i = 0; i < nodes; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v) {
        adjacencyList.get(u).add(v);
        // adjacencyList.get(v).add(u); // Uncomment for an undirected graph
    }

    public List<List<Integer>> getAdjacencyList() {
        return adjacencyList;
    }

    public int getNodes() {
        return nodes;
    }
}