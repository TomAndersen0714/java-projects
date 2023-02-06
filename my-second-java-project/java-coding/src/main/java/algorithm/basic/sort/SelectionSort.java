package algorithm.basic.sort;


// 选择排序(Selection Sort):
// 每次遍历未处理数组寻找极值, 遍历结束后与数组的首个元素进行交换
// 每次遍历都是遍历未处理数组, 每次遍历结束都会确定一个极值, 每次遍历都保证指针左侧有序, 且元素都在最终位置

// TC: O(n*n), SC: O(1), unstable
public class SelectionSort {
}

// 1. 简单选择排序
// Tips: 双指针, 嵌套遍历, 选择, 交换, 先找后交换
class SelectionSort1 {
    public static void sort(int[] a) {
        if (a == null || a.length <= 1) return;
        sort(a, 0, a.length - 1);
    }

    public static void sort(int[] a, int start, int end) {
        if (a == null || a.length <= 1) return;
        if (start >= end || start < 0) return;

        for (int i = start, min, tmp; i <= end; i++) {
            min = i;
            for (int j = end; j > i; j--) {
                if (a[min] > a[j]) min = j;
            }

            tmp = a[i];
            a[i] = a[min];
            a[min] = tmp;
        }
    }
}
