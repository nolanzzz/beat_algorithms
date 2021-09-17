package DataStructures;

import java.util.Arrays;

/*
Implement with Array or Heap
 */
public class PriorityQueue {
    private int[] items;
    private int count;
    private int front;
    public PriorityQueue(int cap) {
        items = new int[cap];
        count = 0;
        front = 0;
    }
    public void add(int item) {
        if (isFull()) {
            throw new IllegalStateException();
        }
        items[shiftInsert(item)] = item;
        count++;
    }
    public int remove() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        count--;
        int res = items[front];
        items[front++] = 0;
       return res;
    }
    public boolean isEmpty() {
        return count == 0;
    }
    public boolean isFull() {
        return count == items.length;
    }
    @Override
    public String toString() {
        return Arrays.toString(items);
    }
    public int shiftInsert(int item) {
        int i = count - 1;
        for (i = count - 1; i >= 0; i--) {
            if (items[i] > item) {
                items[i+1] = items[i];
            } else {
                break;
            }
        }
        return i + 1;
    }
}
