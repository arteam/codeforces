package leetcode;

public class Task2 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode first = new ListNode(1);

        ListNode second = new ListNode(9);
        second.next = new ListNode(9);
        new Task2().addTwoNumbers(first, second);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultNode = null;
        ListNode currentNode = null;
        int remainder = 0;
        while (l1 != null || l2 != null || remainder > 0) {
            int i1 = l1 == null ? 0 : l1.val;
            int i2 = l2 == null ? 0 : l2.val;
            int sum = i1 + i2 + remainder;
            remainder = sum / 10;

            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : l2;

            ListNode listNode = new ListNode(sum % 10);
            if (currentNode != null) {
                currentNode.next = listNode;
            }
            currentNode = listNode;
            if (resultNode == null) {
                resultNode = currentNode;
            }
        }
        return resultNode;
    }


}
