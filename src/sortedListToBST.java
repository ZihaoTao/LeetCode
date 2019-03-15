public class sortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        int size = 0;
        ListNode cur = head;
        while(cur != null) {
            size ++;
            cur = cur.next;
        }
        int[] arr = new int[size];
        ListNode t = head;
        int i = 0;
        while(t != null) {
            arr[i++] = t.val;
            t = t.next;
        }
        return sortedList(arr, 0, arr.length - 1);
    }

    private TreeNode sortedList(int[] arr, int l, int r) {
        if(l > r) return null;

        int mid = l + (r - l) / 2;
        TreeNode node = new TreeNode(arr[mid]);
        node.left = sortedList(arr, l, mid - 1);
        node.right = sortedList(arr, mid + 1, r);
        return node;
    }



    public TreeNode sortedListToBST2(ListNode head) {
        if(head == null)
            return null;
        return helper(head, null);
    }
    private TreeNode helper(ListNode l, ListNode r) {
        if(l == r) return null;
        ListNode fast = l;
        ListNode slow = l;
        while(fast != r && fast.next != r) {
            fast = fast.next.next;
            slow = slow.next;
        }

        TreeNode node = new TreeNode(slow.val);
        node.left = helper(l, slow);
        node.right = helper(slow.next, r);
        return node;
    }
}
