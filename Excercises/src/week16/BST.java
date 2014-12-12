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
	
	public static void main(String[] args) {
		BST<Integer> bst = new BST<>(5);
		for (int i = 0; i < 10; i+=1)
			bst.getTree().insert(i);
		bst.printTree();
		System.out.println();
		int i = bst.getTree().depth();
		System.out.println("i: "+i);
	}
}
