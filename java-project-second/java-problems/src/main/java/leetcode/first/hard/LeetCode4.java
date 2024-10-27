package leetcode.first.hard;

/**
 * 4. Median of Two Sorted Arrays: https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 *
 * @author TomAndersen
 */
public class LeetCode4 {
}


/**
 * Merge sort
 * TC: O(m+n), SC: O(1)
 */
class LeetCode4_1 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // exclude boundary situation
        if (nums1 == null || nums2 == null || (nums1.length == 0 && nums2.length == 0)) {
            return 0.0;
        }

        // solve problem
        double median = 0.0;

        int m = nums1.length, n = nums2.length;
        int left = 0, right = 0, counter = (m + n) / 2 + 1;
        int first = 0, second = 0;

        for (int i = 0; i < counter; i++) {
            first = second;

            if (left < m && right < n) {
                if (nums1[left] <= nums2[right]) {
                    second = nums1[left];
                    left += 1;
                }
                else {
                    second = nums2[right];
                    right += 1;
                }
            }
            else if (left < m) {
                second = nums1[left];
                left += 1;
            }
            else {
                second = nums2[right];
                right += 1;
            }
        }

        if ((m + n) % 2 == 1) {
            median = second * 1.0;
        }
        else {
            median = (first + second) / 2.0;
        }

        // return
        return median;
    }

    public static void main(String[] args) {
        System.out.println(Double.compare(new LeetCode4_1().findMedianSortedArrays(new int[]{1, 3}, new int[]{2}), 2.00000) == 0);
        System.out.println(Double.compare(new LeetCode4_1().findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}), 2.50000) == 0);
    }

}
