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
	
	public void delete(T datum) throws Throwable {
		if (datum.compareTo(this.datum) == 0) {
			if (!isLeaf()) {
				shift();
				return;
			} else
				throw new Throwable("deleting self from leaf");
		} else if (datum.compareTo(this.datum) < 0) {
			if (left != null) {
				if (left.datum.compareTo(datum) == 0) {
					if (left.isLeaf()) {
						left = null;
						return;
					} else {
						left.shift();
						return;
					}
				} else
					left.delete(datum);
			} else
				throw new Throwable("datum "+datum+" not in bst");
		} else if (datum.compareTo(this.datum) > 0) {
			if (right != null) {
				if (right.datum.compareTo(datum) == 0) {
					if (right.isLeaf()) {
						right = null;
						return;
					} else {
						right.shift();
						return;
					}
				} else
					right.delete(datum);
			} else
				throw new Throwable("datum "+datum+" not in bst");
		}
	}

	private void shift() {
		if (right == null && left != null) {
			datum = left.datum;
			if (left.isLeaf())
				left = null;
			else
				left.shift();
		} else if (right != null){
			datum = right.datum;
			if (right.isLeaf())
				right = null;
			else
				right.shift();
		}
	}

	public void printTree() {
		System.out.print(toString());
	}
	
	public String toString() {
		
		String str = "";

		if (isLeaf()) {
			str += datum + " ";
		} else if (left == null && right != null) {
			str += datum + " ";
			str += right.toString();
		} else if (left != null && right == null) {
			str += left.toString();
			str += datum + " ";
		} else if(left != null && right != null) {
			str += left.toString();
			str += datum + " ";
			str += right.toString();
		}
		return str;
	}

	public int depth() {
		if(isLeaf()) {
			return 1;
		} else if (left == null && right != null) {
			return 1 + right.depth();
		} else if (left != null && right == null) {
			return 1 + left.depth();
		} else if (left != null && right != null) {
			int leftd = left.depth();
			int rightd = right.depth();
			return 1 + ((leftd >= rightd) ? leftd : rightd);
		}
		return -1; //error value
	}

}
