package leetcode.problems.linkedin;

import java.util.*;

/** 261. Graph Valid Tree
 * You have a graph of n nodes labeled from 0 to n - 1.
 * You are given an integer n and a list of edges where edges[i] = [ai, bi]
 * indicates that there is an undirected edge between nodes ai and bi in the graph.
 *
 * Return true if the edges of the given graph make up a valid tree, and false otherwise.
 *
 * Example 1:
 * Input: n = 5, edges = [[0,1],[0,2],[0,3],[1,4]]
 * Output: true
 *
 * Example 2:
 * Input: n = 5, edges = [[0,1],[1,2],[2,3],[1,3],[1,4]]
 * Output: false
 *
 * Constraints:
 *     1 <= n <= 2000
 *     0 <= edges.length <= 5000
 *     edges[i].length == 2
 *     0 <= ai, bi < n
 *     ai != bi
 *     There are no self-loops or repeated edges.
 */
public class _261GraphValidTree {
    public boolean validTree(int n, int[][] edges) {

        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }

        Map<Integer, Integer> parent = new HashMap<>();
        parent.put(0, -1);
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        while (!stack.isEmpty()) {
            int node = stack.pop();
            for (int neighbour : adjacencyList.get(node)) {
                if (parent.get(node) == neighbour) {
                    continue;
                }
                if (parent.containsKey(neighbour)) {
                    return false;
                }
                stack.push(neighbour);
                parent.put(neighbour, node);
            }
        }

        return parent.size() == n;
    }
    /**********************************************************************/
    // https://leetcode.com/problems/graph-valid-tree/solution/
    class Solution {

        private List<List<Integer>> adjacencyList = new ArrayList<>();
        private Set<Integer> seen = new HashSet<>();


        public boolean validTree(int n, int[][] edges) {

            if (edges.length != n - 1) return false;

            // Make the adjacency list.
            for (int i = 0; i < n; i++) {
                adjacencyList.add(new ArrayList<>());
            }
            for (int[] edge : edges) {
                adjacencyList.get(edge[0]).add(edge[1]);
                adjacencyList.get(edge[1]).add(edge[0]);
            }

            // Carry out depth first search.
            dfs(0);
            // Inspect result and return the verdict.
            return seen.size() == n;
        }

        public void dfs(int node) {
            if (seen.contains(node)) return;
            seen.add(node);
            for (int neighbour : adjacencyList.get(node)) {
                dfs(neighbour);
            }
        }
    }
}
