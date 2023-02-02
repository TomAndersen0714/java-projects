package algorithm.basic.sort;

import utils.Utils;

import java.util.Arrays;


public class QuickSort {
    public static void main(String[] args) {
        for (int i = 0; i <= 20; i++) {
            int[] a = Utils.randomArrayInt(10, 50);
            int[] b = Arrays.copyOf(a, a.length);
            System.out.println(Arrays.toString(a));

            // test
            QuickSort2_1.sort(a);
            Arrays.sort(b);
            System.out.println(Arrays.toString(b));

            if (!Arrays.equals(a, b)) {
                System.out.println(Arrays.toString(a));
                System.out.println("Error");
                break;
            }
        }
    }
}


// 1. 左右搜索交换法: 递归, 哨兵, 左右搜索, 交换, 切分
class QuickSort1 {
    public static void sort(int[] a) {
        if (a == null || a.length == 0) return;
        sort(a, 0, a.length - 1);
    }

    public static void sort(int[] a, int start, int end) {
        if (a == null || a.length == 0) return;
        if (start >= end || start < 0) return;

        int p = partition(a, start, end);
        sort(a, start, p - 1);
        sort(a, p + 1, end);
    }

    private static int partition(int[] a, int start, int end) {
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
}


// 1.1 左右搜索交换法的变式写法
class QuickSort1_1 {
    public static void sort(int[] a) {
        if (a == null || a.length == 0) return;
        sort(a, 0, a.length - 1);
    }

    public static void sort(int[] a, int start, int end) {
        if (a == null || a.length == 0) return;
        if (start >= end || start < 0) return;

        int s = start, sentry = a[s];
        int i = start, j = end, tmp;

        while (i < j) {
            while (a[j] >= sentry && i < j) j--;
            while (a[i] <= sentry && i < j) i++;

            // swap
            tmp = a[j];
            a[j] = a[i];
            a[i] = tmp;
        }

        a[s] = a[i];
        a[i] = sentry;

        sort(a, start, i - 1);
        sort(a, i + 1, end);
    }
}

// 2. 左右搜索覆盖法: 递归, 哨兵, 左右搜索, 覆盖, 切分
class QuickSort2 {
    public static void sort(int[] a) {
        if (a == null || a.length == 0) return;
        sort(a, 0, a.length - 1);
    }

    public static void sort(int[] a, int start, int end) {
        if (a == null || a.length == 0) return;
        if (start >= end || start < 0) return;

        int p = partition(a, start, end);
        sort(a, start, p - 1);
        sort(a, p + 1, end);
    }

    private static int partition(int[] a, int start, int end) {
        int sentry = a[start];
        int i = start, j = end;

        while (i < j) {
            while (a[j] >= sentry && i < j) j--;
            a[i] = a[j];
            while (a[i] <= sentry && i < j) i++;
            a[j] = a[i];
        }
        a[i] = sentry;
        return i;
    }

}


class QuickSort2_1 {
    public static void sort(int[] a) {
        if (a == null || a.length == 0) return;
        sort(a, 0, a.length - 1);
    }

    public static void sort(int[] a, int start, int end) {
        if (a == null || a.length == 0) return;
        if (start >= end || start < 0) return;

        int sentry = a[start];
        int i = start, j = end;

        while (i < j) {
            while (a[j] >= sentry && i < j) j--;
            a[i] = a[j];
            while (a[i] <= sentry && i < j) i++;
            a[j] = a[i];
        }

        a[i] = sentry;

        sort(a, start, i - 1);
        sort(a, i + 1, end);
    }
}