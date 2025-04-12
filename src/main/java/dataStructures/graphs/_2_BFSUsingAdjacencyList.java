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

class BFSSolution2 {
    private final List<List<Integer>> graph;
    private final int nodes;

    public BFSSolution2(Graph graph) {
        this.graph = graph.getAdjacencyList();
        this.nodes = graph.getNodes();
    }

    // BFS traversal from a single node.
    private List<Integer> performBFS(int startNode, boolean[] visited) {
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
        return performBFS(startNode, visited);
    }

    // Handles disconnected graphs.
    public List<Integer> bfsFullTraversal() {
        boolean[] visited = new boolean[nodes];
        List<Integer> fullResult = new ArrayList<>();

        for (int i = 0; i < nodes; i++) {
            fullResult.addAll(performBFS(i, visited));
        }

        return fullResult;
    }
}
