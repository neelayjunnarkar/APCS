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
	
//	public String toString() {	
//
//	}

	
	
	public static void main(String[] args) {
		BST<Integer> bst = new BST<>(3);
		bst.getTree().insert(10);
		bst.getTree().insert(12);
		bst.getTree().insert(2);
	//	bst.printTree();
		String str = bst.getTree().toString();
		System.out.println(str);
	}
}
