package proj_euler;

public class Prob_1 {

	public static int execute_pr1() {
		int sum = 0;
		for (int i = 1; i < 1000; i++) {
			if (i%3 == 0 || i%5 == 0)
				sum += i;
		}
		return sum;
	}
	
	
	
	public static void main(String[] args) {
		System.out.println(execute_pr1());
	}
}
