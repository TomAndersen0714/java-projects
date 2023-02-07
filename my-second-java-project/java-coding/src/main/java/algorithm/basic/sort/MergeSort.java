package algorithm.basic.sort;

public class MergeSort {
}


class MergeSort1 {
    public static void sort(int[] a) {
        if (a == null || a.length <= 1) return;
        sort(a, 0, a.length - 1);
    }

    public static void sort(int[] a, int start, int end) {
        if (a == null || a.length <= 1) return;
        if (start >= end || start < 0) return;

        int mid = start + (end - start) / 2;
        sort(a, start, mid);
        sort(a, mid + 1, end);

        merge(a, start, mid, end);
    }

    private static void merge(int[] a, int start, int mid, int end) {

    }
}