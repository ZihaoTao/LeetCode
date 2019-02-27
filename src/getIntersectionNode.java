import java.util.HashSet;
import java.util.Set;

public class getIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        while(headA != null) {
            set.add(headA);
            headA = headA.next;
        }
        while(headB != null) {
            if(set.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        while(curA != null || curB != null) {
            if(curA == curB) return curA;

            if(curA != null) {
                curA = curA.next;
            } else {
                curA = headB;
            }

            if(curB != null) {
                curB = curB.next;
            } else {
                curB = headA;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(0);
        ListNode head2 = new ListNode(0);
        head2.next = new ListNode(2);
        System.out.println((new getIntersectionNode()).getIntersectionNode2(head1, head2));
    }
}
