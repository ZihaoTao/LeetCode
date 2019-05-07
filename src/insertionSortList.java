public class insertionSortList {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode cur = head;
        while(cur != null && cur.next != null) {
            ListNode pre = dummyHead;
            while(pre != cur) {
                ListNode t = cur.next;
                if(pre.next.val > t.val) {
                    cur.next = t.next;
                    t.next = pre.next;
                    pre.next = t;
                    break;
                }
                    pre = pre.next;
            }
            if (pre == cur) {
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }
}
