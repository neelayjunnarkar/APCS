package week17;

import java.util.*;

/**
 * This implementation of a priority queue uses a binary heap stored in a 1 dimensional array to represent the queue
 * @param <T>
 */
public class PriorityQueue<T extends Comparable<T>> extends AbstractQueue<T> {

	private int size;
	private int insertion_i = 0;
	DefaultComparator<T> comparator;
	Object[] queue;

	public void print() {
		for (Object t : queue)
			if (t != null)
				System.out.print((T)t+" ");
		System.out.println();
	}
	
	PriorityQueue() {
		this(0);
	}

	PriorityQueue(int init_size) {
		size = init_size;
		queue = new Object[size];
		this.comparator = new DefaultComparator<T>();
	}
	@Override
	public Iterator<T> iterator() {
		return null;
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
		if (insertion_i >= size)
			resize(size+10);
		
		queue[insertion_i] = arg;
		sortUp(insertion_i);

		++insertion_i;
		return true;
	}

	/**
	 * Shifts the element at index node_i up the binary heap until it is greater than its parents and less than its children
	 * @param node_i
	 */
	public void sortUp(int node_i) {
		int parent = (node_i % 2 == 0) ? node_i/2 : (node_i-1)/2;
		if (node_i <= 0)
			return;

		if (comparator.compare((T)queue[node_i], (T)queue[parent]) < 0) {
			T temp = (T)queue[node_i];
			queue[node_i] = queue[parent];
			queue[parent] = temp;
			sortUp(parent);
		}

	}

	/**
	 * Resizes the priority queue to new_sz
	 * @param new_sz
	 */
	public void resize(int new_sz) {
		queue = Arrays.copyOf(queue, new_sz);
		size = new_sz;
	}
	
	/**
	 * Adds all of the elements in the specified collection to this queue
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
		if (size == 0)
			return null;
		return (T)queue[0];
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
		if (size == 0)
			return null;
        T retval = (T)queue[0];

        queue[0] = queue[insertion_i-1];
        queue[insertion_i-1] = null;
        --insertion_i;
        --size;
        if (insertion_i > 0)
            sortDown(0);
		return retval;
	}

	/**
	 * Shifts the element at node_index down the binary heap until it is less than its parents and greater than its children
	 * @param node_index
	 */
    private void sortDown(int node_index) {
        int lchld_i = node_index*2;
        int rchld_i = (node_index*2)+1;
        int min_i = lchld_i;
        T temp;
        if (rchld_i >= insertion_i) {
            if (lchld_i >= insertion_i)
                return;
            else
                min_i = lchld_i;
        } else {
           if (comparator.compare((T)queue[lchld_i], (T)queue[min_i]) > 0) // if (((T)queue[lchld_i]).compareTo((T)queue[min_i]) > 0)
                min_i = lchld_i;
            else
                min_i = rchld_i;
        }
        if (comparator.compare((T)queue[node_index], (T)queue[min_i]) > 0) {//if (((T)queue[node_index]).compareTo((T)queue[min_i]) > 0) {
            temp = (T)queue[min_i];
            queue[min_i] = (T)queue[node_index];
            queue[node_index] = temp;
            sortDown(min_i);
        }
    }

	/**
	 * Retrieves and removes the head of this queue
	 */
	public T remove() {
		return poll();
	}

	/**
	 *
	 * @param arg the element to be removed (if it is in the queue)
	 * @return returns whether arg was in this queue, and if so, if it was removed
	 */
    public boolean remove(T arg) {
        Integer node_index = null;
        for (int i = 0; i < insertion_i; ++i) {
           if (comparator.compare((T)queue[i], (T)arg) == 0) {// if (queue[i].equals(arg)) {
                node_index = i;
                break;
            } else {
                if (i == insertion_i) {
                    return false;
                }
                continue;
            }
        }
        if (node_index == null)
            return false;
        queue[node_index] = queue[insertion_i-1];
        queue[insertion_i-1] = null;
        --insertion_i;
        --size;
        if (insertion_i > 0)
            sortDown(node_index);
        return true;

    }

	/**
	 * Reverses the ordering of the priority queue
	 */
	public void reverseComparator() {
		comparator.reverse();
		Object[] arr = new Object[size];
		for (int i = 0; i < size; ++i)
			arr[i] = (T)queue[i];
		clear();
		for (Object t : arr)
			add((T)t);
	}

	/**
	 *
	 * @param arg
	 * @return returns whether arg is in this priority queue
	 */
    public boolean contains(T arg) {
        for (Object t : queue)
            if (comparator.compare((T)t, arg) == 0)//if (t.equals(arg))
                return true;
        return false;
    }

	/**
	 * Removes all elements from the queue
	 */
	public void clear() {
        for (int i = 0; i < size; ++i)
            queue[i] = null;
        size = 0;
        insertion_i = 0;
	}

	/**
	 * Returns the number of elements in this queue
	 */
	@Override
	public int size() {
		return size;
	}

}
