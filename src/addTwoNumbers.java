public class addTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        int count = 0;
        while(cur1 != null || cur2 != null) {
            int x = (cur1 == null) ? 0 : cur1.val;
            int y = (cur2 == null) ? 0 : cur2.val;
            int temp = x + y + count;
            count = temp / 10;
            cur.next = new ListNode(temp % 10);
            cur = cur.next;
            if(cur1 != null) cur1 = cur1.next;
            if(cur2 != null) cur2 = cur2.next;
        }

        if(count != 0) {
            cur.next = new ListNode(count);
        }

        return dummyHead.next;
    }
}
