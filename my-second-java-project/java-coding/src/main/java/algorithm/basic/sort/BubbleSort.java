package algorithm.basic.sort;

// TC: O(n*n), SC: O(1), stable
public class BubbleSort {
}


// 1. 冒泡排序(Bubble Sort)
// Tips: 和选择排序(Selection Sort)十分类似, 每次都保证索引左侧有序, 且元素都在最终位置
//      不同的是选择排序是"先选后交换", 每次遍历交换一次, 而冒泡排序是"边选边交换", 每次遍历交换多次
// Tips: 双指针, 嵌套遍历, 边选边交换
class BubbleSort1 {
    public static void sort(int[] a) {
        if (a == null || a.length == 0) return;
        sort(a, 0, a.length - 1);
    }

    public static void sort(int[] a, int start, int end) {
        if (a == null || a.length == 0) return;
        if (start >= end || start < 0) return;

        for (int i = start, tmp; i <= end; i++) {
            for (int j = i; j > start; j--) {
                if (a[j] >= a[j - 1]) break;

                tmp = a[j];
                a[j] = a[j - 1];
                a[j - 1] = tmp;
            }
        }
    }
}