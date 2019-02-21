import java.util.Comparator;
import java.util.PriorityQueue;

public class mergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;

        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for(ListNode i : lists) {
            if(i != null) {
                pq.add(i);
            }
        }
        while(!pq.isEmpty()) {
            ListNode temp = pq.remove();
            if(temp.next != null) {
                pq.add(temp.next);
            }
            cur.next = temp;
            cur = cur.next;
        }
        return dummyHead.next;
    }
}
