package com.ilyarudyak.java.interview.laakman;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ilyarudyak on 5/3/16.
 */
public class BSTTest {

    private BST<String, Integer> bst;

    @Before
    public void setUp() throws Exception {
        bst = new BST<>();
    }

    @Test
    public void testBuild0() throws Exception {

        String[] sortedArray = {"A", "B", "C", "D", "E", "F", "G"};
        bst.build0(sortedArray);
        assertEquals(7, bst.size());
        assertEquals(2, bst.height());
        assertEquals(1, bst.path("B"));
        assertEquals(2, bst.path("A"));
    }

    @Test
    public void testBuild() throws Exception {

        String[] sortedArray = {"A", "B", "C", "D", "E", "F", "G"};
        bst.build(sortedArray);
//        assertEquals(7, bst.size());
        assertEquals(2, bst.height());
        assertEquals(1, bst.path("B"));
        assertEquals(2, bst.path("A"));
    }
}