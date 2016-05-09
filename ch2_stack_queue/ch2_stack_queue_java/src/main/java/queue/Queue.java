package queue;

import java.util.NoSuchElementException;

/**
 * Created by ilyarudyak on 5/9/16.
 */
public class Queue<Item> {

    public static final int N = 10;

    private Node<Item> first;
    private Node<Item> last;
    private int size;

    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    public Queue() {
        first = null;
        last  = null;
        size = 0;
    }

    public void enqueue(Item item) {

        Node<Item> newNode = new Node<>();
        newNode.item = item;
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

    public static void main(String[] args) {

        Queue<Integer> queue = new Queue<>();

        for (int i = 0; i < N; i++) { queue.enqueue(i); }
        queue.show();

        for (int i = 0; i < N; i++) { queue.dequeue(); }
        queue.show();

    }
}















