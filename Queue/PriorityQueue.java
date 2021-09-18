package DataStructures.Queue;

import java.lang.reflect.Array;
import java.util.Arrays;

public class PriorityQueue {
    // [1, 3, 5, 7]
    // insert(2)
    // [1, 2, 3, 5, 7]
    private int[] items;
    private int count;
    private int front;
    public PriorityQueue(int cap) {
        this.items = new int[cap];
    }
    public boolean isFull() {
        return count == items.length;
    }
    public boolean isEmpty() {
        return count == 0;
    }
    public void add(int item) {
        if (isFull()) {
            throw new StackOverflowError();
        }
        int i;
        for (i = count; i > 0; i = i - 1) {
            if (items[i - 1] > item) {
                items[i] = items[i - 1];
            } else {
                break;
            }
        }
        items[i] = item;
        count++;
    }
    public int remove() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        int result = items[front];
        items[front++] = 0;
        count--;
        return result;
    }
    @Override
    public String toString() {
        return Arrays.toString(items);
    }
}
