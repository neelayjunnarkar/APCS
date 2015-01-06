package week17;

import java.util.AbstractQueue;
import java.util.Comparator;
import java.util.Iterator;

public class PriorityQueue<T extends Comparable> extends AbstractQueue<T> {

	private int size;
	private Comparator<? super T> comparator;
	
	PriorityQueue() {
		this(0, null);
	}
	
	PriorityQueue(int init_size, Comparator<? super T> comparator) {
		size = init_size;
		this.comparator = comparator;
	}
	
	@Override
	public boolean offer(T arg) {
		
		return false;
	}

	@Override
	public T peek() {
		
		return null;
	}

	@Override
	public T poll() {
		
		return null;
	}

	@Override
	public Iterator<T> iterator() {
		
		return null;
	}

	@Override
	public int size() {
		return size;
	}

}
