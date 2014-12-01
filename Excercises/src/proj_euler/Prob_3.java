package proj_euler;

import java.util.ArrayList;

/*
 * Largest Prime Factor of n
 */
public class Prob_3 {

	static ArrayList<Double> primes = new ArrayList<>();
	public static boolean isPrime(double n) {

		if (n == 2 || n == 3)
			return true;
		double upper_bound = (double) Math.floor(Math.sqrt(n));
		for (double i : primes) {
			if (n%i == 0)
				return false;
		}
		for (double i = (primes.get(primes.size()-1)%2 == 0) ? primes.get(primes.size()-1)-1 : primes.get(primes.size()-1); i <= upper_bound; i+=2) {
			if (n%i == 0)
				return false;
		}
		
		primes.add(n);
		return true;
	}
	public static double exec_pr3(double n) {
		double upper_bound = (double) Math.floor(Math.sqrt(n));
		double i = 1;
		for (i = upper_bound; i > 0; i--) {
			
			if(n%i == 0 && isPrime(i)) {
				break;
			}
		}

		return i;

		
	}
	public static void main(String[] args) {
		primes.add((double) 2);
		primes.add((double) 3);
		System.out.println(exec_pr3((double)600851475143.0));

	}
}
