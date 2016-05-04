package com.ilyarudyak.java.interview.laakman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

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

    // return number of key-value pairs in BST rooted at x
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

    // it seems - the main idea not to use standard methods
    // (put(), height() etc. ) but to augment them

    // 4.1 check if tree (BT, not BST) is balanced
    // this is O(N^2) and is ineffective (multiple calls to height)
    private boolean isBalanced() {
        return isBalanced(root) && isBalanced(root.left) && isBalanced(root.right);
    }
    private boolean isBalanced(Node x) {
        if (x == null) { return true; }
        return Math.abs(height(x.left) - height(x.right)) <= 1;
    }

    // this is an efficient implementation O(N)
    // we check balance inside height
    private boolean isBalanced2() {
        if (getHeight(root) == -1) { return false; }
        return true;
    }
    private int getHeight(Node x) {

        if (x == null) { return 0; }

        int lh = getHeight(x.left);
        if (lh == -1) { return -1; }

        int rh = getHeight(x.right);
        if (rh == -1) { return -1; }

        if (Math.abs(lh - rh) > 1) { return -1; }

        return Math.max(lh, rh) + 1;
    }


    // 4.3 build tree with min height from sorted array
    // idea: take median each time
    // here we just use put() but this is ineffective
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

    // and here we actually build tree top-down
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
    // this is like build2 but without index
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

    // 4.4 level-by-level traversal
    // using BFS
    public void levelByLevel() {

        Map<Node, Integer> distTo = new HashMap<>();
//        Map<Node, Boolean>  marked = new HashMap<>();

        Queue<Node> q = new LinkedList<>();

        distTo.put(root, 0);
//        marked.put(root, true);
        q.add(root);
        System.out.print("level0: " + root.key);

        int level = 0;

        while (!q.isEmpty()) {
            Node v = q.remove();

            List<Node> children = Arrays.asList(v.left, v.right);
            for (Node w : children) {
                if (w != null /*&& !marked.containsKey(w)*/) {
                    distTo.put(w, distTo.get(v) + 1);
//                    marked.put(w, true);
                    q.add(w);

                    if (distTo.get(w) > level) {
                        level++;
                        System.out.println();
                        System.out.print("level" + level + ": ");
                    }
                    System.out.print(w.key + " ");
                }
            }

        }
        System.out.println();
    }
    private void levelByLevelRec() {
        int h = height(root);
        int i;
        for (i=0; i<=h; i++) {
            System.out.print("level" + i + ": ");
            levelByLevelRec(root, i);
            System.out.println();
        }
    }
    public void levelByLevelRec(Node x ,int level) {
        if (x == null)
            return;
        if (level == 0)
            System.out.print(x.key + " ");
        else if (level > 0) {
            levelByLevelRec(x.left, level-1);
            levelByLevelRec(x.right, level-1);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {

        BST<String, Integer> bst = buildSampleBST();
        bst.levelByLevel();
        System.out.println();
        bst.levelByLevelRec();


    }
}











