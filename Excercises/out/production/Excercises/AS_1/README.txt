Recursion, Iteration, and Matrices
==================================
	by Neelay Junnarkar
	
f(n) = f(n-1) + 2(f(n-2)) + 3(f(n-3))
=======
	Times are average of 6 measurements(where applicable) of f(150) and are measured using System.toMillis()
	Matrices:
		f(n) implemented using matrices to efficiently find f(n)
		Uses the equation (solved for by Neelay):
			     _      _     _     _      _   _
				| f(n+1) |   | 1 2 3 |^n  |  3  |
				| f(n)   | = | 1 0 0 |    |  3  |
				| f(n-1) |   | 0 1 0 |    | -2  |
				|_      _|   |_     _|    |_   _|
				
		Average Time for f(150): 4951163 nanoseconds
		Individual Times for f(150)(ns): 4935560, 4899118, 5056177, 4975594, 4889366
	Recursion:
		f(n) implemented using tail-recursion
		Average Time for f(150): N/A did not complete
		Individual Times for f(150): N/A did not complete
	Iteration:
		f(n) implemented using iteration
	    Average Time for f(150): 22.7 ms
		Individual Times for f(150) (ms): 24, 22, 22, 25, 21, 22
		
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
	multiply:
		implements both class (Matrix Ao, Matrix Bo) and object versions (Matrix Bo)
		returns the product of 2 Matrices
	print():
		Matrix implements a print method to allow for easy formatted printing of the matrix
		uses System.out
	pwr(Matrix m, int n):
		Matrix implements a method to allow for easy exponentiation of the matrix
		Uses exponentiation by squaring to efficiently exponentiate the matrix
		
		