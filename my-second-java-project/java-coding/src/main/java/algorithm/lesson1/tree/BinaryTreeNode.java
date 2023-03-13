package algorithm.lesson1.tree;

/**
 * @author TomAndersen
 */
public class BinaryTreeNode<K, V> extends TreeNode<K, V> {
    K key;
    V val;
    BinaryTreeNode<K, V> left, right;
}
