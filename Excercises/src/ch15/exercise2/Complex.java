package ch15.exercise2;

public class Complex {
	int real, imag;
	
	//class method
	public static double abs(Complex c) {
	    return Math.sqrt(c.real * c.real + c.imag * c.imag);
	}
	
	//my object method
	public double abs() {
	    return Math.sqrt(real * real + imag * imag);
	}
}
