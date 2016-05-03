package com.ilyarudyak.java.interview.laakman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by ilyarudyak on 5/3/16.
 */
public class BST<Key extends Comparable<Key>, Value> {

    private Node root;             // root of com.ilyarudyak.java.interview.laakman.BST

    private class Node {
        private Key key;           // sorted by key
        private Value val;         // associated data
        private Node left, right;  // left and right subtrees
        private int N;             // number of nodes in subtree

        public Node(Key key, Value val, int N) {
            this.key = key;
            this.val = val;
            this.N = N;
        }
    }

    // ----------------- utility ------------------------

    // return number of key-value pairs in com.ilyarudyak.java.interview.laakman.BST rooted at x
    public int size() {
        return size(root);
    }
    private int size(Node x) {
        if (x == null) return 0;
        else return x.N;
    }

    public int height() {
        return height(root);
    }
    private int height(Node x) {
        if (x == null) { return 0; }
        return Math.max(height(x.left), height(x.right)) + 1;
    }

    // distance from root to Node with given key (# of edges)
    public int path(Key key) {
        return path(root, key);
    }
    // distance from Node x to Node with given key
    private int path(Node x, Key key) {
        int cmp = key.compareTo(x.key);
        if (cmp == 0) { return 0; }
        else if (cmp < 0) { return path(x.left, key) + 1; }
        else { return path(x.right, key) + 1; }
    }

    // ----------------- get and put ---------------------

    public Value get(Key key) {
        return get(root, key);
    }
    private Value get(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
            return x.val;
        } else if (cmp < 0) {
            return get(x.left, key);
        } else {
            return get(x.right, key);
        }
    }

    public void put(Key key, Value val) {
        root = put(root, key, val);
    }
    private Node put(Node x, Key key, Value val) {
        if (x == null) {
            return new Node(key, val, 1);
        }
        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
            x.val = val;
        } else if (cmp < 0) {
            x.left = put(x.left, key, val);
        } else {
            x.right = put(x.right, key, val);
        }
        x.N = 1 + size(x.left) + size(x.right);
        return x;
    }

    // ----------------- traversals ---------------------

    public void inorder() {
        inorder(root);
    }
    private void inorder(Node x) {
        if (x == null) { return; }
        inorder(x.left);
        System.out.print(x.key + " ");
        inorder(x.right);
    }

    public Iterable<Key> levelOrder() {

        Queue<Key> keys = new LinkedList<>();
        if (root == null) { return keys; }

        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            Node x = nodes.remove();
            if (x != null) {
                keys.add(x.key);
                nodes.add(x.left);
                nodes.add(x.right);
            }
        }
        return keys;
    }

    public void printByLevels() {
        int level = 0;
        System.out.print("level 0: ");
        for (Key key : levelOrder()) {
            if (path(key) == level) {
                System.out.print(key + " ");
            } else {
                level++;
                System.out.println();
                System.out.print("level " + level + ": " + key + " ");
            }
        }
        System.out.println();
    }

    // ----------------- helper functions ----------------

    public static BST<String, Integer> buildSampleBST() throws FileNotFoundException {
        BST<String, Integer> bst = new BST<String, Integer>();
        Scanner in = new Scanner(new File("src/main/resources/tinyST.txt"));
        for (int i = 0; in.hasNext(); i++) {
            String key = in.next();
            bst.put(key, i);
        }
        return bst;
    }
    public static BST<String, Integer> buildBalancedBST() throws FileNotFoundException {
        BST<String, Integer> bst = new BST<String, Integer>();
        Scanner in = new Scanner(new File("src/main/resources/balanced.txt"));
        for (int i = 0; in.hasNext(); i++) {
            String key = in.next();
            bst.put(key, i);
        }
        return bst;
    }

    // ----------------- problems -----------------------

    // 4.2 build tree with min height from sorted array
    // idea: take median each time
    public void buildFromSortedArray(Key[] sortedArray) {
        buildFromSortedArray(sortedArray, 0, sortedArray.length);
    }
    public void buildFromSortedArray(Key[] sortedArray, int i, int j) {

        if (i >= j) {
            return;
        }

        int med = (i + j) / 2;
        put(sortedArray[med], null);
        buildFromSortedArray(sortedArray, i, med);
        buildFromSortedArray(sortedArray, med + 1, j);
    }

    public static void main(String[] args) throws FileNotFoundException {

        BST<String, Integer> bst = new BST<>();
        String[] sortedArray = {"A", "B", "C", "D", "E", "F", "G"};
        bst.buildFromSortedArray(sortedArray);
        bst.printByLevels();
    }
}











