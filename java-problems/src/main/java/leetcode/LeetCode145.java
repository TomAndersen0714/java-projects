package leetcode;

import java.util.*;

/**
 * 145. Binary Tree Postorder Traversal: https://leetcode.com/problems/binary-tree-postorder-traversal/
 * <p>
 * tags: easy, tree, DFS
 *
 * @author TomAndersen
 */
public class LeetCode145 {
}

/**
 * DFS Recursion
 * TC: O(n), SC: O(n)
 */
class LeetCode145_1 {
    public List<Integer> postorderTraversal(TreeNode root) {
        // exclude boundary situation
        if (root == null) {
            return new ArrayList<>();
        }

        // handle
        List<Integer> postorderPath = new ArrayList<>();
        postorderRecursion(root, postorderPath);

        // return
        return postorderPath;
    }

    private void postorderRecursion(TreeNode root, List<Integer> path) {
        if (root != null) {
            postorderRecursion(root.left, path);
            postorderRecursion(root.right, path);
            path.add(root.val);
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(1);
        treeNode1.right = treeNode2;
        treeNode2.left = treeNode3;
        System.out.println(new LeetCode145_1().postorderTraversal(treeNode1).toString());
        System.out.println(new LeetCode145_1().postorderTraversal(null).toString());
        System.out.println(new LeetCode145_1().postorderTraversal(treeNode4).toString());
    }
}

/**
 * DFS iteration using stack and linked list.
 * TC: O(n), SC: O(n)
 */
class LeetCode145_2 {
    public List<Integer> postorderTraversal(TreeNode root) {
        // exclude boundary situation
        if (root == null) {
            return new ArrayList<>();
        }

        // iterate using stack and linked list
        LinkedList<Integer> postorderPath = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cursor = root;

        // initial stack
        stack.push(root);

        // iterate all nodes in stack using same operation
        while (!stack.empty()) {
            // pop and visit top node
            cursor = stack.pop();
            postorderPath.addFirst(cursor.val);

            // push the left and right node into stack
            if (cursor.left != null) {
                stack.push(cursor.left);
            }
            if (cursor.right != null) {
                stack.push(cursor.right);
            }
        }

        // return
        return postorderPath;
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(1);
        treeNode1.right = treeNode2;
        treeNode2.left = treeNode3;
        System.out.println(new LeetCode145_2().postorderTraversal(treeNode1).toString());
        System.out.println(new LeetCode145_2().postorderTraversal(null).toString());
        System.out.println(new LeetCode145_2().postorderTraversal(treeNode4).toString());
    }
}
