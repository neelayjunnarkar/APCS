Recursion, Iteration, and Matrices
==================================
	by Neelay Junnarkar
	
f(n) = f(n-1) + 2(f(n-2)) + 3(f(n-3))
=======
	Times are average of 5 measurements(where applicable) of f(150) and are measured using System.nanoTime() and converting ns to ms
	Matrices:
		f(n) implemented using matrices to efficiently find f(n)
		Uses the equation (solved for by Neelay):
			     _      _     _     _      _   _
				| f(n+1) |   | 1 2 3 |^n  |  1  |
				| f(n)   | = | 1 0 0 |    |  0  |
				| f(n-1) |   | 0 1 0 |    | 1/3 |
				|_      _|   |_     _|    |_   _|
				
		Average Time for f(150): 4.951163 milliseconds
		Individual Times for f(150)(ms): 4.935560, 4.899118, 5.056177, 4.975594, 4.889366
	Recursion:
		f(n) implemented using recursion
		Average Time for f(150): N/A did not complete (left running for >40 minutes, did not complete)
		Individual Times for f(150): N/A did not complete (left running for >40 minutes, did not complete)
	Iteration:
		f(n) implemented using iteration
	    Average Time for f(150): 23.7570172 ms
		Individual Times for f(150) (ms): 22385641, 26406989, 23874024, 23200107, 22918325
		
Pascal's Triangle
======
	int pascalElem(int x, int y):
		Returns the y-th element at the x-th row of Pascal's triangle (with 0-indexing)
		eg. pascalElem(2, 1) returns 2
	int[][] pascal(int n):
		Returns a 2-dimensional array of Pascal's Triangle up to the n-th row, inclusive
	void printPascalTriang(int[][] tri):
		Prints out Pascal's Triangle for an input of a 2-dimensional array
		Omits 0's so the format looks more like Pascal's triangle
	void printPascalTriang(int n):
		Prints out Pascal's Triangle up to the n-th row, inclusive
		Omits 0's so the format looks more like Pascal's triangle
		
Matrix Class
======
	An implementation of a Matrix in java
	Note that this implementation only implements the functions required for these Exercises.
		As such, many operations are not implemented
	Matrix multiply:
		implements both class (Matrix Ao, Matrix Bo) and object versions (Matrix Bo)
		returns the product of 2 Matrices
	void print():
		Matrix implements a print method to allow for easy formatted printing of the matrix
		uses System.out
	Matrix pwr(Matrix m, int n):
		Returns m^n
		Matrix implements a method to allow for easy exponentiation of the matrix
		Uses exponentiation by squaring to efficiently exponentiate the matrix
		
		