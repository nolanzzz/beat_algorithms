package DataStructures.Queue.Exercises;
/*
Use two stacks to implement a Queue
 */
import java.util.Stack;

public class QueueWithTwoStacks<E> {
    public static void main(String[] args) {
        QueueWithTwoStacks<Integer> queue = new QueueWithTwoStacks<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        queue.enqueue(4);
        queue.enqueue(5);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
    private Stack<E> stackIn;
    private Stack<E> stackOut;
    public QueueWithTwoStacks() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }
    public void enqueue(E item) {
        stackIn.push(item);
    }
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        if (stackOut.isEmpty()) {
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
        }
        return stackOut.pop();
    }
    public boolean isEmpty() {
        return stackIn.isEmpty() && stackOut.isEmpty();
    }
}
