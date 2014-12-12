package proj_euler;

import java.util.ArrayList;
import java.util.Collections;

public class Prob_4 {

	public static boolean isPalind(Integer n) {
		char[] str = n.toString().toCharArray();
		int begin = 0, end = n.toString().length()-1;
		while (begin <= end) {
			if (str[begin] != str[end])
				return false;
				begin++;
				end--;
		}
		return true;
	}
	
	public static void main(String[] args) {
		boolean breaker = false;
		for (int n = 999; n > 0; n--) {
			for (int k = n; k >= n-1; k--) {
				if (isPalind(n*k)) {
					System.out.println(""+n+"*"+k+" = "+n*k);
					breaker = true;
					break;
				}
			}
			if (breaker)
				break;
		}
		
		ArrayList<Integer> arr = new ArrayList<Integer>();

		for (int n = 999; n > 0; n--) {
			for (int k = n; k > 0; k--) {
				if (isPalind(n*k)) {
					arr.add(n*k);
				}
			}
		}
		
		Collections.sort(arr);
		
		System.out.println(arr.get(arr.size()-1));
	}
}
