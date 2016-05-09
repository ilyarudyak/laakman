package com.ilyarudyak.java.interview;

import java.util.Random;

/**
 * Created by ilyarudyak on 5/9/16.
 */
public class StackSort {

    public static final int N = 10;

    private Stack<Integer> A, B;

    public StackSort() {

        A = new Stack<>();
        B = new Stack<>();
    }

    public void sort() {

        while (A.size() != N) {
            int min = getMin();
            System.out.print(min + " ");
            A.push(min);
        }
        System.out.println();
    }

    private int getMin() {

        int min = N, count = 0;

        while (!B.isEmpty()) {
            int tmp = B.pop();

            if (tmp < min) {
                if (min != N) {
                    A.push(min);
                    count++;
                }
                min = tmp;
            } else {
                A.push(tmp);
                count++;
            }
        }

        // return elements back
        for (int i = 0; i < count; i++) {
            B.push(A.pop());
        }

        return min;
    }

    public static void main(String[] args) {

        Random random = new Random(0);
        StackSort ss = new StackSort();
        for (int i = 0; i < N; i++) {
            ss.B.push(random.nextInt(N));
        }

        ss.B.show();

        ss.sort();
        ss.A.show();
    }
}














