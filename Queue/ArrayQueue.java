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
        items = new int[size];
        count = 0;
    }
    public void enqueue(int item) {
        if (isFull()) {
            throw new StackOverflowError();
        }
        count++;
        items[rear++] = item;
        rear %= items.length;
    }
    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        count--;
        int item = items[front++];
        front %= items.length;
        return item;
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
