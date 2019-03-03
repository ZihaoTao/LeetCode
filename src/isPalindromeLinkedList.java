import java.util.ArrayList;
import java.util.List;

public class isPalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while(cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        int l = 0;
        int r = list.size() - 1;
        while(l <= r) {
            if(!list.get(l).equals(list.get(r))) return false;
            l++;
            r--;
        }
        return true;
    }

    public boolean isPalindrome2(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode temp = slow;
        ListNode pre = null;
        while(slow != null) {
            ListNode next = slow.next;
            slow.next = pre;
            pre = slow;
            slow = next;
        }
        ListNode cur1 = pre;
        ListNode cur2 = head;
        while(cur2 != temp) {
            if(cur1.val != cur2.val) {
                return false;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(0);
        node.next = new ListNode(0);
        (new isPalindromeLinkedList()).isPalindrome(node);
    }
}
