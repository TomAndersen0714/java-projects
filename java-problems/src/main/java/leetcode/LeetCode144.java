package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 144. Binary Tree Preorder Traversal: https://leetcode.com/problems/binary-tree-preorder-traversal/
 * tags: easy, tree, DFS
 *
 * @author TomAndersen
 */
public class LeetCode144 {
}


/**
 * DFS Recursion
 * TC: O(n), SC: O(n)
 */
class LeetCode144_1 {
    public List<Integer> preorderTraversal(TreeNode root) {
        // exclude boundary situation
        if (root == null) {
            return new ArrayList<>();
        }

        // recursion
        List<Integer> preorderPath = new ArrayList<>();
        preorderRecursion(root, preorderPath);

        return preorderPath;
    }

    private void preorderRecursion(TreeNode root, List<Integer> path) {
        if (root != null) {
            path.add(root.val);
            preorderRecursion(root.left, path);
            preorderRecursion(root.right, path);
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(1);
        treeNode1.right = treeNode2;
        treeNode2.left = treeNode3;
        System.out.println(new LeetCode144_1().preorderTraversal(treeNode1).toString());
        System.out.println(new LeetCode144_1().preorderTraversal(null).toString());
        System.out.println(new LeetCode144_1().preorderTraversal(treeNode4).toString());
    }
}


/**
 * DFS iteration using stack
 * TC: O(n), SC: O(n)
 */
class LeetCode144_2 {
    public List<Integer> preorderTraversal(TreeNode root) {
        // exclude boundary situation
        if (root == null) {
            return new ArrayList<>();
        }

        // iterate using stack
        List<Integer> preorderPath = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cursor = root;

        // initialize stack
        stack.push(root);

        // iterate
        while (!stack.isEmpty()) {
            // pop and visit node
            cursor = stack.pop();
            preorderPath.add(cursor.val);


            // push right and left
            if (cursor.right != null) {
                stack.push(cursor.right);
            }
            if (cursor.left != null) {
                stack.push(cursor.left);
            }
        }

        // return
        return preorderPath;
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(1);
        treeNode1.right = treeNode2;
        treeNode2.left = treeNode3;
        System.out.println(new LeetCode144_2().preorderTraversal(treeNode1).toString());
        System.out.println(new LeetCode144_2().preorderTraversal(null).toString());
        System.out.println(new LeetCode144_2().preorderTraversal(treeNode4).toString());
    }
}
