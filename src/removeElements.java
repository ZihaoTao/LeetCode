public class removeElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        while(cur != null && cur.next != null) {
            ListNode next = cur.next;
            if(next.val == val) {
                cur.next = next.next;
            } else {
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }
}
