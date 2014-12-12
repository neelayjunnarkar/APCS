package week16;

public class BST<T extends Comparable<T>> {

	private BSTNode<T> root;
	
	public BST(T datum) {
		root = new BSTNode<T>(datum);
	}
	
	public BSTNode<T> getTree() {
		return root;
	}
	
	public boolean isLeaf() {
		return root.isLeaf();
	}
	
	public void printTree() {
		root.printTree();
	}
	
	public String toString() {
		return root.toString();
	}
	
	public static void main(String[] args) throws Throwable {
		double avg = 0;
		double sum = 0;
		int c;
		for (c = 0; c < 10000; c++) {

			RandP randP = new RandP(0, 10000);
			BST<Integer> bst = new BST<>(randP.nextInt());

			for (int i = 0; i < randP.init_size(); i++) {
				bst.getTree().insert(randP.nextInt());
			}
			sum += bst.getTree().depth();
		}
		avg = sum/c;
		System.out.println("average depth: "+avg);
	}
}
