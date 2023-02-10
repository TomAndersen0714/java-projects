package algorithm.basic.sort;

/**
 * 堆(Heap):
 * 一般情况下, 我们常说的"堆"都特指"二叉堆", 二叉堆也是一种完全二叉树, 当然也有多叉堆.
 * 堆中的元素的主要操作是下沉(sink)和上浮(swim), 基于这两种操作能够实现对数级别
 * 的删除最大(最小)元素, 以及插入元素的操作, 实现局部有序, 因此堆的一个经典应用
 * 就是用于实现优先队列.
 * <p>
 * 堆排序(Heap Sort):
 * 一种基于堆的下沉(sink)操作实现的排序算法.
 * 堆排序主要分为两个步骤, 第一步是构建一个初始的有序堆, 即从中间节点
 * 开始, 每层自右向左, 多层自底向上, 不断下沉(sink)元素, 直到堆顶;
 * 第二步则是通过不断输出堆顶元素, 即交换堆顶和堆尾元素, 然后将堆大小减一,
 * 然后下沉(sink)堆顶元素, 即可针对原始序列进一步排序, 随着堆越来越小,
 * 最后便会生成一个整体有序的序列.
 * TC: O(nlog(n)), SC: O(1), unstable
 *
 * @author TomAndersen
 */
public class HeapSort {
    public static void sort(int[] a) {
        if (a == null || a.length <= 1) return;

        int len = a.length, tmp;
        // build the heap first
        for (int k = len / 2 - 1; k >= 0; k--) {
            sink(a, len, k);
        }

        while (len > 1) {
            // pop the first element, i.e. swap the first and last element
            tmp = a[0];
            a[0] = a[len - 1];
            a[len - 1] = tmp;

            // delete the last element and re-build the heap
            len--;
            sink(a, len, 0);
        }
    }

    private static void sink(int[] a, int len, int k) {
        int p = k, child, tmp;
        while (p < len) {
            child = p * 2 + 1;
            // try to get the max child
            if (child + 1 < len && a[child + 1] > a[child]) {
                child = child + 1;
            }

            // compare parent and child
            if (child < len && a[child] > a[p]) {
                // swap parent and child
                tmp = a[p];
                a[p] = a[child];
                a[child] = tmp;

                // continue
                p = child;
            }
            // break loop
            else break;
        }
    }
}


class HeapSort1_1 {
    public static void sort(int[] a) {
        if (a == null || a.length <= 1) return;
        sort(a, 0, a.length - 1);
    }

    public static void sort(int[] a, int start, int end) {
        if (a == null || a.length <= 1) return;
        if (start >= end || start < 0) return;

        // build the heap
        int len = end - start + 1;

        // pop and re-build the heap
    }

    private void swim(int[] a, int start, int k) {
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

    private void sink(int[] a, int start, int end, int k) {
        int cursor = k, left = (cursor - start) * 2 + start + 1, tmp;
        while (left <= end) {
            // get the max child
            if (left + 1 <= end && a[left + 1] > a[left]) {
                left++;
            }

            if (a[left] > a[cursor]) {
                // swap
                tmp = a[left];
                a[left] = a[cursor];
                a[cursor] = tmp;

                // continue
                cursor = left;
                left = (cursor - start) * 2 + start + 1;
            }
            else break;
        }
    }
}
