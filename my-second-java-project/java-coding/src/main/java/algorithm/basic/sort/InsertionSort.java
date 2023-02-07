package algorithm.basic.sort;


// 插入排序(Insertion Sort):
// 每次遍历确定相对位置, 和选择排序(Selection Sort)类似, 每次都保证指针左侧有序
// 不同的是, 插入排序不保证指针左侧元素在最终位置, 且插入排序是针对已处理数组进行遍历.
// 插入排序类似于扑克牌抓牌和理牌, 当大部分有序时可以跳过理牌, 故适合处理局部有序的短序列.
// -- 算法(第4版)

// TC: O(n*n), SC: O(1), stable
public class InsertionSort {
}

// 1. 简单插入排序
class InsertionSort1 {
    public static void sort(int[] a) {
        if (a == null || a.length <= 1) return;
        sort(a, 0, a.length - 1);
    }

    public static void sort(int[] a, int start, int end) {
        if (a == null || a.length <= 1) return;
        if (start >= end || start < 0) return;

        for (int i = start, tmp; i <= end; i++) {

            // 将a[i], 插入到已有序的a[i-1], a[i-2]...序列中的对应位置上
            for (int j = i; j > start; j--) {
                // 如果左侧已整体有序, 则不需要向前插入
                if (a[j] >= a[j - 1]) break;

                tmp = a[j - 1];
                a[j - 1] = a[j];
                a[j] = tmp;
            }
        }
    }
}