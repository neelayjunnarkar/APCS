package AS_1;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 * @author Neelay Junnarkar
 */
public class Main {

    /**

    f(n) = f(n-1) + 2*f(n-2) + 3*f(n-3)
    Efficicently finds f(n) by using matrices
    Matrix equation for finding f(n+1), f(n), and f(n-1): (equation found by Neelay Junnarkar)
     _      _     _     _      _   _
    | f(n+1) |   | 1 2 3 |^n  |  3  |
    | f(n)   | = | 1 0 0 |    |  3  |
    | f(n-1) |   | 0 1 0 |    | -2  |
    |_      _|   |_     _|    |_   _|

     */
    public static BigInteger fn_matrix(int n) {
        Matrix ma = new Matrix(new BigInteger[][]{                                //  _     _
                {new BigInteger("1"), new BigInteger("2"), new BigInteger("3")},  // | 1 2 3 |
                {new BigInteger("1"), new BigInteger("0"), new BigInteger("0")},  // | 1 0 0 |
                {new BigInteger("0"), new BigInteger("1"), new BigInteger("0")}});// | 0 1 0 |
        Matrix mb = new Matrix(new BigInteger[][]{                  //  _   _     // |_     _|
                {new BigInteger("3")},                              // |  3  |
                {new BigInteger("3")},                              // |  3  |
                {new BigInteger("-2")}});                           // | -2  |
        return Matrix.pwr(ma, n).multiply(mb).matrix[1][0];         // |_   _|
    }

    /**
     * Uses recursion to calculate f(n)
     * @param n f(n) where f(n) = f(n-1)+2*f(n-2)+3*f(n3)
     * @return returns f(n)
     */
    public static BigInteger fn_recurse(int n) {
        if (n < 3) {
            return new BigInteger("3");
        } else {
            return fn_recurse(n-1).add(fn_recurse(n-2).multiply(new BigInteger("2")).add(fn_recurse(n-3).multiply(new BigInteger("3"))));
        }
    }

    /**
     * Iteratively finds f(n) where f(n) = f(n-1)+2*f(n-2)+3*f(n-3)
     * @param n f(n) f(n) where f(n) = f(n-1)+2*f(n-2)+3*f(n-3)
     * @return f(n)
     */
    public static BigInteger fn_iterative(int n) {
        if (n < 3)
            return new BigInteger("3");

        ArrayList<BigInteger> arr = new ArrayList<>(); //ArrayList<Integer> used as to have a dynamic-length array.
        for (int i = 0; i <= n; i++) {
            if (i < 3) {
                arr.add(i, new BigInteger("3"));
                continue;
            } else {
                arr.add(i, new BigInteger(arr.get(i - 1).toString()).add(new BigInteger(arr.get(i - 2).toString()).multiply(new BigInteger("2")).add(new BigInteger(arr.get(i - 3).toString()).multiply(new BigInteger("3")) )));
            }
        }
        return arr.get(n);
    }

    public static void main(String[] args) {
        long t0 = System.nanoTime(); //initial time. used to compare speeds of the different methods of calculating f(n)
        //matrix (times) (ns) : 4935560, 4899118, 5056177, 4975594, 4889366
        //iterative (times) (ns): 22385641, 26406989, 23874024, 23200107, 22918325
        int n = 150;
        //BigInteger fnm = fn_matrix(n);
       BigInteger fni = fn_iterative(n);
      // System.out.println(" fm("+n+") = "+fnm);
        System.out.println("fi("+n+") = "+fni);

        long tf = System.nanoTime(); //final time. used to compare speeds of the different methods of calculating f(n)
        System.out.println("tf - t0 = "+(tf-t0));

    }
}
