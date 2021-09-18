package DataStructures.LinkedList;

public class LinkedList {
    private class Node {
        private int val;
        private Node next;
        private Node(int val) {
            this.val = val;
        }
    }
    int size;
    Node head;
    public LinkedList() {
        size = 0;
        head = new Node(-1);
    }
    public void addAtIndex(int index, int item) {
        if (index >= 0 && index <= size) {
            Node pred = head;
            for (int i = 0; i < index; i++) {
                pred = pred.next;
            }
            Node newNode = new Node(item);
            newNode.next = pred.next;
            pred.next = newNode;
            size++;
        }
    }
    public void addLast(int item) {
        addAtIndex(size, item);
    }
    public void addFirst(int item) {
        addAtIndex(0, item);
    }
    public void deleteFirst() {
        deleteAt(0);
    }
    public void deleteLast() {
        deleteAt(size-1);
    }
    public void deleteAt(int index) {
        if (index >= size) {
            return;
        }
        if (index < 0) {
            index = 0;
        }
        Node pred = head;
        for (int i = 0; i < index; i++) {
            pred = pred.next;
        }
        pred.next = pred.next.next;
        size--;
    }
    public boolean contains(int item) {
        Node cur = head.next;
        while (cur != null) {
            if (cur.val == item) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
    public int indexOf(int item) {
        Node cur = head.next;
        for (int i = 0; i < size; i++) {
            if (cur.val == item) {
                return i;
            }
            cur = cur.next;
        }
        return -1;
    }
    public String toString() {
        StringBuilder res = new StringBuilder("[");
        Node cur = head.next;
        for (int i  = 0; i < size; i++) {
            res.append(cur.val);
            if (i != size - 1) {
                res.append(", ");
            }
            cur = cur.next;
        }
        res.append("]");
        return res.toString();
    }
    public int size() {
        return size;
    }
    public int[] toArray() {
        int[] res = new int[size];
        Node cur = head.next;
        for (int i = 0; i < size; i++) {
            res[i] = cur.val;
            cur = cur.next;
        }
        return res;
    }
    public void print() {
        Node cur = head.next;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
    }
    public void reverse() {
        Node pred = head;
        Node cur = pred.next;
        int i = 0;
        while (cur != null) {
            Node temp = cur.next;
            if (i++ == 0) {
                cur.next = null;
            } else {
                cur.next = pred;
            }
            pred = cur;
            cur = temp;
        }
        head.next = pred;
    }
    public int findLastKthNode(int index) {
        if (index > size || index <= 0) {
            return -1;
        }
        Node slow = head;
        Node fast = head;
        for (int i = 0; i < index; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow.val;
    }
}