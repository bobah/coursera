import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RandomizedQueueTest {

    private RandomizedQueue<String> queue;

    @Before
    public void setUp() throws Exception {
        queue = new RandomizedQueue<>();
    }

    @Test
    public void testIsEmpty() throws Exception {
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testSizeIsZeroInEmptyQueue() throws Exception {
        assertEquals(queue.size(), 0);
    }

    @Test
    public void testEnqueue() throws Exception {
        queue.enqueue("1");

        assertEquals(queue.size(), 1);

        queue.enqueue("2");

        assertEquals(queue.size(), 2);
    }

    @Test
    public void testDequeue() throws Exception {

        queue.enqueue("1");
        queue.enqueue("2");

        assertEquals(queue.size(), 2);

        queue.dequeue();

        assertEquals(queue.size(), 1);
    }

    @Test
    public void testSample() throws Exception {
        queue.enqueue("1");

        assertEquals(queue.size(), 1);

        assertEquals(queue.sample(), "1");
        assertEquals(queue.size(), 1);
    }

    @Test
    public void randomizedTest() throws Exception {

        queue.size();
        queue.enqueue("316");
        queue.dequeue();
        queue.enqueue("61");
        queue.dequeue();
        queue.enqueue("800");
        queue.enqueue("513");
        queue.dequeue();
        queue.dequeue();
        queue.size();

        assertTrue(queue.isEmpty());
    }

    @Test(expected = NullPointerException.class)
    public void testNPE() throws Exception {

        queue.enqueue(null);

    }

    @Test
    public void testIteratorOnEmptyQueue() throws Exception {
        RandomizedQueue<Integer> q = new RandomizedQueue<>();
        q.iterator();
    }

    @Test
    public void testIterator() throws Exception {
        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");
        queue.enqueue("4");
        queue.enqueue("5");

        for (String s : queue) {
            System.out.println(s);
        }

        System.out.println("==============");

        for (String s : queue) {
            System.out.println(s);
        }
    }

    @Test
    public void testArraySizing() throws Exception {
        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");
        queue.enqueue("4");
        queue.enqueue("5");

        System.out.println("==============");

        System.out.print(queue.dequeue());
        System.out.print(queue.dequeue());
        System.out.print(queue.dequeue());
        System.out.print(queue.dequeue());
        System.out.print(queue.dequeue());
    }
}