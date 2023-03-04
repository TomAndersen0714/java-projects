package algorithm.lesson1.tree;

import algorithm.lesson1.tree.TreeNode.BinaryTreeNode;

/**
 * Binary Search Tree(BST).
 * https://en.wikipedia.org/wiki/Binary_search_tree
 * <p>
 * BST中序遍历结果唯一, 是所有节点关键字的一个有序序列,
 * 因此对于BST而言, 只需要提供前序或后序序列, 就可以建立对应的二叉树.
 *
 * @author TomAndersen
 */
public class BinarySearchTree<E> {

    BinaryTreeNode root;

    public BinarySearchTree(E[] inOrder, E[] preOrder) {

    }

    boolean add(E element) {
        return false;
    }

}
