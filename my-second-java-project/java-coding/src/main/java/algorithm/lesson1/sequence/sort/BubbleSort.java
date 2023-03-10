package algorithm.lesson1.sequence.sort;


// 冒泡排序(Bubble Sort):
// 冒泡排序是一种交换排序, 和选择排序(Selection Sort)十分类似, 每次遍历都是遍历未处理数组,
// 每次遍历结束都会确定一个极值, 每次都保证指针左侧有序, 且元素在最终位置,
// 不同的是选择排序是"先找后交换", 每次遍历交换一次, 而冒泡排序是"边找边交换", 每次遍历交换多次.
// https://blog.csdn.net/zsx0728/article/details/114776325

// TC: O(n*n), SC: O(1), stable
public class BubbleSort {
}

/**
 * 1. 双指针, 嵌套遍历, 边找边交换
 */
class BubbleSort1 {
    public static void sort(int[] a) {
        if (a == null || a.length <= 1) return;
        sort(a, 0, a.length - 1);
    }

    public static void sort(int[] a, int start, int end) {
        if (a == null || a.length <= 1) return;
        if (start >= end || start < 0) return;

        for (int i = start, tmp; i <= end; i++) {
            for (int j = end; j > i; j--) {
                if (a[j] >= a[j - 1]) continue;

                tmp = a[j - 1];
                a[j - 1] = a[j];
                a[j] = tmp;
            }
        }
    }
}