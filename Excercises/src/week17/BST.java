package week17;

public class BST<T extends Comparable<T>> {

	/**
	 * The root node of the binary search tree
	 */
	private BSTNode<T> root;

	/**
	 * Creates a binary search tree which consists of a single node--the root-which has the value of datum
	 * @param datum the datum of the root of the binary search tree
	 */
	public BST(T datum) {
		root = new BSTNode<T>(datum);
	}

	/**
	 *
	 * @return returns the root node of the binary search tree
	 */
	public BSTNode<T> getTree() {
		return root;
	}

	/**
	 *
	 * @return returns whether the root node has any branching nodes--false if it does
	 */
	public boolean isLeaf() {
		return root.isLeaf();
	}

	/**
	 * Prints the tree in the format of a sorted list of T
	 */
	public void printTree() {
		root.printTree();
	}

	/**
	 * Used for system.out.print
	 * @return returns the tree in the format of a sorted list of T
	 */
	public String toString() {
		return root.toString();
	}
	
//	public static void main(String[] args) throws Throwable {
//		double avg = 0;
//		double sum = 0;
//		int c;
//		for (c = 0; c < 10000; c++) {
//
//			RandP randP = new RandP(0, 10000);
//			BST<Integer> bst = new BST<>(randP.nextInt());
//
//			for (int i = 0; i < randP.init_size(); i++) {
//				bst.getTree().insert(randP.nextInt());
//			}
//			sum += bst.getTree().depth();
//		}
//		avg = sum/c;
//		System.out.println("average depth: "+avg);
//	}
}
