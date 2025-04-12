package dataStructures.graphs;

import java.util.*;

public class _3_DFSUsingAdjacencyMatrix {
    public static void main(String... args) {
        int[][] graph = {
                {0, 1, 1, 0, 0},
                {0, 0, 1, 1, 1},
                {0, 0, 0, 0, 1},
                {0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0}
        };

        int startNode = 0;
        DFSSolution solution = new DFSSolution(graph);

        System.out.printf("DFS traversal from node %d: %s%n", startNode, solution.dfsTraversal(startNode));
        System.out.printf("\nDFS full traversal : %s", solution.dfsFullTraversal());
    }
}

class DFSSolution {
    private final int[][] graph;
    private final int nodes;

    public DFSSolution(int[][] graph) {
        this.graph = graph;
        this.nodes = graph.length;
    }

    // DFS Traversal from a single node
    private List<Integer> performDFS(int startNode, boolean[] visited) {
        List<Integer> result = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(startNode);
        visited[startNode] = true;

        while (!stack.isEmpty()) {
            int node = stack.pop();
            result.add(node);

            // Traverse adjacent nodes in reverse order to maintain natural DFS order
            for (int i = nodes - 1; i >= 0; i--) {
                if (graph[node][i] == 1 && !visited[i]) {
                    stack.push(i);
                    visited[i] = true;
                }
            }
        }
        return result;
    }

    public List<Integer> dfsTraversal(int startNode) {
        boolean[] visited = new boolean[nodes];
        return performDFS(startNode, visited);
    }

    // DFS Full Traversal for disconnected graphs
    public List<Integer> dfsFullTraversal() {
        List<Integer> fullResult = new ArrayList<>();
        boolean[] visited = new boolean[nodes];

        for (int i = 0; i < nodes; i++) {
            if (!visited[i]) {
                fullResult.addAll(performDFS(i, visited));
            }
        }
        return fullResult;
    }
}
