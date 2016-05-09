package com.ilyarudyak.java.interview;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ilyarudyak on 5/9/16.
 */
public class StackWithMinTest {

    private StackWithMin<Integer> stack;

    @Before
    public void setUp() throws Exception {
        stack = new StackWithMin<>();
    }

    @Test
    public void testMin() throws Exception {

        stack.push(5); assertEquals(5, (int) stack.min());
        stack.push(4); assertEquals(4, (int) stack.min());
        stack.push(6); assertEquals(4, (int) stack.min());
        stack.push(2); assertEquals(2, (int) stack.min());
        stack.push(3); assertEquals(2, (int) stack.min());
        stack.push(1); assertEquals(1, (int) stack.min());

        stack.pop(); assertEquals(2, (int) stack.min());
        stack.pop(); assertEquals(2, (int) stack.min());
        stack.pop(); assertEquals(4, (int) stack.min());
        stack.pop(); assertEquals(4, (int) stack.min());
        stack.pop(); assertEquals(5, (int) stack.min());

    }
}