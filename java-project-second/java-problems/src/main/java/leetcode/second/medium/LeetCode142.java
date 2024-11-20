package leetcode.second.medium;

import leetcode.common.ListNode;
import leetcode.common.Util;

/**
 * 142. Linked List Cycle II
 * https://leetcode.com/problems/linked-list-cycle-ii/description/
 */
public class LeetCode142 {
    public static void main(String[] args) {
        ListNode head;
        ListNode output;

        head = new ListNode(Util.strToArray("[3,2,0,-4]"));
        head.getNext(3).next = head.getNext(1);
        output = head.getNext(1);
        System.out.println(new LeetCode142_1().detectCycle(head) == output);
    }
}

/**
 * Two Pointers
 */
class LeetCode142_1 {
    public ListNode detectCycle(ListNode head) {
        // input
        if (head == null || head.next == null) {
            return null;
        }

        // transform
        ListNode slow, fast, cur;
        slow = head.next;
        fast = head.next.next;
        cur = head;

        while (fast != null && fast.next != null && slow != fast) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null && fast.next != null) {
            while (cur != slow) {
                cur = cur.next;
                slow = slow.next;
            }
        }
        else {
            cur = null;
        }

        // output
        return cur;
    }
}
