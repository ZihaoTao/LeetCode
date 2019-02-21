public class swapPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        ListNode pre = dummyHead;
        dummyHead.next = head;
        ListNode cur = pre.next;
        while(cur != null && cur.next != null) {
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = cur;
            pre.next = next;
            pre = cur;
            cur = cur.next;
        }
        return dummyHead.next;
    }
}
