package topics.graph;

/*
There is an undirected star graph consisting of n nodes labeled from 1 to n.
A star graph is a graph where there is one center node and exactly n - 1
edges that connect the center node with every other node.

You are given a 2D integer array edges where each edges[i] = [ui, vi]
indicates that there is an edge between the nodes ui and vi. Return the center of the given star graph.

Example 1:
Input: edges = [[1,2],[2,3],[4,2]]
Output: 2
Explanation: As shown in the figure above, node 2 is connected to every other node, so 2 is the center.

Example 2:
Input: edges = [[1,2],[5,1],[1,3],[1,4]]
Output: 1
 */

//leetCode
public class FindCenterOfStarGraph {

    /*
    Initial approach - count the  edges,  return the edge count that exists the most
     */

    public int findCenter(int[][] edges) {

        int[] count = new int[edges.length + 2];

        for (int[] edge : edges) {
            count[edge[0]]++;
            count[edge[1]]++;
        }

        for (int i = 0; i < count.length; i++) {
            if  (count[i] == edges.length) {
                return i;
            }
        }

        return -1;
    }

    /*
    Using the problem statement we can understand that the center must exist for every edge
    We only need to check the first two nodes because the center must exist there
     */

    public int findCenter2(int[][] edges) {

        return edges[0][0] == edges[1][0] ||
                edges[0][0] == edges[1][1] ?
                edges[0][0] : edges[0][1];
    }

}
