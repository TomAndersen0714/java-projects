import java.util.PriorityQueue;

/**
 * @author TomAndersen
 */
public class HW {
    int calculate(int[] nums) {
        // exclude boundary situations
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // handle
        int n = nums.length, res;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> (o2 - o1));
        for (int num : nums) {
            maxHeap.offer(num);
        }

        while (maxHeap.size() >= 2) {
            int x = maxHeap.poll(), y = maxHeap.poll();
            if (x != y) {
                maxHeap.offer(x > y ? x - y : y - x);
            }
        }

        // return
        res = maxHeap.size() == 1 ? maxHeap.poll() : 0;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new HW().calculate(new int[]{2, 7, 4, 1, 8, 1}));
        System.out.println(new HW().calculate(new int[]{7, 8}));
        System.out.println(new HW().calculate(new int[]{3, 2, 1}));
    }
}
