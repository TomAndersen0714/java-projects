package algorithm.basic.sort;

/**
 * 堆排序(Heap Sort):
 * 一般情况下, 最常见的堆是二叉堆, 同时也是一种完全二叉树, 通常会用于实现优先队列.
 * 堆中的元素的主要操作是下沉(sink)和上浮(swim), 基于这两种操作能够实现对数级别
 * 的删除最大(最小)元素, 以及插入元素的操作.
 * 堆排序(Heap Sort)则是通过不断交换堆顶和堆尾元素, 删除堆尾元素,然后下沉(sink)
 * 堆顶元素, 即可针对输入序列进行排序, 这是堆排序的核心思想.
 * TC: O(nlog(n)), SC: O(1), unstable
 *
 * @author TomAndersen
 */
public class HeapSort {
    public static void sort(int[] a) {
        if (a == null || a.length <= 1) return;
        sort(a, 0, a.length - 1);
    }

    public static void sort(int[] a, int start, int end) {
        if (a == null || a.length <= 1) return;
        if (start >= end || start < 0) return;

        // build the heap


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


class HeapSort1 {
    public static void sort(int[] a) {
        if (a == null || a.length <= 1) return;

    }

    private static void sink(int[] a, int k) {
        int p = k, N = a.length, child, tmp;
        while (p < N) {
            child = p * 2 + 1;
            if (child + 1 < N && a[child + 1] > a[child]) child = child + 1;
            if (child < N && a[child] > a[p]) {
                tmp = a[p];
                a[p] = a[child];
                a[child] = tmp;

                p = child;
            }
        }
    }
}