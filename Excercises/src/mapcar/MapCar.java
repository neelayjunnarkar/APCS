package mapcar;


import java.util.*;

public class MapCar {

    /**
     * A Function interface which all Functions must implement
     * @param <T> Type which the function operates on eg. Integer
     */
    interface Function<T> {
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
    static Function<Integer> double_elem = new Function<Integer>() {
        @Override
        public Integer operate(Integer i) {
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
        Stack<Integer> arr = new Stack<Integer>();
        for (int i = 0; i < 10; i++)
            arr.add(i);

        System.out.print("original array:  ");
        for (int i : arr)
            System.out.print(i + " ");
        System.out.println();

        System.out.print("after squared:   ");
        arr = (Stack<Integer>)mapcar(arr, square);
        for (int i : arr)
            System.out.print(i + " ");
        System.out.println();

        System.out.print("after add_one:   ");
        arr = (Stack<Integer>)mapcar(arr, add_one);
        for (int i : arr)
            System.out.print(i + " ");
        System.out.println();

        System.out.print("after doubled:   ");
        arr = (Stack<Integer>)mapcar(arr, double_elem);
        for (int i : arr)
            System.out.print(i + " ");
    }
}