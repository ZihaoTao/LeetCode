import java.util.HashSet;
import java.util.Set;

public class hasCycle {
    Set<ListNode> set = new HashSet<>();
    public boolean hasCycle(ListNode head) {
        while(head != null) {
            if(!set.contains(head)) {
                set.add(head);
            } else {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    public boolean hasCycle2(ListNode head) {
        if(head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != slow) {
            if(fast == null || fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }
}
