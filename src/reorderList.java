import java.util.Stack;

public class reorderList {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return;
        ListNode cur = head;
        Stack<ListNode> stack = new Stack<>();
        while(cur != null) {
            stack.push(cur);
            cur = cur.next;
        }

        int cnt = (stack.size() - 1) / 2;
        for(int i = 0; i < cnt; i++) {
            ListNode temp = stack.pop();
            ListNode next = head.next;
            head.next = temp;
            temp.next = next;
            head = next;
        }
        stack.pop().next = null;
    }
}
