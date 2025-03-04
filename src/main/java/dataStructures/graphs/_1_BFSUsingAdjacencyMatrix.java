package dataStructures.graphs;

import java.util.*;

public class _1_BFSUsingAdjacencyMatrix {
    public static void main(String... args) {
        int[][] graph = {
                {0, 1, 1, 0, 0},
                {0, 0, 1, 1, 1},
                {0, 0, 0, 0, 1},
                {0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0}
        };

        int startNode = 0;
        BFSSolution solution = new BFSSolution(graph);
        System.out.printf("BFS traversal from node %d: %s%n", startNode, solution.bfsTraversal(startNode));
        System.out.printf("\nBFS full traversal : %s", solution.bfsFullTraversal());
    }
}

class BFSSolution {
    private final int[][] graph;
    private final int nodes;

    public BFSSolution(int[][] graph) {
        this.graph = graph;
        this.nodes = graph.length;
    }

    // BFS traversal from a single node.
    public List<Integer> bfsTraversal(int startNode, boolean[] visited) {
        List<Integer> result = new ArrayList<>();
        Queue<Integer> exploreQueue = new LinkedList<>();

        if (startNode < 0 || startNode >= nodes) {
            throw new IllegalArgumentException("Invalid start node index.");
        }

        if (visited[startNode]) return Collections.emptyList(); // to avoid redundant traversal.

        exploreQueue.offer(startNode);
        visited[startNode] = true;

        while (!exploreQueue.isEmpty()) {
            int node = exploreQueue.poll();
            result.add(node);

            for (int i = 0; i < nodes; i++) {
                if (graph[node][i] == 1 && !visited[i]) {
                    exploreQueue.offer(i);
                    visited[i] = true;
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
