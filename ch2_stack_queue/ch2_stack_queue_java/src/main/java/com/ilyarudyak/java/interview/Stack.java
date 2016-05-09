package com.ilyarudyak.java.interview;

import java.util.NoSuchElementException;

/**
 * Stack based on Linked List. Code based on this one:
 * http://algs4.cs.princeton.edu/code/edu/princeton/cs/algs4/Stack.java.html
 */
public class Stack<Item> {

    private Node<Item> first;
    private int size;

    // helper linked list class
    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    public Stack() {
        first = null;
        size = 0;
    }

    public void push(Item item) {

        Node<Item> newNode = new Node<>();
        newNode.item = item;

        if (first == null) {
            newNode.next = null;
            first = newNode;
        }
        else {
            newNode.next = first;
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
    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("stack is empty");
        Item item = first.item;
        return item;
    }

    // utility functions
    public boolean isEmpty() {
        return first == null;
    }
    public int size() {
        return size;
    }
    public void show() {
        Node cur = first;
        while (cur != null) {
            System.out.print(cur.item + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        System.out.println("size=" + stack.size());

        while (!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
        System.out.println("size=" + stack.size());
    }

}



























