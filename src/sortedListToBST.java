import java.util.ArrayList;

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
        ListNode cur = head;
        int count = 0;
        while(cur!=null)
        {
            cur = cur.next;
            count++;
        }
        ArrayList<ListNode> list = new ArrayList<ListNode>();
        list.add(head);
        return helper(list,0,count-1);
    }
    private TreeNode helper(ArrayList<ListNode> list, int l, int r) {
        if (l > r)
            return null;
        int m = (l + r) / 2;
        TreeNode left = helper(list, l, m - 1);
        TreeNode root = new TreeNode(list.get(0).val);
        root.left = left;
        list.set(0, list.get(0).next);
        root.right = helper(list, m + 1, r);
        return root;
    }
}
