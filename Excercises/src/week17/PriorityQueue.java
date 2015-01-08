package week17;

import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

public class PriorityQueue<T extends Comparable<T>> extends AbstractQueue<T> {

	private int size;
	private Comparator<T> comparator;
	BST<T> bst;

	PriorityQueue() {
		this(0, null);
	}

	PriorityQueue(int init_size, Comparator<T> comparator) {
		size = init_size;
		this.comparator = comparator;
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
		if (size == 0) {
			bst = new BST<>(arg);
		}
		bst.getTree().insert(arg);
		++size;
		return true;
	}

	
	/**
	 * Adds all of the elements in the specified collection to this queue
	 * @param c
	 * @return
	 */
	public boolean addAll(Collection<? extends T> c) {
		for (T t : c) {
			bst.getTree().insert(t);
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
		return bst.getTree().getDatum();
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
		
		T retval = bst.getTree().getDatum();
		
		try {
			bst.getTree().delete(retval);
		} catch (Throwable e) {
			System.out.println("failed poll");
			e.printStackTrace();
		}
		
		--size;
		
		return retval;
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
