public class testLinkedList {
    public ListNode test(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        if(head == null) return null;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode compare = reverse(slow);
        return compare;
    }

    private ListNode reverse(ListNode node) {
        if(node == null || node.next == null) return node;
        ListNode p = reverse(node.next);
        node.next.next = node;
        node.next = null;
        return p;
    }
}
