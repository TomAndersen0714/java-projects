package algorithm.practice.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 94. Binary Tree Inorder Traversal: https://leetcode.com/problems/binary-tree-inorder-traversal/
 * <p>
 * tags: easy, tree, dfs
 *
 * @author TomAndersen
 */
public class LeetCode94 {
}

/**
 * DFS iterating using stack
 * TC: O(n), SC: O(n)
 */
class LeetCode94_1 {

    public List<Integer> inorderTraversal(TreeNode root) {
        // exclude boundary situation
        if (root == null) {
            return new ArrayList<>();
        }

        // dfs iterate
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> inOrderPath = new ArrayList<>();
        TreeNode cursor = root;
        // iterate
        while (cursor != null || !stack.empty()) {
            // add all left children nodes into stack
            while (cursor != null) {
                stack.push(cursor);
                cursor = cursor.left;
            }

            // pop and visit current node
            cursor = stack.pop();
            inOrderPath.add(cursor.val);
            // move to the right
            cursor = cursor.right;
        }

        // return
        return inOrderPath;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.right = node2;
        node2.left = node3;
        System.out.println(new LeetCode94_1().inorderTraversal(node1).toString());
    }
}

/**
 * DFS recursion
 * TC: O(n), SC: O(n)
 */
class LeetCode94_2 {

}