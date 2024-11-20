package leetcode.second.easy;

import leetcode.common.ListNode;
import leetcode.common.Util;

/**
 * 141. Linked List Cycle
 * https://leetcode.com/problems/linked-list-cycle/description/
 */
public class LeetCode141 {
    public static void main(String[] args) {
        ListNode head;
        boolean output;

        head = new ListNode(Util.strToArray("[3,2,0,-4]"));
        output = true;
        System.out.println(new LeetCode141_1().hasCycle(head) == output);
    }
}


/**
 * Two pointer (fast and slow)
 */
class LeetCode141_1 {
    public boolean hasCycle(ListNode head) {
        // input
        if (head == null || head.next == null) {
            return false;
        }

        // transform
        ListNode slow = head, fast = head.next.next;
        while (slow != null && fast != null && fast.next != null && slow != fast) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // output
        return slow == fast;
    }
}
