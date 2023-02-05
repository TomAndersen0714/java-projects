package algorithm.basic.sort;

// TC: O(n*n), SC: O(1), unstable
public class SelectionSort {
}


// 1. 选择排序
// Tips: 每次遍历寻找极值, 每次都保证索引左侧有序, 且元素都在最终位置
// Tips: 双指针, 嵌套遍历, 选择, 交换, 先选后交换
class SelectionSort1 {
    public static void sort(int[] a) {
        if (a == null || a.length == 0) return;
        sort(a, 0, a.length - 1);
    }

    public static void sort(int[] a, int start, int end) {
        if (a == null || a.length == 0) return;
        if (start >= end || start < 0) return;

        for (int i = start, min, tmp; i <= end; i++) {
            min = i;
            for (int j = i + 1; j <= end; j++) {
                if (a[min] > a[j]) min = j;
            }

            tmp = a[i];
            a[i] = a[min];
            a[min] = tmp;
        }
    }
}
