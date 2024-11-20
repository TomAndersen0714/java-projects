package leetcode.common;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }

    public ListNode(int[] array) {
        if (array != null && array.length != 0) {
            val = array[0];
            ListNode tail = null;

            if (array.length > 1) {
                next = new ListNode(array[1]);
                tail = next;
            }
            for (int i = 2; i < array.length; i += 1) {
                tail.next = new ListNode(array[i]);
                tail = tail.next;
            }
        }
    }

    public ListNode getNext(int num) {
        ListNode cur = next;
        for (int i = 1; i < num; i += 1) {
            cur = cur.next;
        }
        return cur;
    }
}
