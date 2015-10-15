import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private Object[] container = new Object[]{};
    private int numberOfElements = 0;

    public RandomizedQueue() {
    }

    private RandomizedQueue(Object[] container, int numberOfElements) {
        this.container = container;
        this.numberOfElements = numberOfElements;
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

        addElement(item);
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

            private RandomizedQueue<Item> queue = new RandomizedQueue<>(ArrayResizer.copyArray(container), numberOfElements);

            @Override
            public boolean hasNext() {
                return !queue.isEmpty();
            }

            @Override
            public Item next() {
                return queue.dequeue();
            }

        };
    }

    private void addElement(Object element) {
        if (container.length == numberOfElements) {
            container = ArrayResizer.resize(container);
        }

        container[numberOfElements] = element;
        numberOfElements++;
    }

    private static class ArrayResizer {

        public static Object[] pickOneUpAndMerge(Object[] container, int pos) {
            Object[] newContainer = new Object[container.length - 1];
            System.arraycopy(container, 0, newContainer, 0, pos);
            System.arraycopy(container, pos + 1, newContainer, pos, container.length - pos - 1);

            return newContainer;
        }

        public static Object[] resize(Object[] container) {

            if (container.length == 0) {
                return new Object[1];
            }

            Object[] newContainer = new Object[container.length * 2];
            System.arraycopy(container, 0, newContainer, 0, container.length);

            return newContainer;
        }

        public static Object[] copyArray(Object[] container) {
            Object[] newContainer = new Object[container.length];
            System.arraycopy(container, 0, newContainer, 0, container.length);

            return newContainer;
        }
    }

}
