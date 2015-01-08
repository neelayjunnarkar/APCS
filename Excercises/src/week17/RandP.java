package week17;

import java.util.ArrayList;

public class RandP {

	int min, max;
	ArrayList<Integer> arr;

	/**
	 * Creates a RandP object which returns values in the range [0, max], and cannot
	 * 		return the same value twice
	 * @param max
	 */
	public RandP(int max) {
		this(0, max);
	}
	
	/**
	 * Creates a RandP object which returns values in the range [min, max], and cannot
	 * 		return the same value twice
	 * @param min the minimum value (inclusive) of the range
	 * @param max the maximum value (inclusive) of the range
	 */
	public RandP(int min, int max) {
		arr = new ArrayList<Integer>();
		this.min = min;
		this.max = max;
		for (int i = 0; i <= this.max-this.min; i++) {
			arr.add(min);
			min++;
		}
	}

	/**
	 * 
	 * @return returns a random integer that has not been returned by the instance before
	 */
	public int nextInt() {
		if (arr.size() <= 0)
			return 0;
		int i = (int) (Math.random() * (arr.size()));
		int res = arr.get(i);
		arr.remove(i);
		return res;
	}

	/**
	 *  Use cases include information on whether randp is 'useless' ( unvariably returns 0)
	 * @return returns the size of the array used for randP
	 */
	int init_size() {
		return max-min+1;
	}
	
	public static void main(String[] args) {
		RandP randp = new RandP(-2, 3);
		for (int i = 0; i < randp.init_size(); i++) 
				System.out.println(randp.nextInt());
	}

}
