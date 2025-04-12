package dataStructures.graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class _4_DFSUsingAdjacencyList {

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
        DFSSolution2 solution = new DFSSolution2(graph);

        System.out.printf("DFS traversal from node %d: %s%n", startNode, solution.dfsTraversal(startNode));
        System.out.printf("\nDFS full traversal : %s", solution.dfsFullTraversal());
    }
}

class DFSSolution2 {
    private final int nodes;
    private final Graph graph;

    public DFSSolution2(Graph graph) {
        this.graph = graph;
        nodes = graph.getNodes();
    }

    private List<Integer> performDFS(int startNode, boolean[] visited) {
        List<Integer> result = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(startNode);
        visited[startNode] = true;

        while (!stack.isEmpty()) {
            int node = stack.pop();
            result.add(node);
            List<Integer> neighbours = graph.getAdjacencyList().get(node);

            // Traverse adjacent nodes in reverse order to maintain natural DFS order
            for (int i = neighbours.size() - 1; i >= 0; i--) {
                int neighbour = neighbours.get(i);
                if (!visited[neighbour]) {
                    stack.push(neighbour);
                    visited[neighbour] = true;
                }
            }
        }

        return result;
    }

    // DFS traversal from a single node.
    public List<Integer> dfsTraversal(int startNode) {
        boolean[] visited = new boolean[nodes];
        return performDFS(startNode, visited);
    }

    //DFS full traversal for disconnected graphs.
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

