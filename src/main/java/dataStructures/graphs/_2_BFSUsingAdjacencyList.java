package dataStructures.graphs;

import java.util.*;

public class _2_BFSUsingAdjacencyList {
    public static void main(String... args) {
        int nodes = 5;
        Graph graph = new Graph(nodes);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);

        int startNode = 0;
        BFSSolution2 solution = new BFSSolution2(graph);

        System.out.printf("BFS traversal from node %d: %s%n", startNode, solution.bfsTraversal(startNode));
        System.out.printf("\nBFS full traversal : %s", solution.bfsFullTraversal());
    }
}

class Graph {
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

class BFSSolution2 {
    private final List<List<Integer>> graph;
    private final int nodes;

    public BFSSolution2(Graph graph) {
        this.graph = graph.getAdjacencyList();
        this.nodes = graph.getNodes();
    }

    // BFS traversal from a single node.
    public List<Integer> bfsTraversal(int startNode, boolean[] visited) {
        List<Integer> result = new ArrayList<>();
        Queue<Integer> exploreQueue = new LinkedList<>();

        if (startNode < 0 || startNode >= nodes) {
            throw new IllegalArgumentException("Invalid start node index.");
        }

        if (visited[startNode]) return Collections.emptyList(); // To avoid redundant traversal.

        exploreQueue.offer(startNode);
        visited[startNode] = true;

        while (!exploreQueue.isEmpty()) {
            int node = exploreQueue.poll();
            result.add(node);

            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    exploreQueue.offer(neighbor);
                    visited[neighbor] = true;
                }
            }
        }

        return result;
    }

    public List<Integer> bfsTraversal(int startNode) {
        boolean[] visited = new boolean[nodes];
        return bfsTraversal(startNode, visited);
    }

    // Handles disconnected graphs.
    public List<Integer> bfsFullTraversal() {
        boolean[] visited = new boolean[nodes];
        List<Integer> fullResult = new ArrayList<>();

        for (int i = 0; i < nodes; i++) {
            fullResult.addAll(bfsTraversal(i, visited));
        }

        return fullResult;
    }
}
