package leetcode;

import java.util.*;

/**
 * 210. Course Schedule II: https://leetcode.com/problems/course-schedule-ii/
 * <p>
 * tags: medium, graph, bfs, dfs
 *
 * @author TomAndersen
 */
public class LeetCode210 {
}


/**
 * Topological Sort: adjacency list(list.list) + queue
 * TC: O(m+n), SC: O(m+n)
 */
class LeetCode210_1 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // exclude boundary situation
        if (numCourses <= 0) {
            return new int[]{};
        }

        // solve problem
        int[] res = new int[numCourses];
        List<List<Integer>> adjList = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        int[] inDegrees = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : prerequisites) {
            adjList.get(edge[1]).add(edge[0]);
            inDegrees[edge[0]] += 1;
        }

        // level traversal in topological order
        int cursor = 0;
        for (int i = 0; i < numCourses; i++) {
            if (inDegrees[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int point = queue.poll();
            for (int nextPoint : adjList.get(point)) {
                inDegrees[nextPoint] -= 1;
                if (inDegrees[nextPoint] == 0) {
                    queue.offer(nextPoint);
                }
            }
            res[cursor] = point;
            cursor += 1;
        }

        // return
        if (cursor != numCourses) {
            res = new int[]{};
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new LeetCode210_1().findOrder(2, new int[][]{{1, 0}})));
        System.out.println(Arrays.toString(new LeetCode210_1().findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}})));
        System.out.println(Arrays.toString(new LeetCode210_1().findOrder(1, new int[][]{})));
    }
}


/**
 * DFS Recursion: adjacency list + dfs
 * TC: O(m+n), SC: O(m+n)
 */
class LeetCode210_2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // exclude boundary situation
        if (numCourses <= 0) {
            return new int[]{};
        }

        // solve problem
        ArrayList<Integer> path = new ArrayList<>();
        List<List<Integer>> adjList = new ArrayList<>();
        int[] states = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : prerequisites) {
            adjList.get(edge[0]).add(edge[1]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!dfsRecursion(adjList, path, states, i)) {
                return new int[]{};
            }
        }

        // return
        int[] res = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            res[i] = path.get(i);
        }
        return res;
    }

    private boolean dfsRecursion(List<List<Integer>> adjList, List<Integer> path, int[] states, int point) {
        if (states[point] == 2) {
            return true;
        }
        else if (states[point] == 1) {
            return false;
        }
        else {
            states[point] = 1;
            for (int nextPoint : adjList.get(point)) {
                if (!dfsRecursion(adjList, path, states, nextPoint)) {
                    return false;
                }
            }
            states[point] = 2;
            path.add(point);
            return true;
        }
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(new LeetCode210_2().findOrder(2, new int[][]{{1, 0}})));
        System.out.println(Arrays.toString(new LeetCode210_2().findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}})));
        System.out.println(Arrays.toString(new LeetCode210_2().findOrder(1, new int[][]{})));
    }
}