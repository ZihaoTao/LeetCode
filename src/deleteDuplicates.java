public class deleteDuplicates {
    public ListNode deleteDuplicatesII(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        while(pre.next != null) {
            ListNode cur = pre.next;
            while(cur.next != null && cur.next.val == cur.val) {
                cur = cur.next;
            }
            if(cur != pre.next) {
                pre.next = cur.next;
            } else {
                pre = pre.next;
            }
        }
        return dummyHead.next;
    }

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        ListNode cur = head;
        while(cur != null && cur.next != null) {
            if(cur.next.val == cur.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }
}
