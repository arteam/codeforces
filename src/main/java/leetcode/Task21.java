package leetcode;

public class Task21 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(4);

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(3);
        head2.next.next = new ListNode(4);

        new Task21().mergeTwoLists(head1, head2);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(0);
        ListNode tail = preHead;
        while (l1 != null || l2 != null) {
            int v1 = l1 != null ? l1.val : Integer.MAX_VALUE;
            int v2 = l2 != null ? l2.val : Integer.MAX_VALUE;
            if (v1 < v2) {
                tail = addNode(tail, v1);
                l1 = l1.next;
            } else {
                tail = addNode(tail, v2);
                l2 = l2.next;
            }
        }
        return preHead.next;
    }

    private ListNode addNode(ListNode tail, int val) {
        ListNode next = new ListNode(val);
        tail.next = next;
        return next;
    }
}
