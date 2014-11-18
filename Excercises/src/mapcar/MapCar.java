package mapcar;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Stack;

public class MapCar {

	interface Function<T> {
		T operate(T t);
	}
	
	static Function<Integer> square = new Function<Integer>() {

		@Override
		public Integer operate(Integer t) {
			return t*t;
		}
		
	};
	
	static <T>  T[] mapcar(AbstractCollection<T> vec, Function<T> fn) {
		ArrayList<T> arr = new ArrayList<>(vec.size());
		for (T t : vec) {
			t = fn.operate(t);
			arr.add(t);
		}
		return (T[]) arr.toArray();
	}

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < 10; i++)
			stack.push(i);
		Integer[] arr = mapcar(stack, square);
		for (Integer i : arr) {
			System.out.print(i+" ");
		}
			
	}
}
