package algorithm.lesson1.array.sort;


// 希尔排序(Shell Sort):
// 希尔排序一种基于插入排序(Insertion Sort)的快速的排序算法, 主要思想是使数组中任意间隔为h的元素序列
// 都是有序的, 针对这些序列使用插入排序实现局部有序, 而插入排序对于局部有序的序列效率性能与数量近乎线性.
// 当h不断减小到值为1时, 则实现了整体有序. 希尔排序适合局部有序的任意长度序列.
// --算法(第4版)
// TC: O(n*log(n)), SC: O(1), unstable
public class ShellSort {
}

class ShellSort1 {
    public static void sort(int[] a) {
        if (a == null || a.length <= 1) return;
        sort(a, 0, a.length - 1);
    }

    public static void sort(int[] a, int start, int end) {
        if (a == null || a.length <= 1) return;
        if (start >= end || start < 0) return;

        int h = 1, len = end - start + 1;
        while (h < len / 3) h = 3 * h + 1;
        while (h >= 1) {
            for (int i = start, tmp; i <= end; i += h) {
                for (int j = i; j >= start + h; j -= h) {
                    if (a[j] >= a[j - h]) break;

                    tmp = a[j - h];
                    a[j - h] = a[j];
                    a[j] = tmp;
                }
            }
            h = h / 3;
        }
    }

}