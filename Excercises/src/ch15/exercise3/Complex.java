package ch15.exercise3;

public class Complex {

	int real, imag;
	
	//object method
	public boolean equals(Complex b) {
	    return(real == b.real && imag == b.imag);
	}
	
	//my class method
	public static boolean equals(Complex a, Complex b) {
	    return(a.real == b.real && a.imag == b.imag);
	}
}
