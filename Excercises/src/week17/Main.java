package week17;

import java.util.Comparator;

public class Main {

	public static void main(String[] args) {
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		
		RandP randP = new RandP(0, 10);

		for (int i = 10; i > 0; i--) {
			queue.add(randP.nextInt());
		}

		queue.print();

		queue.poll();
		queue.print();

		queue.reverseComparator();
		queue.print();

		queue.poll();
		queue.print();

		queue.remove(6); //if 6 is not present within the queue, nothing will be removed
		queue.print();

	}
	
}
