package queue;

import stack.Stack;

/**
 * Created by ilyarudyak on 5/9/16.
 */
public class QueueWith2Stacks<Item> {

    Stack<Item> toPush, toPop;

    public QueueWith2Stacks() {
        toPush = new Stack<>();
        toPop = new Stack<>();
    }

    public void enqueue(Item item) {
        toPush.push(item);
    }

    public Item dequeue() {
        if (toPop.isEmpty()) { shift(); }
        return toPop.pop();
    }

    private void shift() {
        if (toPop.isEmpty()) {
            while (!toPush.isEmpty()) {
                toPop.push(toPush.pop());
            }
        }
    }

    public boolean isEmpty() {
        return size() == 0;
    }
    public int size() {
        return toPush.size() + toPop.size();
    }
    public void show() {
        System.out.print("toPush: ");
        toPush.show();
        System.out.print("toPop: ");
        toPop.show();
    }

    public static void main(String[] args) {

        QueueWith2Stacks<Integer> queue = new QueueWith2Stacks<>();
        for (int i = 0; i < 5; i++) {
            queue.enqueue(i);
        }
        queue.show();

        queue.dequeue();
        queue.show();

        for (int i = 6; i < 10; i++) {
            queue.enqueue(i);
        }

        for (int i = 0; i < 5; i++) {
            queue.dequeue();
        }
        queue.show();
    }
}













