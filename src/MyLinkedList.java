class MyLinkedList {
    class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    ListNode dummyHead;
    /** Initialize your data structure here. */
    public MyLinkedList() {
        dummyHead = new ListNode(0);
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index < 0) return -1;
        ListNode cur = dummyHead;
        for(int i = 0; i <= index; i++) {
            cur = cur.next;
            if(cur == null) return -1;
        }
        return cur.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        ListNode node = new ListNode(val, dummyHead.next);
        dummyHead.next = node;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        ListNode node = dummyHead;
        while(node.next != null) {
            node = node.next;
        }
        node.next = new ListNode(val);
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        ListNode cur = dummyHead;
        for(int i = 0; i < index; i++) {
            if(cur.next == null) {
                return;
            }
            cur = cur.next;
        }
        ListNode node = new ListNode(val, cur.next);
        cur.next = node;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        ListNode cur = dummyHead;
        if(index < 0) return;
        for(int i = 0; i < index; i++) {
            if(cur.next == null) {
                return;
            }
            cur = cur.next;
        }
        if(cur.next != null)
            cur.next = cur.next.next;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */