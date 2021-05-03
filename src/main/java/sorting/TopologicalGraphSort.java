package sorting;

import java.util.*;

/*

Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices
such that for every directed edge u v, vertex u comes before v in the ordering.
Topological Sorting for a graph is not possible if the graph is not a DAG.

 */

public class TopologicalGraphSort {

    // No. of vertices
    private int V;

    // Adjacency List as ArrayList of ArrayList's
    private ArrayList<ArrayList<Integer>> adj;

    // Constructor
    TopologicalGraphSort(int v) {
        V = v;
        adj = new ArrayList<ArrayList<Integer> >(v);
        for (int i = 0; i < v; ++i)
            adj.add(new ArrayList<Integer>());
    }

    // Function to add an edge into the graph
    private void addEdge(int v, int w) {
        adj.get(v).add(w);
    }

    // A recursive function used by topologicalSort
    private void topologicalSortUtil(int v, boolean visited[], Stack<Integer> stack) {
        // Mark the current node as visited.
        visited[v] = true;
        Integer i;

        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> it = adj.get(v).iterator();
        while (it.hasNext()) {
            i = it.next();
            if (!visited[i]) {
                topologicalSortUtil(i, visited, stack);
            }
        }

        // Push current vertex to stack which stores result
        stack.push(v);
    }

    // The function to do Topological Sort. It uses recursive topologicalSortUtil()
    private void topologicalSort() {
        Stack<Integer> stack = new Stack<Integer>();

        // Mark all the vertices as not visited
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            visited[i] = false;
        }

        // Call the recursive helper function to store Topological Sort starting from all vertices one by one
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                topologicalSortUtil(i, visited, stack);
            }
        }

        // Print contents of stack
        while (!stack.empty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }

    // Driver code
    public static void main(String[] args)
    {
        // Create a graph given in the above diagram
        TopologicalGraphSort t = new TopologicalGraphSort(6);
        t.addEdge(5, 2);
        t.addEdge(5, 0);
        t.addEdge(4, 0);
        t.addEdge(4, 1);
        t.addEdge(2, 3);
        t.addEdge(3, 1);

        System.out.println("Following is a Topological "
                + "sort of the given graph");
        // Function Call
        t.topologicalSort();
    }

}
