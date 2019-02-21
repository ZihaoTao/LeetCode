public class reverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode cur = head;

        int size = 0;
        while (cur != null) {
            cur = cur.next;
            size++;
        }

        int count = size / k;
        cur = head;
        ListNode pre = dummyHead;
        for(int i = 0; i < count; i++) {
            int len = 0;
            while(len < k - 1 && cur.next != null) {
                ListNode t = cur.next;
                cur.next = t.next;
                t.next = pre.next;
                pre.next = t;
                len++;
            }
            pre = cur;
            cur = pre.next;
        }
        return dummyHead.next;
    }
}
