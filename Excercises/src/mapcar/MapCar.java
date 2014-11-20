package mapcar;

import java.text.DecimalFormat;
import java.util.*;

public class MapCar {

    /**
     * A Function interface which all Functions must implement
     * @param <T> Type which the function operates on eg. Integer
     */
    interface Function<T> {
    	
    	/**
    	 * This method must be called to do the specified operations on the parameter t
    	 * @param t parameter
    	 * @return
    	 */
        T operate(T t);
    }

    /**
     * A square Function which implements the Function<T> interface
     */
    static Function<Integer> square = new Function<Integer>() {
        @Override
        public Integer operate(Integer i) {
            return i*i;
        }
    };

    /**
     * A Function which implements the Function<T> interface and adds 1 to the element
     */
    static Function<Integer> add_one = new Function<Integer>() {
        @Override
        public Integer operate(Integer i) {
            return i+1;
        }
    };

    /**
     * A Function which implements the Function<T> interface and doubles the element
     */
    static Function<Double> double_elem = new Function<Double>() {
        @Override
        public Double operate(Double i) {
            return i*2;
        }
    };


    /**
     * A specialized mapcar that operates on hashsets
     * @param coll HashSet
     * @param fn Function
     * @param <T> Type
     * @return Returns a AbstractCollection<T> which is the result of operating fn on every element of coll
     */
    static <T> AbstractCollection<T> mapcar(HashSet<T> coll, Function<T> fn) {
        AbstractCollection<T> list = new HashSet<>();
        for (T t : coll) {
            list.add(fn.operate(t));
        }
        return list;
    }
    
    /**
     * A specialized mapcar that operates on arraylists
     * @param coll ArrayList
     * @param fn Function
     * @param <T> Type
     * @return Returns a AbstractCollection<T> which is the result of operating fn on every element of coll
     */
    static <T> AbstractCollection<T> mapcar(ArrayList<T> coll, Function<T> fn) {
        AbstractCollection<T> list = new ArrayList<>();
        for (T t : coll) {
            list.add(fn.operate(t));
        }
        return list;
    }

    /**
     * A specialized mapcar that operates on stacks
     * @param coll Stack
     * @param fn Function
     * @param <T> Type
     * @return Returns a AbstractCollection<T> which is the result of operating fn on every element of coll
     */
    static <T> AbstractCollection<T> mapcar(Stack<T> coll, Function<T> fn) {
        AbstractCollection<T> list = new Stack<>();
        for (T t : coll) {
            list.add(fn.operate(t));
        }
        return list;
    }

    /**
     * A specialized mapcar that operates on linkedlists
     * @param coll LinkedList
     * @param fn Function
     * @param <T> Type
     * @return Returns a AbstractCollection<T> which is the result of operating fn on every element of coll
     */
    static <T> AbstractCollection<T> mapcar(LinkedList<T> coll, Function<T> fn) {
        AbstractCollection<T> list = new LinkedList<>();
        for (T t : coll) {
            list.add(fn.operate(t));
        }
        return list;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < 10; i++)
            stack.add(i);

        System.out.print("Stack of Integers:  ");
        for (int i : stack)
            System.out.print(i + " ");
        System.out.println();

        System.out.print("after squared:   ");
        stack = (Stack<Integer>)mapcar(stack, square);
        for (int i : stack)
            System.out.print(i + " ");
        System.out.println();

        System.out.print("after add_one:   ");
        stack = (Stack<Integer>)mapcar(stack, add_one);
        for (int i : stack)
            System.out.print(i + " ");
        System.out.println();

       	DecimalFormat df = new DecimalFormat("#.00"); // used to round decimals to 2 digits after the decimal when printing
       	
        ArrayList<Double> arr = new ArrayList<Double>();
        for (double i = 1.1; i < 32.2; i += 1.21)
        		arr.add(i);
        System.out.print("ArrayList of doubles (rounded to 2 digits after the decimal): ");
        for (double i : arr)
        	System.out.print(df.format(i)+ " ");
        System.out.println();
              	
        System.out.print("after doubled (rounds to 2 digits after decimal):   ");
        arr = (ArrayList<Double>)mapcar(arr, double_elem);
        for (double i : arr)
            System.out.print(df.format(i)+ " ");
    }
}
