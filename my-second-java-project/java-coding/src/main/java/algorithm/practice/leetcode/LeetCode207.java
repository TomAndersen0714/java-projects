package algorithm.practice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 207. Course Schedule: https://leetcode.com/problems/course-schedule/
 * <p>
 * tags: medium, graph, bfs, dfs
 *
 * @author TomAndersen
 */
public class LeetCode207 {
}

/**
 * DFS recursion
 * TC: O(n), SC: O(n)
 */
class LeetCode207_1 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // exclude boundary situation
        if (numCourses == 0 || prerequisites == null || prerequisites.length == 0) {
            return true;
        }

        // solve problem
        boolean isPossible = true;

        // build graph in adjacency list, and visit all edges in the graph by DFS recursion
        HashMap<Integer, List<Integer>> outEdges = new HashMap<>();
        // record the state of pointers, 0-not visited, 1-visiting, 2-visited
        int[] states = new int[numCourses];

        for (int[] outEdge : prerequisites) {
            List<Integer> outEdgeList = outEdges.getOrDefault(outEdge[0], new ArrayList<>());
            outEdgeList.add(outEdge[1]);
            outEdges.put(outEdge[0], outEdgeList);
        }

        for (int[] edge : prerequisites) {
            if (!dfsRecursion(outEdges, states, edge[0])) {
                isPossible = false;
                break;
            }
        }

        // return result
        return isPossible;
    }

    private boolean dfsRecursion(int[] adjacencyList, int[] states, int x) {
        // if current point is not part of edge
        if (adjacencyList[x] == -1) {
            return true;
        }

        if (states[x] == 1) {
            return false;
        }
        else if (states[x] == 2) {
            return true;
        }
        else {
            // access current point
            states[x] = 1;
            if (dfsRecursion(adjacencyList, states, adjacencyList[x])) {
                states[x] = 2;
                return true;
            }
            else {
                return false;
            }
        }
    }


    public static void main(String[] args) {
        System.out.println(new LeetCode207_1().canFinish(2, new int[][]{{1, 0}}) == true);
        System.out.println(new LeetCode207_1().canFinish(2, new int[][]{{1, 0}, {0, 1}}) == false);
        System.out.println(new LeetCode207_1().canFinish(3, new int[][]{{1, 0}, {1, 2}, {0, 1}}) == false);
    }
}