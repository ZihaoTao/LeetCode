public class partition {
    public ListNode partition(ListNode head, int x) {
        ListNode dummyHead1 = new ListNode(0);
        ListNode dummyHead2 = new ListNode(0);
        ListNode cur1 = dummyHead1;
        ListNode cur2 = dummyHead2;
        ListNode cur = head;
        while(cur != null) {
            if(cur.val < x) {
                cur1.next = cur;
                cur1 = cur1.next;
            } else {
                cur2.next = cur;
                cur2 = cur2.next;
            }
            cur = cur.next;
        }
        cur1.next = dummyHead2.next;
        cur2.next = null;
        return dummyHead1.next;
    }
}
