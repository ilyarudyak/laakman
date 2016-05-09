package stack;

import java.util.NoSuchElementException;
import java.util.Random;

/**
 * Created by ilyarudyak on 5/9/16.
 */
public class StackWithMin<Item extends Comparable<Item>> {

    private Node<Item> first;
    private int size;

    // helper linked list class
    private static class Node<Item> {
        private Item item;
        private Item minBelow;
        private Node<Item> next;
    }

    public StackWithMin() {
        first = null;
        size = 0;
    }

    public void push(Item item) {

        Node<Item> newNode = new Node<>();
        newNode.item = item;

        if (first == null) {
            newNode.next = null;
            newNode.minBelow = item;
            first = newNode;
        }
        else {
            newNode.next = first;
            if (first.item.compareTo(first.minBelow) < 0) {
                newNode.minBelow = first.item;
            } else {
                newNode.minBelow = first.minBelow;
            }
            first = newNode;
        }
        size++;
    }
    public Item pop() {
        if (isEmpty()) throw new NoSuchElementException("stack is empty");
        Item item = first.item;
        first = first.next;
        size--;
        return item;
    }

    // utility functions
    public Item min() {
        if (isEmpty()) { return null; }
        if (first.item.compareTo(first.minBelow) < 0) {
            return first.item;
        } else {
            return first.minBelow;
        }
    }
    public Item minIter() {
        if (isEmpty()) { return null; }
        Item min = first.item;
        Node<Item> cur = first.next;
        while (cur != null) {
            Item tmp = cur.item;
            if (tmp.compareTo(min) < 0) {
                min = tmp;
            }
            cur = cur.next;
        }
        return min;
    }
    public boolean isEmpty() {
        return first == null;
    }
    public int size() {
        return size;
    }

    public static void main(String[] args) {

        Random random = new Random(1234567890);
        StackWithMin<Integer> stack = new StackWithMin<>();

        for (int i = 0; i < 10; i++) {
            int n = random.nextInt(10);
            stack.push(n);
            System.out.println("push=" + n + " min=" + stack.min());
        }

        System.out.println();
        while (!stack.isEmpty()){
            System.out.println("pop=" + stack.pop() + " min=" + stack.min());
        }
    }
}













