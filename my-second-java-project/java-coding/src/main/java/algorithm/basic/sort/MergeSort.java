package algorithm.basic.sort;

import java.util.Arrays;

// 归并排序(Merge Sort):
// 归并排序是分治(Divide and Conquer, DC)思想的一个典型例子之一, 其主要思路是
// 将一个数组递归地分成两半分别排序, 然后将结果归并起来.
// 特点是最好, 最坏和平均的时间开销都相同, 且与nlog(n)成正比, 缺陷在于额外空间占用与n成正比.

// TC: O(nlog(n)), SC: O(n), stable
public class MergeSort {
}


// 1. 自顶向下归并排序: for 循环写法
class MergeSort1 {
    public static void sort(int[] a) {
        if (a == null || a.length <= 1) return;
        int[] help = new int[a.length];
        sort(a, 0, a.length - 1, help);
    }

    private static void sort(int[] a, int start, int end, int[] help) {
        if (a == null || a.length <= 1) return;
        if (start >= end || start < 0) return;

        int mid = start + (end - start) / 2;
        sort(a, start, mid, help);
        sort(a, mid + 1, end, help);

        merge(a, start, mid, end, help);
    }

    private static void merge(int[] a, int start, int mid, int end, int[] help) {
        int i = start, j = mid + 1;
        for (int p = start; p <= end; p++) {
            help[p] = a[p];
        }

        for (int p = start; p <= end; p++) {
            if (j > end) a[p] = help[i++];
            else if (i > mid) a[p] = help[j++];
            else if (help[i] <= help[j]) a[p] = help[i++];
            else a[p] = help[j++];
        }
    }
}

// 1.1 自顶向下归并排序: while 循环写法
class MergeSort1_1 {

    public static void sort(int[] a) {
        if (a == null || a.length <= 1) return;

        int[] help = new int[a.length];
        sort(a, 0, a.length - 1, help);
    }

    private static void sort(int[] a, int start, int end, int[] help) {
        if (a == null || a.length <= 1) return;
        if (start >= end || start < 0) return;

        int mid = start + (end - start) / 2;
        sort(a, start, mid, help); // 注意数组首尾索引要和Merge参数列表含义对应
        sort(a, mid + 1, end, help);

        merge(a, start, mid, end, help);
    }

    private static void merge(int[] a, int start, int mid, int end, int[] help) {
        int i = start, j = mid + 1, p = start;

        // 复制已经排序好的两个子数组
        for (int x = start; x <= end; x++) {
            help[x] = a[x];
        }

        // 如果左右都没空, 则取两者最小
        while (i <= mid && j <= end) {
            if (help[i] <= help[j]) a[p++] = help[i++];
            else a[p++] = help[j++];
        }

        // 如果右耗尽, 则左排空
        while (i <= mid) a[p++] = help[i++];
        // 如果左耗尽, 则右排空
        while (j <= end) a[p++] = help[j++];
    }
}


// 2. 自底向上的归并排序
class MergeSort2 {
    public static void sort(int[] a) {
        if (a == null || a.length <= 1) return;
        int[] help = new int[a.length];
        sort(a, 0, a.length - 1, help);
    }

    private static void sort(int[] a, int start, int end, int[] help) {
        if (a == null || a.length <= 1) return;
        if (start >= end || start < 0) return;

        // todo
    }

    private static void merge(int[] a, int start, int mid, int end, int[] help) {
        for (int p = start; p <= end; p++) {
            help[p] = a[p];
        }

        int i = start, j = mid + 1, p = start;
        while (i <= mid && j <= end) {
            if (help[i] <= help[j]) a[p++] = help[i++];
            else a[p++] = help[j++];
        }

        while (i <= mid) a[p++] = help[i++];
        while (j <= end) a[p++] = help[j++];
    }
}


