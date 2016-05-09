package com.ilyarudyak.java.interview;

import org.junit.Before;
import org.junit.Test;
import stack.StackWithMin;

import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by ilyarudyak on 5/9/16.
 */
public class StackWithMinTest {

    public static final Integer N = 10;

    private StackWithMin<Integer> stack;
    private Random random = new Random(0);

    @Before
    public void setUp() throws Exception {
        stack = new StackWithMin<>();
    }

    @Test
    public void testMin() throws Exception {

        stack.push(5); assertEquals(5, (int) stack.min()); assertEquals(5, (int) stack.minIter());
        stack.push(4); assertEquals(4, (int) stack.min()); assertEquals(4, (int) stack.minIter());
        stack.push(6); assertEquals(4, (int) stack.min()); assertEquals(4, (int) stack.minIter());
        stack.push(2); assertEquals(2, (int) stack.min()); assertEquals(2, (int) stack.minIter());
        stack.push(3); assertEquals(2, (int) stack.min()); assertEquals(2, (int) stack.minIter());
        stack.push(1); assertEquals(1, (int) stack.min()); assertEquals(1, (int) stack.minIter());

        stack.pop(); assertEquals(2, (int) stack.min()); assertEquals(2, (int) stack.minIter());
        stack.pop(); assertEquals(2, (int) stack.min()); assertEquals(2, (int) stack.minIter());
        stack.pop(); assertEquals(4, (int) stack.min()); assertEquals(4, (int) stack.minIter());
        stack.pop(); assertEquals(4, (int) stack.min()); assertEquals(4, (int) stack.minIter());
        stack.pop(); assertEquals(5, (int) stack.min()); assertEquals(5, (int) stack.minIter());

    }

    @Test
    public void testMinWithRandomData() throws Exception {

        for (int i = 0; i < N; i++) {
            stack.push(random.nextInt(N));
            assertEquals(stack.min(), stack.minIter());
        }

        while (!stack.isEmpty()) {
            stack.pop();
            assertEquals(stack.min(), stack.minIter());
        }
    }

}















