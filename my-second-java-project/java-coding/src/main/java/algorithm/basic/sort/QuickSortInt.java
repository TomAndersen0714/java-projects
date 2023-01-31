package algorithm.basic.sort;

import java.util.Arrays;

public class QuickSortInt {
    // descending quick sort
    public static void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    public static void sort(int[] a, int low, int high) {
        if (low >= high) return;

        int p = partition(a, low, high);
        sort(a, low, p - 1);
        sort(a, p + 1, high);
    }

    private static int partition(int[] a, int low, int high) {
        if (low >= high) return 0;

        int sentry = a[low];
        int i = low, j = high;

        while (true) {
            while (a[j] <= sentry && i != j) {
                j--;
            }
            while (a[i] >= sentry && i != j) {
                i++;
            }
            if (i == j) break;

            a[low] = a[i];
            a[i] = a[j];
            a[j] = a[low];
        }

        a[low] = a[i];
        a[i] = sentry;

        return i;
    }

    public static void main(String[] args) {
        int[] a = new int[]{5, 6, 6, 7, 12, 11, 22, 14, 2, 3};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
