package week17;

import java.util.*;

public class PriorityQueue<T extends Comparable<T>> extends AbstractQueue<T> {

    private int size = 0;
    private int insertion_i = 0;
    private Comparator<T> comparator;
    ArrayList<Object> arr;

    public void print() {
        for (int i = 0; i < size; ++i) {
            System.out.print((T) arr.get(i) + " ");
        }
        System.out.println();
    }


    PriorityQueue() {
        this(0, null);
    }

    PriorityQueue(int init_size, Comparator<T> comparator) {
        this.comparator = comparator;
        arr = new ArrayList<>(init_size);
        for (int i = 0; i < init_size; ++i)
            arr.add(i, null);
    }

    /**
     * Inserts the specified element into this priority queue
     */
    @Override
    public boolean offer(T arg) {
        return add(arg);
    }

    /**
     * Inserts the specified element into this queue if possible
     */
    public boolean add(T arg) {

        if (insertion_i + 1 >= arr.size()) {
            arr.add(insertion_i, arg);
            ++insertion_i;
            ++size;
            return true;
        }

        arr.set(insertion_i, arg);

        int temp_i = insertion_i;
        int parent_i = (temp_i % 2 == 0) ? temp_i / 2 : (temp_i - 1) / 2;
        while (temp_i != 0) {
            parent_i = (temp_i % 2 == 0) ? temp_i / 2 : (temp_i - 1) / 2;
            if (((T) arr.get(parent_i)).compareTo((T) arr.get(temp_i)) > 0) {
                T temp = (T) arr.get(parent_i);
                arr.set(parent_i, (T) arr.get(temp_i));
                arr.set(temp_i, temp);
                temp_i = parent_i;
            } else {
                break;
            }

        }

        if (insertion_i - 1 >= 0 && ((T) arr.get(insertion_i)).compareTo((T) arr.get(insertion_i - 1)) < 0) {
            T temp = (T) arr.get(insertion_i);
            arr.set(insertion_i, (T) arr.get(insertion_i - 1));
            arr.set(insertion_i - 1, temp);
        }

        ++insertion_i;
        ++size;
        return true;
    }


    /**
     * Adds all of the elements in the specified collection to this queue
     *
     * @param c
     * @return
     */
    public boolean addAll(Collection<? extends T> c) {
        for (T t : c) {
            add(t);
        }
        return true;
    }

    /**
     * Retrieves, but does not remove, the head of this queue
     */
    @Override
    public T peek() {
        if (size == 0) {
            return null;
        }
        return (T) arr.get(0);
    }

    /**
     * Retrieves, but does not remove, the head of this queue
     */
    public T element() {
        return peek();
    }

    /**
     * Retrieves and removes the head of this queue
     */
    @Override
    public T poll() {
        if (size == 0) {
            return null;
        }
        int s = --size;
        T retval = (T)arr.get(0);
        T x = (T)arr.get(s);
        if (s != 0)
            siftDown(0, x);
        return retval;

    }

    private void siftDown(int nodeIndex, T x) {
        int half = size/2;
        while (nodeIndex < half) {
            int child = nodeIndex*2+1;
            T c = (T)arr.get(child);
            int right = child + 1;
            if (right < size && c.compareTo((T)arr.get(right)) > 0)
                c = (T)arr.get(child = right);
            if (x.compareTo(c) <= 0)
                break;
            arr.set(nodeIndex, c);
            nodeIndex = child;
        }
        arr.set(nodeIndex, x);
    }

    /**
     * Retrieves and removes the head of this queue
     */
    public T remove() {
        return poll();
    }

    /**
     * Removes all elements from the queue
     */
    public void clear() {

    }

    /**
     * Returns the comparator used to order the elements in this queue
     *
     * @return comparator<T>
     */
    public Comparator<T> comparator() {
        return comparator;
    }

    /**
     * Returns an iterator over the elements in this queue
     */
    @Override
    public Iterator<T> iterator() {

        return null;
    }

    /**
     * Returns the number of elements in this queue
     */
    @Override
    public int size() {
        return size;
    }

}
