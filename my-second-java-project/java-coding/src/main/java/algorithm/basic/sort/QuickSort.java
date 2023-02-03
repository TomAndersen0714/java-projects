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
            QuickSort3_1.sort(a);
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


// 1. 左右指针交换法
// Tips: 递归, 哨兵, 左右搜索, 交换, 切分, 适合线性表和双向链表
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
            // 不论是升序还是降序排序, 只要哨兵在左边, 则先从右边开始搜索, 反之, 如果哨兵在右边, 则先从左边开始搜索
            // 核心在于只需要保证, 当遍历完数组时都无法找到满足条件的元素, 双指针指向的都是哨兵的最终位置即可
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


// 1.1. 左右指针交换法-合并写法
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

// 2. 左右指针交替覆盖法
// Tips: 递归, 哨兵, 相向左右指针, 覆盖, 切分, 适合线性表和双向链表
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

// 2.1. 左右指针交替覆盖法-合并写法
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


// 3. 快慢指针交换法
// Tips: 递归, 哨兵, 同向快慢指针, 适合链表
class QuickSort3 {
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
        final int s = start, sentry = a[s];
        int i = end, j = i, tmp;

        while (j > s) {
            // 用快指针去搜索需要右移的元素, 慢指针搜索需要左移的元素
            // 不论是升序还是降序排序, 只要哨兵在左边, 则先从右边开始搜索, 反之, 如果哨兵在右边, 则先从左边开始搜索
            while (a[j] >= sentry && j > s) j--;
            while (a[j] <= sentry && j > s) j--; // 搜索需要右移的元素
            while (a[i] >= sentry && i > s) i--; // 搜索需要左移的元素

            // swap
            tmp = a[j];
            a[j] = a[i];
            a[i] = tmp;
        }
        return i;
    }
}


// 3.1. 快慢指针交换法-合并写法
class QuickSort3_1 {
    public static void sort(int[] a) {
        if (a == null || a.length == 0) return;
        sort(a, 0, a.length - 1);
    }

    public static void sort(int[] a, int start, int end) {
        if (a == null || a.length == 0) return;
        if (start >= end || start < 0) return;

        final int s = start, sentry = a[s];
        int i = end, j = i, tmp;

        while (j > s) {
            while (a[j] >= sentry && j > s) j--;
            while (a[j] <= sentry && j > s) j--;
            while (a[i] >= sentry && i > s) i--;

            // swap
            tmp = a[j];
            a[j] = a[i];
            a[i] = tmp;
        }

        sort(a, start, i - 1);
        sort(a, i + 1, end);
    }
}


// 4. 快慢指针交替覆盖法
class QuickSort4 {
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
        // final int s = start, sentry = a[s];
        int i = end, j = i, sentry = a[i];

        while (j > start) {
            while (a[i] >= sentry && i > start) i--;
            a[j] = a[i];

            while (a[j] >= sentry && j > start) j--;
            while (a[j] <= sentry && j > start) j--;
            a[i] = a[j];
        }


        return i;
    }
}