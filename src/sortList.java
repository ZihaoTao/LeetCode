public class sortList {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            dummyHead = dummyHead.next;
        }
        dummyHead.next = null;
        ListNode head2 = slow;
        return merge(sortList(head), sortList(head2));
    }

    private ListNode merge(ListNode node1, ListNode node2) {
        ListNode cur1 = node1;
        ListNode cur2 = node2;
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        while(cur1 != null && cur2 != null) {
            if(cur1.val < cur2.val) {
                cur.next = cur1;
                cur1 = cur1.next;
            } else {
                cur.next = cur2;
                cur2 = cur2.next;
            }
            cur = cur.next;
        }

        if(cur1 != null) {
            cur.next = cur1;
        }
        if(cur2 != null) {
            cur.next = cur2;
        }
        return dummyHead.next;
    }
}
