package proj_euler;

public class Prob_5 {

	public static long factorial(long n) {
		if (n == 1)
			return 1;
		else {
			return n*factorial(n-1);
		}
	}
	public static void main(String[] args) {
		
		double[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
		
		double n = 20;
		while (true) {
			int c = 0;
			for (double i : arr) {
				if (n % i == 0)
					c++;
				else
					break;
			}
			if (c == 20)
				break;
			n += 20;
	}
		System.out.println(n);

		System.out.println(factorial(20));
		
		if (n < factorial(20))
			System.out.println("less");
	
	}
	
}
