package algorithm.lesson1.array.sort;

/**
 * 堆(Heap):
 * 一般情况下, 我们常说的"堆"都特指"二叉堆", 二叉堆也是一种完全二叉树, 当然也有多叉堆.
 * 堆中的元素的主要操作是下沉(sink)和上浮(swim), 基于这两种操作能够实现对数级别
 * 的删除最大(最小)元素, 以及插入元素的操作, 实现局部有序, 因此堆的一个经典应用
 * 就是用于实现优先队列.
 * <p>
 * 堆排序(Heap Sort): 堆排序是一种基于堆的下沉(sink)操作实现的排序算法.
 * 堆排序主要分为两个步骤, 第一步是构建有序堆, 方法一是从中间节点开始, 每层自右
 * 向左, 多层自底向上, 不断下沉(sink)元素, 直到堆顶; 方法二是从首节点开始, 每层
 * 自左向右, 多层自顶向下, 不断上浮(swim)元素, 直到堆尾, 也可以构建出有序堆,
 * 但显然方法一效率更高.
 * 第二步则是通过不断输出堆顶元素, 即交换堆顶和堆尾元素, 然后将堆大小减一,
 * 然后下沉(sink)堆顶元素, 即可针对原始序列进一步排序, 随着堆越来越小,
 * 最后便会生成一个整体有序的序列.
 * <p>
 * 如果使用数组来表示堆, 则在使用数组首个元素表示的堆中, 节点 a[p] 的左右子节点为
 * a[p*2+1] 和 a[p*2+2], 其父母节点为 a[(p-1)/2]
 * 在不使用数组首个元素表示的堆中, 节点a[p] 的左右子节点为 a[p*2] 和 a[p*2+1],
 * 其父母节点为 a[p/2].
 * <p>
 * TC: O(nlog(n)), SC: O(1), unstable
 *
 * @author TomAndersen
 */
public class HeapSort {
}

/**
 * 1. 自底向上+下沉(sink)构建堆
 */
class HeapSort1 {
    public static void sort(int[] a) {
        if (a == null || a.length <= 1) return;

        int end = a.length - 1, tmp;
        // build the heap first
        for (int k = end / 2; k >= 0; k--) {
            sink(a, end, k);
        }

        while (end > 0) {
            // pop the first element, i.e. swap the first and last element
            tmp = a[0];
            a[0] = a[end];
            a[end] = tmp;

            // delete the last element and re-build the heap
            end--;
            sink(a, end, 0);
        }
    }

    private static void sink(int[] a, int end, int k) {
        int p = k, child, tmp;
        while (p <= end) {
            child = p * 2 + 1;
            // try to get the max child
            if (child + 1 <= end && a[child + 1] > a[child]) {
                child = child + 1;
            }

            // swap if
            if (child <= end && a[child] > a[p]) {
                // swap value
                tmp = a[p];
                a[p] = a[child];
                a[child] = tmp;

                // move the pointer
                p = child;
            }
            // break loop else
            else break;
        }
    }
}


/**
 * 1.1. 自底向上+下沉(sink)构建堆+支持任意范围构建堆
 */
class HeapSort1_1 {
    public static void sort(int[] a) {
        if (a == null || a.length <= 1) return;
        sort(a, 0, a.length - 1);
    }

    public static void sort(int[] a, int start, int end) {
        if (a == null || a.length <= 1) return;
        if (start >= end || start < 0) return;

        // build the heap
        for (int i = start + (end - start) / 2 - 1; i >= start; i--) {
            sink(a, start, end, i);
        }

        // pop and re-build the heap
        int tmp;
        while (end > start) {
            // swap
            tmp = a[start];
            a[start] = a[end];
            a[end] = tmp;

            // pop and re-build sink
            end--;
            sink(a, start, end, 0);
        }
    }

    private static void swim(int[] a, int start, int k) {
        int cursor = k, p = (cursor - start) / 2 + start, tmp;
        while (p >= start && a[p] < a[cursor]) {
            // swap
            tmp = a[p];
            a[p] = a[cursor];
            a[p] = tmp;

            // continue
            cursor = p;
            p = (cursor - start) / 2 + start;
        }
    }

    private static void sink(int[] a, int start, int end, int k) {
        int cursor = k, child = (cursor - start) * 2 + start + 1, tmp;
        while (child <= end) {
            // get the max child
            if (child + 1 <= end && a[child + 1] > a[child]) {
                child++;
            }

            // swap if
            if (a[cursor] < a[child]) {
                // swap
                tmp = a[cursor];
                a[cursor] = a[child];
                a[child] = tmp;

                // move the two pointer
                cursor = child;
                child = (cursor - start) * 2 + start + 1;
            }
            // break else
            else break;
        }
    }
}


/**
 * 2. 自顶向下+上浮(swim)构建堆
 * NOTE: 此方法效率和复杂度都不如方法1, 于此仅作练习
 */
class HeapSort2 {
    public static void sort(int[] a) {
        if (a == null || a.length <= 1) return;
        int end = a.length - 1, tmp;

        // 1. build the heap into ordered by swimming
        for (int i = 0; i <= end; i++) {
            swim(a, i);
        }

        // 2. pop element and re-build the heap by sinking
        while (end > 0) {
            // swap
            tmp = a[end];
            a[end] = a[0];
            a[0] = tmp;

            // pop
            end--;
            sink(a, end, 0);
        }
    }

    private static void swim(int[] a, int k) {
        int cursor = k, parent = (cursor - 1) / 2, tmp;
        while (parent >= 0 && a[parent] < a[cursor]) {
            // swap
            tmp = a[parent];
            a[parent] = a[cursor];
            a[cursor] = tmp;

            // move pointer
            cursor = parent;
            parent = (cursor - 1) / 2;
        }
    }

    private static void sink(int[] a, int end, int k) {
        int cursor = k, child = cursor * 2 + 1, tmp;
        while (child <= end) {
            // get the max child
            if (child + 1 <= end && a[child] < a[child + 1]) {
                child++;
            }
            // swap if
            if (a[cursor] < a[child]) {
                // swap value
                tmp = a[cursor];
                a[cursor] = a[child];
                a[child] = tmp;

                // move pointer
                cursor = child;
                child = cursor * 2 + 1;
            }
            // break else
            else break;
        }
    }
}