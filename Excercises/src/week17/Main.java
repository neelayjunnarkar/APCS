package week17;


public class Main {

	public static void main(String[] args) {
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		
		RandP randP = new RandP(0, 100);

		for (int i = 0; i < randP.init_size(); i++) {
			queue.add(randP.nextInt());
		}

		queue.bst.printTree();
	}
	
}
