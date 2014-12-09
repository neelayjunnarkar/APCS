package week16;

import java.util.Iterator;

public class BSTNode<T extends Comparable<T>> {

	private T datum;
	private BSTNode<T> left, right;
	
	public BSTNode(T datum) {
		left = new BSTNode<T>(null);
		
	}
	
	public T getDatum() {
		return datum;
	}
	
	public BSTNode<T> getLeft() {
		return left;
	}
	
	public BSTNode<T> getRight() {
		return right;
	}
	
	public boolean isLeaf() {
		if (right == null && left == null)
			return true;
		return false;
	}
	
	public void insert(T datum) {
		
	}
	
	public void setLeft(T datum) {
		left.datum = datum;
	}
	
	public void setRight(T datum) {
		right.datum = datum;
	}
	
//	public T delete(T datum) {
//		
//	}
	
	public void printTree() {
		if (isLeaf())
			System.out.print("["+datum+"]");
		else if (left == null && right != null)
			right.printTree();
		else if (right == null && left != null)
			left.printTree();
		else if (right != null && left != null) {
			left.printTree();
			right.printTree();
		}
			
	}
	
//	public void toString() {
//		
//	}

	
	
}
