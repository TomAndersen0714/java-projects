package algorithm.lesson1.tree;

/**
 * @author TomAndersen
 */
public class TreeNode<K, V> extends Node<K, V> {
    K key;
    V val;
    TreeNode<K, V> left, right;
}
