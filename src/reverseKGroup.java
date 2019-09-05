public class reverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        int len = 0;
        ListNode cur = head;
        while(cur != null) {
            len++;
            cur = cur.next;
        }
        int n = len / k;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        cur = dummyHead;
        for(int i = 0; i < n; i++) {
            ListNode pre = cur;
            cur = cur.next;
            for(int j = 0; j < k - 1; j++) {
                ListNode next = cur.next;
                cur.next = next.next;
                next.next = pre.next;
                pre.next = next;
            }
        }
        return dummyHead.next;
    }
}
