package algorithm.practice.leetcode;

import java.util.Arrays;

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
        int[] adjacencyList = new int[numCourses];
        // record the state of pointers, 0-not visited, 1-visiting, 2-visited
        int[] states = new int[numCourses];

        Arrays.fill(adjacencyList, -1);
        for (int[] edge : prerequisites) {
            adjacencyList[edge[0]] = edge[1];
        }

        for (int[] edge : prerequisites) {
            if (!dfsRecursion(adjacencyList, states, edge[0])) {
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
            return dfsRecursion(adjacencyList, states, adjacencyList[x]);
        }
    }


    public static void main(String[] args) {

    }
}