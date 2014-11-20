Mapcar
======
	by Neelay Junnarkar
	
Neelay Junnarkar APCS 2nd Period Mr. Kuszmaul

This program implements a mapcar function in java for HashSet, Stack, and LinkedList.
It does so by using a Function Interface, from which all "functions" that are passed 
into the mapcar must implement

Function Interface:
	A generic interface that declares an "operate" method
	Classes that implement this interface (the "functions") may or may not specialize to certain types for parameters
	T operate(T t):
		the method which "functions" must call upon to use as the actual function which does operations on the input
		
Example Functions provided:
	square:
		squares the input integer to the operate method
	add_one:
		adds_one to the input integer to the operate method
	double_elem:
		doubles the input double to the operate method
		
mapcar (method):
	Several variants, each of which specializes to a specific container
	The mapcar takes parameters of a collection and a function, and operates the function on every element of the collection
	
Variants of mapcar provided operate on...:
	HashSet
	ArrayList
	Stack
	LinkedLists