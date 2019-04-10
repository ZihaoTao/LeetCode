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
        while(curA != curB) {
            if(curA == null) curA = headB;
            else curA = curA.next;
            if(curB == null) curB = headA;
            else curB = curB.next;
        }
        return curA;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(0);
        ListNode head2 = new ListNode(0);
        head2.next = new ListNode(2);
        System.out.println((new getIntersectionNode()).getIntersectionNode2(head1, head2));
    }
}
