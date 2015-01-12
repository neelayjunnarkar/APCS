package week17;

import java.util.AbstractQueue;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class PriorityQueue<T extends Comparable<T>> extends AbstractQueue<T> {

	private int size;
	private int insertion_i = 0;
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
		if (insertion_i > 0) {

			sortUp(insertion_i);
		}

		++insertion_i;
		return true;
	}
	
	public void sortUp(int index) {
		int parent = (index % 2 == 0) ? index/2 : (index-1)/2;
		print();
		if (index <= 0)
			return;

		if (((T)queue[index]).compareTo((T)queue[parent]) < 0) {
			T temp = (T)queue[index];
			queue[index] = queue[parent];
			queue[parent] = temp;
			sortUp(parent);
		}

	}
	
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
		return null;
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
		
		return null;
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
