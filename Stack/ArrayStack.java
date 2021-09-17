package DataStructures.Stack;

public class ArrayStack {

    private int[] items;
    private int count;
    public ArrayStack(int size) {
        items = new int[size];
        count = 0;
    }
    public void push(int item) {
        if (count == items.length) {
            throw new StackOverflowError();
        }
        items[count++] = item;
    }
    public int pop() {
        if (count == 0) {
            throw new IllegalStateException();
        }
        return items[--count];
    }
    public int peek() {
        if (count == 0) {
            throw new IllegalStateException();
        }
        return items[count-1];
    }
    public boolean isEmpty() {
        return count == 0;
    }
}
