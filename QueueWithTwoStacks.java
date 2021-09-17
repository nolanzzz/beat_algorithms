package DataStructures;/*
Use Stack to implement Queue
 */

import java.util.Stack;
public class QueueWithTwoStacks {
    private Stack<Integer> stackIn;
    private Stack<Integer> stackOut;
    public QueueWithTwoStacks() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }
    public void enqueue(int item) {
        stackIn.push(item);
    }
    public int dequeue() {
        moveStackInToOut();
        return stackOut.pop();
    }

    private void moveStackInToOut() {
        if (stackOut.empty()) {
            while (!stackIn.empty()) {
                stackOut.push(stackIn.pop());
            }
        }
    }

    public int peek() {
        moveStackInToOut();
        return stackOut.peek();
    }
    public boolean isEmpty() {
        return stackIn.empty() && stackOut.empty();
    }
//    public boolean isFull() {
//        return inStack.isFull();
//    }
}
