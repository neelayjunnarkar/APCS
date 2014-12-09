package week16;

public class BST<T extends Comparable<T>> {

	private BSTNode<T> root;
	
	public BST() {
		
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
	
//	public String toString() {
//	}
	
	
	
	public static void main(String[] args) {
		BST<Integer> bst = new BST<>();
		bst.getTree().setLeft(10);
		bst.printTree();
	}
}
