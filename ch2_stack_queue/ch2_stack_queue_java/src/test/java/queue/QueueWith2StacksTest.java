package queue;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by ilyarudyak on 5/10/16.
 */
public class QueueWith2StacksTest {

    public static final int N = 100;

    private Queue<Integer> queue;
    private QueueWith2Stacks<Integer> queueWith2Stacks;

    @Before
    public void setUp() throws Exception {

        queue = new Queue<>();
        queueWith2Stacks = new QueueWith2Stacks<>();

    }

    @Test
    public void testEnqueue() throws Exception {

        Random random = new Random(0);
        for (int i = 0; i < N; i++) {
            int n = random.nextInt(N);
            queue.enqueue(n);
            queueWith2Stacks.enqueue(n);
        }

        assertEquals(queue.size(), queueWith2Stacks.size());

        while (!queueWith2Stacks.isEmpty()) {
            assertEquals(queue.dequeue(), queueWith2Stacks.dequeue());
        }

        assertEquals(queue.size(), queueWith2Stacks.size());
    }
}











