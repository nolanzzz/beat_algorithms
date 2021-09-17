package DataStructures.Stack;

import java.util.LinkedList;

public class LinkedListStack<E> {
    private LinkedList<E> items;
    private int count;
    public LinkedListStack() {
        this.items = new LinkedList<>();
        this.count = 0;
    }
    public void push(E item) {
        items.add(item);
        count++;
    }
    public E pop() {
        if (items.isEmpty()) {
            throw new IllegalStateException();
        }
        count--;
        return items.removeLast();
    }
    public E peek() {
        if (items.isEmpty()) {
            throw new IllegalStateException();
        }
        return items.getLast();
    }
    public boolean isEmpty() {
        return count == 0;
    }
}
