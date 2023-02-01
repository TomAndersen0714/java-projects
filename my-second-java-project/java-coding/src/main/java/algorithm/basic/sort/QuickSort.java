package algorithm.basic.sort;

import java.util.Arrays;


public class QuickSort {
    // ascending quick sort
    public static void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    public static void sort(int[] a, int start, int end) {
        if (start >= end || start < 0) return;

        int p = partition(a, start, end);
        sort(a, start, p - 1);
        sort(a, p + 1, end);
    }

    private static int partition(int[] a, int start, int end) {
        if (start >= end || start < 0) return 0;

        int s = start, sentry = a[s];
        int i = start, j = end, tmp;

        while (i < j) {
            // right search first when using first element on the left as sentry
            // 不论是升序还是降序排序, 只要哨兵在左边, 则从右边开始搜索, 反之, 如果哨兵在右边, 则从左边开始搜索
            // 只需要保证, 即便搜索不到任何满足条件的元素, 指针指向的是哨兵的最终位置
            while (a[j] >= sentry && i < j) j--;
            // left search then
            while (a[i] <= sentry && i < j) i++;
            if (i == j) break;

            // swap
            tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }

        // swap
        a[s] = a[i];
        a[i] = sentry;

        return i;
    }

    public static void main(String[] args) {
        int[] a = new int[]{5, 6, 6, 7, 12, 11, 22, 14, 2, 3};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
