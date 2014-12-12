package week16;

public class BSTNode<T extends Comparable<T>> {

	private T datum;
	private BSTNode<T> left, right;
	
	public BSTNode(T datum) {
		this.datum = datum;
	}
	
	public T getDatum() {
		return datum;
	}
	
	public void setDatum(T datum) {
		this.datum = datum;
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
	
	/**
	 * 
	 * @param datum data to be inserted
	 * @return returns whether insertion succeeded
	 */
	public boolean insert(T datum) {
		if (datum.compareTo(this.datum) > 0) {
			if (right == null)
				right = new BSTNode<T>(datum);
			else
				right.insert(datum);

			return true;
		} else if (datum.compareTo(this.datum) < 0) {
			
			if (left == null)
				left = new BSTNode<T>(datum);
			else
				left.insert(datum);
			
			return true;
		} else if (datum.compareTo(this.datum) == 0) {
			return false;
		}
		return false;
	}
	
	public void setLeft(T datum) {
		if (left == null) {
			left = new BSTNode<T>(datum);
			return;
		}
		left.datum = datum;
	}
	
	public void setRight(T datum) {
		if (right == null) {
			right = new BSTNode<T>(datum);
			return;
		}
		right.datum = datum;
	}
	
//	public T delete(T datum) {
//		
//	}
	
	public void printTree() {
		System.out.print("["+datum+"]");
		
		if (left == null && right != null)
			right.printTree();
		else if (right == null && left != null)
			left.printTree();
		else if (right != null && left != null) {
			left.printTree();
			right.printTree();
		}
			
	}
	
	public String toString() {
		
		String str = "";
		str += "["+datum+"]";
		
		if (left == null && right == null )
			return str;
		
		if (left != null)
			str += left.toString();
		
		if (right != null)
			str += right.toString();
		
		return str;
	}

}
