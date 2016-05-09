package queue;

import java.util.NoSuchElementException;

/**
 * Created by ilyarudyak on 5/9/16.
 */
public class QueueWithTime<Item> {

    private Node<Item> first;
    private Node<Item> last;
    private int size;

    private static class Node<Item> {
        private Item item;
        private long timestamp;
        private Node<Item> next;
    }

    public QueueWithTime() {
        first = null;
        last  = null;
        size = 0;
    }

    public void enqueue(Item item) {

        Node<Item> newNode = new Node<>();
        newNode.item = item;
        newNode.timestamp = System.nanoTime();
        newNode.next = null;

        size++;

        if (isEmpty()) {
            first = last = newNode;
        } else {
            last.next = newNode;
            last = last.next;
        }
    }
    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException("queue is empty");
        Item item = first.item;
        first = first.next;
        size--;
        return item;
    }
    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("queue is empty");
        return first.item;
    }
    public long peekTime() {
        if (isEmpty()) throw new NoSuchElementException("queue is empty");
        return first.timestamp;
    }

    // utility functions
    public boolean isEmpty() {
        return first == null;
    }
    public int size() {
        return size;
    }
    public void show() {
        if (isEmpty()) { System.out.println("queue is empty..."); return; }
        Node cur = first;
        while (cur != null) {
            System.out.print(cur.item + " ");
            cur = cur.next;
        }
        System.out.println();
    }
}
