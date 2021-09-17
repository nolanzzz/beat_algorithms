package DataStructures;

/*

Stack:

- Implement undo feature
- Build compilers
- Evaluate expressions
- Build navigation (e.g. forward/back)

Last In First Out (LIFO)

Build Stack with Array or LinkedList

All in constant time - O(1):
push
pop
peek
isEmpty

 */
public class Stack {

    private int[] items;
    private int count;
    public Stack(int size) {
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
