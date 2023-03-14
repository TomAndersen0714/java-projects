package algorithm.lesson1.tree;

/**
 * @author TomAndersen
 */
public class ThreeTreeNode<K, V> extends Node<K, V> {
    K key;
    V val;
    ThreeTreeNode<K, V> left, mid, right;
}
