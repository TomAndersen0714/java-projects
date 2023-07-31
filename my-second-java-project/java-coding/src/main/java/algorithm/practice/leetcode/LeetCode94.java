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
 * DFS recursion
 * TC: O(n), SC: O(n)
 */
class LeetCode94_1 {
    public List<Integer> inorderTraversal(TreeNode root) {
        // exclude boundary condition
        if (root == null) {
            return new ArrayList<>();
        }

        // recursion
        List<Integer> inorderPath = new ArrayList<>();
        inorderRecursionHelper(inorderPath, root);

        // return
        return inorderPath;
    }

    private void inorderRecursionHelper(List<Integer> inorderPath, TreeNode node) {
        if (node != null) {
            // visit left subtree
            if (node.left != null) {
                inorderRecursionHelper(inorderPath, node.left);
            }
            // visit current node
            inorderPath.add(node.val);
            // visit right subtree
            if (node.right != null) {
                inorderRecursionHelper(inorderPath, node.right);
            }
        }
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
 * DFS iterating using stack
 * TC: O(n), SC: O(n)
 */
class LeetCode94_2 {

    public List<Integer> inorderTraversal(TreeNode root) {
        // exclude boundary situation
        if (root == null) {
            return new ArrayList<>();
        }


        // iterate using stack
        List<Integer> inorderPath = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cursor = root;

        // initial stack
        while (cursor != null) {
            stack.push(cursor);
            cursor = cursor.left;
        }

        // process all nodes in stack using same operation
        while (!stack.empty()) {
            // pop and visit node
            cursor = stack.pop();
            inorderPath.add(cursor.val);

            // move cursor to the right child node of current node
            if (cursor.right != null) {
                cursor = cursor.right;

                // push current node and all left child nodes of current node into stack
                while (cursor != null) {
                    stack.push(cursor);
                    cursor = cursor.left;
                }
            }
        }

        // return
        return inorderPath;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.right = node2;
        node2.left = node3;
        System.out.println(new LeetCode94_2().inorderTraversal(node1).toString());
    }
}
