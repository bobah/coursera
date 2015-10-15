import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class DequeTest {

    private Deque<String> deque;

    @Before
    public void setUp() throws Exception {
        deque = new Deque<>();
    }

    @Test
    public void testEmptyDeque() throws Exception {

        assertTrue("Queue should be empty", deque.isEmpty());
        assertEquals("Size should be empty", deque.size(), 0);

    }

    @Test
    public void testDequeContainsOneItemAfterAddFirst() throws Exception {

        deque.addFirst("Preved");

        assertFalse(deque.isEmpty());
        assertEquals(deque.size(), 1);

    }

    @Test
    public void testDegueContainsOneItemAfterAddLast() throws Exception {

        deque.addLast("Preved");

        assertFalse(deque.isEmpty());
        assertEquals(deque.size(), 1);

    }

    @Test
    public void testAddFirstAndLast() throws Exception {

        fillDeque();

        assertEquals(deque.size(), 4);

        assertEquals(deque.removeFirst(), "1");
        assertEquals(deque.removeFirst(), "2");
        assertEquals(deque.removeFirst(), "9");
        assertEquals(deque.removeFirst(), "10");
        assertTrue(deque.isEmpty());
    }


    @Test
    public void testIterator() throws Exception {

        fillDeque();

        Iterator<String> iterator = deque.iterator();

        assertTrue(iterator.hasNext());
        assertEquals(iterator.next(), "1");
        assertEquals(iterator.next(), "2");
        assertEquals(iterator.next(), "9");
        assertTrue(iterator.hasNext());
        assertEquals(iterator.next(), "10");
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testIterator2() throws Exception {

        deque.addFirst("A");
        deque.addFirst("B");


        Iterator<String> iterator = deque.iterator();

        assertTrue(iterator.hasNext());
        assertEquals(iterator.next(), "B");
        assertEquals(iterator.next(), "A");
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testAddFirstRemoveLast() throws Exception {

        deque.addFirst("a");
        deque.removeLast();

        assertTrue(deque.isEmpty());

    }

    @Test
    public void testRemoveLast() throws Exception {

        fillDeque();

        assertEquals(deque.removeLast(), "10");
        assertEquals(deque.removeLast(), "9");

    }

    @Test
    public void randomizedTest() throws Exception {

        deque.addLast("0");
        deque.removeLast();
        deque.isEmpty();
        deque.isEmpty();

        assertEquals(deque.size(), 0);

    }

    private void fillDeque() {
        deque.addFirst("2");
        deque.addFirst("1");
        deque.addLast("9");
        deque.addLast("10");
    }
}