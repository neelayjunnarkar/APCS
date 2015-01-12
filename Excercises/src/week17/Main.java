package week17;


public class Main {

	public static void main(String[] args) {
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		
	//	RandP randP = new RandP(0, 10);

		for (int i = 10; i > 0; i--) {
			queue.add(i);
		}
		
		queue.print();

	}
	
}
