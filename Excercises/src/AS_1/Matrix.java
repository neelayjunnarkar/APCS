package AS_1;

import java.math.BigInteger;
import java.util.Arrays;

public class Matrix {

    final int M; //columns
    final int N; //rows
    final BigInteger[][] matrix; // 2d array of elements


    /**
     *defualts elements of matrix to 0
     * @param M columns
     * @param N rows
     */
    public Matrix(int M, int N) {
        this.M = M;
        this.N = N;
        matrix = new BigInteger[M][N];

        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                matrix[i][j] = new BigInteger("0");
    }

    /**
     *
     * @param M columns
     * @param N rows
     * @param init default value of matrix elements
     */
    public Matrix(int M, int N, BigInteger init) {
        this.M = M;
        this.N = N;
        matrix = new BigInteger[M][N];
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                matrix[i][j] = init;
    }

    /**
     *
     * @param matrix the 2d array from which a matrix is created
     */
    public Matrix(BigInteger[][] matrix) {
        M = matrix.length;
        N = matrix[0].length;
        this.matrix = new BigInteger[M][N];
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                this.matrix[i][j] = matrix[i][j];
    }

    /**
     * Copy constructor
     * @param A matrix which is copied
     */
    private Matrix(Matrix A) {
        this(A.matrix);
    }

    /**
     *
     * @param Ao the first matrix
     * @param Bo the second matrix
     * @return returns Ao * Bo
     */
    public static Matrix multiply(Matrix Ao, Matrix Bo) {
        Matrix A = new Matrix(Ao);
        Matrix B = new Matrix(Bo);

        if (A.N != B.M) throw new RuntimeException("Illegal matrix dimensions.");
        Matrix C = new Matrix(A.M, B.N, new BigInteger("0"));
        for (int i = 0; i < C.M; i++)
            for (int j = 0; j < C.N; j++)
                for (int k = 0; k < A.N; k++)
                    C.matrix[i][j] = C.matrix[i][j].add( A.matrix[i][k].multiply(B.matrix[k][j]) );
        return C;
    }

    /**
     *
     * @param Bo the other matrix by which the matrix will be multiplied
     * @return
     */
    public Matrix multiply(Matrix Bo) {
        Matrix A = this;
        Matrix B = new Matrix(Bo);

        if (A.N != B.M) throw new RuntimeException("Illegal matrix dimensions.");
        Matrix C = new Matrix(A.M, B.N);
        for (int i = 0; i < C.M; i++)
            for (int j = 0; j < C.N; j++)
                for (int k = 0; k < A.N; k++)
                    C.matrix[i][j] = C.matrix[i][j].add(A.matrix[i][k].multiply(B.matrix[k][j]));
        return C;
    }

    /**
     * prints the matrix
     */
    public void print() {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(((matrix[i][j].compareTo(new BigInteger("0")) < 0) ? "":" ")+matrix[i][j]+" ");
            System.out.println();
        }
    }


    /**
     * Uses exponentiation by squaring to efficiently calculate m^n where m is a matrix and n is the exponent
     * @param m the Matrix to be raised to nth power
     * @param n the power to which the matrix will be raised
     * @return returns the resulting Matrix of m^n
     */
    public static Matrix pwr(Matrix m, int n) {
        Matrix result = new Matrix(m.M, m.N);
        result.matrix[0][0] = new BigInteger("1");
        result.matrix[1][1] = new BigInteger("1");
        result.matrix[2][2] = new BigInteger("1");
        while (n != 0){
            if (n%2==1){
                result = Matrix.multiply(result, m);
            }
            n /= 2;
            m = Matrix.multiply(m, m);
        }

        return result;
    }



}
