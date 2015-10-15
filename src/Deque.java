import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private int size = 0;
    private Node first;
    private Node last;

    public Deque() {
    }

    public static void main(String[] args) {
    }

    public boolean isEmpty() {              // is the deque empty?
        return first == null;
    }

    public int size() {                     // return the number of items on the deque
        return size;
    }

    public void addFirst(Item item)          // add the item to the front
    {
        if (item == null) throw new NullPointerException();

        if (isEmpty()) {
            addItemToEmptyDeque(item);
        } else {
            Node oldFirst = first;
            first = new Node(item, null, oldFirst);
            oldFirst.prevNode = first;
            size++;
        }
    }

    public void addLast(Item item)           // add the item to the end
    {
        if (item == null) throw new NullPointerException();

        if (isEmpty()) {
            addItemToEmptyDeque(item);
        } else {
            Node oldLast = last;
            last = new Node(item, oldLast, null);
            oldLast.nextNode = last;
            size++;
        }
    }

    public Item removeFirst()                // remove and return the item from the front
    {
        if (isEmpty()) throw new NoSuchElementException();

        Item firstItem = first.item;
        first = first.nextNode;
        if (first != null) {
            first.prevNode = null;
        } else {
            last = null;
        }

        size--;

        return firstItem;
    }

    public Item removeLast() {                 // remove and return the item from the end
        if (isEmpty()) throw new NoSuchElementException();

        Item lastItem = last.item;
        last = last.prevNode;
        if (last != null) {
            last.nextNode = null;
        } else {
            first = null;
        }

        return lastItem;
    }

    public Iterator<Item> iterator() {
        return new Iterator<Item>() {

            private Node currentNode = first;

            @Override
            public boolean hasNext() {
                return currentNode != null;
            }

            @Override
            public Item next() {
                if (currentNode == null) throw new NoSuchElementException();

                Item toReturn = currentNode.item;
                currentNode = currentNode.nextNode;

                return toReturn;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    private void addItemToEmptyDeque(Item item) {
        first = new Node(item, null, null);
        last = first;
        size++;
    }

    private class Node {
        Item item;
        Node prevNode;
        Node nextNode;

        public Node(Item item, Node prevNode, Node nextNode) {
            this.item = item;
            this.prevNode = prevNode;
            this.nextNode = nextNode;
        }
    }
}
