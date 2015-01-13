package week17;

import week16.*;

public class Main {


	public static void main(String[] args) throws InterruptedException {

		PriorityQueue<Integer> queue = new PriorityQueue<>(10, null);

		for (int i = 0; i < 10; ++i)
			queue.add(i);

		queue.print();
		//System.out.println("peek: "+queue.peek());
		System.out.println("size: "+queue.size());
		queue.poll();
		queue.print();

	}
	
}