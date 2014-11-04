package AS_1;

import java.util.Stack;

/**
 * @author Neelay Junnarkar
 */
public class Pascal {

    /**
     * Uses recursion
     * @param x x-th row
     * @param y y-th element
     * @return returns y-th element at x-th row
     */
    public static int pascalElem(int x, int y) {
        if (y == 0)
            return 1;
        if (x == y)
            return 1;
        else
            return pascalElem(x - 1, y - 1) + pascalElem(x - 1, y);
    }

    /**
     * Uses a stack to capitalize on the symmetry of Pascal's triangle to calculate the elements in a row more efficiently
     * @param n n-th row
     * @return returns a 2-dimensional array of the rows of the pascals triangle up to the n-th row, inclusive
     */
    public static int[][] pascal(int n) {
        int[][] tri = new int[n][n];

        for ( int y = 0; y < n; y++) {
            Stack<Integer> stack = new Stack<Integer>();
            for (int x = 0; x <=(y/2); x++) {
                tri[y][x] = pascalElem(y, x);
                stack.push(tri[y][x]);
            }
            for (int x = (y % 2 == 0) ? y/2: y/2+1; !stack.empty(); x++) {
                tri[y][x] = stack.pop();
            }

        }

        return tri;
    }

    /**
     * Prints out the array, ommitting all 0's as to better format the array as pascal's triangle
     * @param tri 2-dimensional array of pascal's triangle
     */
    public static void printPascalTriang(int[][] tri) {
        for (int x = 0; x < tri[1].length; x++) {
            for (int y = 0; y < tri.length; y++)
                System.out.print((tri[x][y] == 0) ? "" : tri[x][y] + " ");
            System.out.println();
        }
    }

    /**
     * Prints out pascal's triangle up to the n-th row, inclusive, omitting all 0's as to better format the array as pascal's triangle
     * @param n the n-th row of pascals triangle, inclusive
     */
    public static void printPascalTriang(int n) {
        printPascalTriang(pascal(n));
    }


    public static void main(String[] args) {
        System.out.println(pascalElem(2, 1));
    }
}
