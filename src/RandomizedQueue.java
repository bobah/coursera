import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private Object[] container = new Object[]{};
    private int numberOfElements = 0;

    public RandomizedQueue() {
    }

    private RandomizedQueue(Object[] container) {
        this.container = container;
    }

    public boolean isEmpty() {
        return numberOfElements == 0;
    }

    public int size() {
        return numberOfElements;
    }

    public void enqueue(Item item) {

        if (item == null)
            throw new NullPointerException();

        if (isEmpty()) {
            container = new Object[]{item};
        } else {
            container = ArrayResizer.addElement(container, item);
        }

        numberOfElements++;
    }

    public Item dequeue() {
        if (isEmpty())
            throw new NoSuchElementException();

        int pos = StdRandom.uniform(numberOfElements);

        Item value = (Item) container[pos];

        container = ArrayResizer.pickOneUpAndMerge(container, pos);

        numberOfElements--;

        return value;
    }

    public Item sample() {
        if (isEmpty())
            throw new NoSuchElementException();

        int pos = StdRandom.uniform(numberOfElements);

        return (Item) container[pos];
    }

    @Override
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {

            private RandomizedQueue<Item> queue = new RandomizedQueue<>(ArrayResizer.copyArray(container));

            @Override
            public boolean hasNext() {
                return queue.size() > 0;
            }

            @Override
            public Item next() {
                return queue.dequeue();
            }

        };
    }

    private static class ArrayResizer {

        public static Object[] pickOneUpAndMerge(Object[] container, int pos) {
            Object[] newContainer = new Object[container.length - 1];
            System.arraycopy(container, 0, newContainer, 0, pos);
            System.arraycopy(container, pos + 1, newContainer, pos, container.length - pos - 1);

            return newContainer;
        }

        public static Object[] addElement(Object[] container, Object element) {

            Object[] newContainer = new Object[container.length + 1];
            System.arraycopy(container, 0, newContainer, 0, container.length);
            newContainer[newContainer.length - 1] = element;

            return newContainer;
        }

        public static Object[] copyArray(Object[] container) {
            Object[] newContainer = new Object[container.length];
            System.arraycopy(container, 0, newContainer, 0, container.length);

            return newContainer;
        }
    }

}
