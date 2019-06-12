import java.util.Random;

public class getRandom {
    ListNode node;
    public getRandom(ListNode head) {
        node = head;
    }

    /** Returns a random node's value. */
    public int getRandom() {
        Random rand = new Random();
        int count = 0;
        int res = node.val;
        while (node != null) {
            if (rand.nextInt(count + 1) == count) res = node.val;
            node = node.next;
            count++;
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        System.out.println((new getRandom(head)).getRandom());
    }
}


