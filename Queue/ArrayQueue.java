package DataStructures.Queue;

import java.util.Arrays;
/*
Circular array using front and rear pointers
 */
public class ArrayQueue {
    // enqueue
    // dequeue
    // peek
    // isEmpty
    // isFull
    private int front;
    private int rear;
    private int[] items;
    private int count;
    public ArrayQueue(int size) {
        front = 0;
        rear = 0;
        count = 0;
        items = new int[size];
    }
    public void enqueue(int item) {
        if (isFull()) {
            throw new IllegalStateException();
        }
        count++;
        items[rear++] = item;
        rear %= items.length;
        System.out.println("count " + count);
    }
    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        count--;
        int res = items[front];
        items[front++] = 0;
        front %= items.length;
        System.out.println("count " + count);
        return res;
    }
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        return items[front];
    }
    public boolean isEmpty() {
        return count == 0;
    }
    public boolean isFull() {
        return count == items.length;
    }
    public String toString() {
        return Arrays.toString(items);
    }
}
