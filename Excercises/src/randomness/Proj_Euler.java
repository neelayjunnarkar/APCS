package randomness;

import java.math.BigInteger;

public class Proj_Euler {

	public static int execute_pr1() {
		int sum = 0;
		for (int i = 1; i < 1000; i++) {
			if (i%3 == 0 || i%5 == 0)
				sum += i;
		}
		return sum;
	}
	
	public static int fibonnaci(int n) {
		Matrix a = new Matrix(new BigInteger[][]{
				{new BigInteger("1"), new BigInteger("1")},
				{new BigInteger("1"), new BigInteger("0")}
		});
		Matrix b = new Matrix(new BigInteger[][] {
				{new BigInteger("1")},
				{new BigInteger("0")}
		});
		return Matrix.pwr(a,  n).multiply(b).matrix[1][0].intValue();
	}
	
	public static int exec_pr2() {
		int sum = 0;
		for (int i = 0; fibonnaci(i) < 4_000_000; i+=3){
			if (fibonnaci(i)%2 == 0)
				System.out.print(fibonnaci(i)+" ");
				sum += fibonnaci(i);
		}
		System.out.println();
		return sum;
	}
	
	public static void main(String[] args) {
		System.out.println(exec_pr2());
	}
}
