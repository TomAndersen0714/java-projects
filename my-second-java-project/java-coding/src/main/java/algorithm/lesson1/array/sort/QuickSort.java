package algorithm.lesson1.array.sort;


// 快速排序(Quick Sort):
// 快速排序是一种分治(Divide and Conquer)的排序算法, 与归并排序(Merge Sort)
// 形成互补, 其中归并排序的递归发生在数组处理之前, 而快速排序的递归发生在数组处理之后;
// 归并排序的数组被等分后处理, 而快速排序中, 切分的位置无法事先确定, 取决于数组的内容.
// -- 算法(第4版)

// TC: O(n*log(n)) , SC: O(log(n)), unstable
public class QuickSort {
}


// 1. 左右指针-交换法
// Tips: 递归, 左右搜索, 交换, 切分, 适合线性表和双向链表
class QuickSort1 {
    public static void sort(int[] a) {
        if (a == null || a.length <= 1) return;
        sort(a, 0, a.length - 1);
    }

    public static void sort(int[] a, int start, int end) {
        if (a == null || a.length <= 1) return;
        if (start >= end || start < 0) return;

        int p = partition(a, start, end);
        sort(a, start, p - 1);
        sort(a, p + 1, end);
    }

    private static int partition(int[] a, int start, int end) {
        int s = start, pivot = a[s];
        int i = start, j = end, tmp;

        while (i < j) {
            // 不论是升序还是降序排序, 只要哨兵在左边, 则先从右边开始搜索, 反之, 如果哨兵在右边, 则先从左边开始搜索
            // 核心在于只需要保证, 当遍历完数组时都无法找到满足条件的元素, 双指针指向的都是哨兵的最终位置即可
            while (a[j] >= pivot && i < j) j--;
            while (a[i] <= pivot && i < j) i++;

            // swap
            tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }

        // swap
        a[s] = a[i];
        a[i] = pivot;

        return i;
    }
}


// 1.1. 左右指针-交换法-合并写法
class QuickSort1_1 {
    public static void sort(int[] a) {
        if (a == null || a.length <= 1) return;
        sort(a, 0, a.length - 1);
    }

    public static void sort(int[] a, int start, int end) {
        if (a == null || a.length <= 1) return;
        if (start >= end || start < 0) return;

        int s = start, pivot = a[s];
        int i = start, j = end, tmp;

        while (i < j) {
            while (a[j] >= pivot && i < j) j--;
            while (a[i] <= pivot && i < j) i++;

            // swap
            tmp = a[j];
            a[j] = a[i];
            a[i] = tmp;
        }

        a[s] = a[i];
        a[i] = pivot;

        sort(a, start, i - 1);
        sort(a, i + 1, end);
    }
}

// 2. 左右指针-交替覆盖法
// Tips: 递归, 哨兵, 相向左右指针, 覆盖, 切分, 适合线性表和双向链表
// 此方法的基准值, 同时也是哨兵值, 即初始位置固定
class QuickSort2 {
    public static void sort(int[] a) {
        if (a == null || a.length <= 1) return;
        sort(a, 0, a.length - 1);
    }

    public static void sort(int[] a, int start, int end) {
        if (a == null || a.length <= 1) return;
        if (start >= end || start < 0) return;

        int p = partition(a, start, end);
        sort(a, start, p - 1);
        sort(a, p + 1, end);
    }

    private static int partition(int[] a, int start, int end) {
        int pivot = a[start];
        int i = start, j = end;

        while (i < j) {
            while (a[j] >= pivot && i < j) j--;
            a[i] = a[j];
            while (a[i] <= pivot && i < j) i++;
            a[j] = a[i];
        }
        a[i] = pivot;
        return i;
    }

}

// 2.1. 左右指针-交替覆盖法-合并写法
// 此方法的基准值, 同时也是哨兵值, 即初始位置固定
class QuickSort2_1 {
    public static void sort(int[] a) {
        if (a == null || a.length <= 1) return;
        sort(a, 0, a.length - 1);
    }

    public static void sort(int[] a, int start, int end) {
        if (a == null || a.length <= 1) return;
        if (start >= end || start < 0) return;

        int pivot = a[start];
        int i = start, j = end;

        while (i < j) {
            while (a[j] >= pivot && i < j) j--;
            a[i] = a[j];
            while (a[i] <= pivot && i < j) i++;
            a[j] = a[i];
        }

        a[i] = pivot;

        sort(a, start, i - 1);
        sort(a, i + 1, end);
    }
}


// 3. 快慢指针-交换法
// Tips: 递归, 哨兵, 同向快慢指针, 适合链表
class QuickSort3 {
    public static void sort(int[] a) {
        if (a == null || a.length <= 1) return;
        sort(a, 0, a.length - 1);
    }

    public static void sort(int[] a, int start, int end) {
        if (a == null || a.length <= 1) return;
        if (start >= end || start < 0) return;

        int p = partition(a, start, end);
        sort(a, start, p - 1);
        sort(a, p + 1, end);
    }

    private static int partition(int[] a, int start, int end) {
        final int pivot = a[end]; // 中枢元素必须在指针检索方向的末尾
        int i = start, j = i, tmp;

        while (j < end) {
            // 用快指针去搜索需要右移的元素, 慢指针搜索需要左移的元素
            // 保持快指针右侧的元素都是基于指定元素已经排序好的(即先小后大)
            // 不论是升序还是降序排序, 只要哨兵在左边, 则先从右边开始搜索, 反之, 如果哨兵在右边, 则先从左边开始搜索
            while (a[j] <= pivot && j < end) j++; // 搜索需要左移的元素
            while (a[j] >= pivot && j < end) j++;
            while (a[i] <= pivot && i < end) i++; // 搜索需要右移的元素

            // swap
            tmp = a[j];
            a[j] = a[i];
            a[i] = tmp;
        }
        return i;
    }
}


// 3.1. 快慢指针-交换法-合并写法
class QuickSort3_1 {
    public static void sort(int[] a) {
        if (a == null || a.length <= 1) return;
        sort(a, 0, a.length - 1);
    }

    public static void sort(int[] a, int start, int end) {
        if (a == null || a.length <= 1) return;
        if (start >= end || start < 0) return;

        final int pivot = a[end];
        int i = start, j = i, tmp;

        while (j < end) {
            while (a[j] <= pivot && j < end) j++;
            while (a[j] >= pivot && j < end) j++;
            while (a[i] <= pivot && i < end) i++;

            // swap
            tmp = a[j];
            a[j] = a[i];
            a[i] = tmp;
        }

        sort(a, start, i - 1);
        sort(a, i + 1, end);
    }
}