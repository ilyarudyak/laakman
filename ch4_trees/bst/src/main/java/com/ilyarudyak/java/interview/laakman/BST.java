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
        if (x == null) { return -1; }
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

    // ----------------- problems ------------------------

    // 4.2 build tree with min height from sorted array
    // idea: take median each time
    public void build0(Key[] sortedArray) {
        build0(sortedArray, 0, sortedArray.length);
    }
    public void build0(Key[] sortedArray, int i, int j) {

        if (i >= j) {
            return;
        }

        int med = (i + j) / 2;
        put(sortedArray[med], null);
        build0(sortedArray, i, med);
        build0(sortedArray, med + 1, j);
    }

    public void build(Key[] keys) {
        root = build(keys, 0, keys.length);
    }
    public Node build(Key[] keys, int i, int j) {

        if (i >= j) {
            return null;
        }

        int med = (i + j) / 2;
        Node x = new Node(keys[med], null, 0);
        x.left = build(keys, i, med);
        x.right = build(keys, med + 1, j);
        return x;
    }

    // princeton web 2 Given the pre-order traversal of a BST
    // (not including null nodes), reconstruct the tree.
    // This is O(N^2) method TODO add O(n) method
    public void build2(Key[] pre) {
//        root = build2(pre, 0, 0, pre.length - 1);
        root = build3(pre, 0, pre.length - 1);
    }
    public Node build2(Key[] pre, int index, int low, int high) {

        if (index >= pre.length || low > high) { return null; }

        Node x = new Node(pre[index], null, 0);
        index++;
        if (low == high) { return x; }

        int i;
        for ( i = low; i <= high; ++i ) {
            if (pre[i].compareTo(x.key) > 0) { break; }
        }

        x.left = build2(pre, index, index, i - 1);
        x.right = build2(pre, i, i, high);
        return x;
    }
    public Node build3(Key[] pre, int low, int high) {

        if (low >= pre.length || low > high) { return null; }

        Node x = new Node(pre[low], null, 0);
//        if (low == high) { return x; }

        int i;
        for ( i = low; i <= high; ++i ) {
            if (pre[i].compareTo(x.key) > 0) { break; }
        }

        x.left = build3(pre, low + 1, i - 1);
        x.right = build3(pre, i, high);
        return x;
    }

    public static void main(String[] args) throws FileNotFoundException {

        BST<String, Integer> bst = new BST<>();
        String[] keys = {"S", "E", "A", "C", "R", "H", "M", "L", "P", "X"};
        bst.build2(keys);
        bst.printByLevels();
    }
}











