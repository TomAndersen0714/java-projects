package algorithm.basic.sort;

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
    }

}