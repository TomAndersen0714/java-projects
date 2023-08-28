package algorithm.practice.leetcode;

import java.util.*;

/**
 * 102. Binary Tree Level Order Traversal: https://leetcode.com/problems/binary-tree-level-order-traversal/
 * <p>
 * tags: medium, tree, bfs
 *
 * @author TomAndersen
 */
public class LeetCode102 {
}


/**
 * BFS
 * TC: O(n), SC: O(n)
 */
class LeetCode102_1 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        // exclude boundary situation
        if (root == null) {
            return new ArrayList<>();
        }

        // iterate all nodes by BFS
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> levelNodes = new ArrayList<>();
            TreeNode node;

            for (int i = 0; i < levelSize; i++) {
                node = queue.poll();
                if (node != null) {
                    levelNodes.add(node.val);
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
            }
            res.add(levelNodes);
        }

        // return
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;
        System.out.println(Arrays.toString(new LeetCode102_1().levelOrder(root).toArray()));

        root = new TreeNode(1);
        System.out.println(Arrays.toString(new LeetCode102_1().levelOrder(root).toArray()));

        root = null;
        System.out.println(Arrays.toString(new LeetCode102_1().levelOrder(root).toArray()));
    }
}
