public class removeNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode cur1 = dummyHead;
        ListNode cur2 = dummyHead;
        for(int i = 0; i < n + 1; i++) {
            cur1 = cur1.next;
        }
        while(cur1 != null) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        cur2.next = cur2.next.next;
        return dummyHead.next;
    }
}
