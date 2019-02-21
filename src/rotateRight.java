public class rotateRight {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode end = dummyHead;

        int count = 0;
        while(end.next != null) {
            end = end.next;
            count++;
        }
        if(count == 0) return head;
        k %= count;
        if(k == 0) {
            return head;
        }

        ListNode cur = dummyHead;
        for(int i = 0; i < count - k; i++) {
            cur = cur.next;
        }

        ListNode res = cur.next;
        cur.next = null;
        end.next = dummyHead.next;
        return res;
    }
}
