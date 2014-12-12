package proj_euler;

public class Prob_6 {

	
	public static long sum_of_squares(int min, int max) {
		long sum = 0;
		for (int i = 1; i <= max; i++)
			sum += i*i;
		return sum;
	}
	
	public static long square_of_sums(int min, int max) {
		long sum = 0;
		for (int i = 1; i <= max; i++)
			sum += i;
		return sum*sum;
	}
	
	public static void main(String[] args) {
		System.out.println("sum_of_squares: "+sum_of_squares(1, 100));
		System.out.println("square_of_sums: "+square_of_sums(1, 100));
		System.out.println(square_of_sums(1, 100)-sum_of_squares(1, 100));	
	}
}

