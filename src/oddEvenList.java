public class oddEvenList {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummyHead1 = new ListNode(0);
        ListNode cur1 = dummyHead1;
        ListNode dummyHead2 = new ListNode(0);
        ListNode cur2 = dummyHead2;
        ListNode cur = head;
        int count = 0;
        while(cur != null) {
            if(count % 2 == 0) {
                cur1.next = cur;
                cur1 = cur1.next;
            } else {
                cur2.next = cur;
                cur2 = cur2.next;
            }
            count++;
            cur = cur.next;
        }
        cur1.next = dummyHead2.next;
        return dummyHead1.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        (new oddEvenList()).oddEvenList(head);
    }
}
