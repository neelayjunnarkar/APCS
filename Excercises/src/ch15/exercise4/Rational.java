package ch15.exercise4;

/*
 * Whether I prefer class or object methods for these methods depends on the usage of the method. In most cases, for these methods, I prefer useing the class methods.
 * 
 */
class Rational {

    int numerator, denominator;

    //default constructor sets rational to 0
    public Rational() {
    	numerator = 0;
    	denominator = 1;
    }
    
    public Rational(int num, int den) {
        numerator = num;
        denominator = den;
        reduce();
    }
    
    //object method negate
    public void negate() {
        numerator = -(numerator);
    }
    
    //class method negate
    public static void negate(Rational r) {
    	r.numerator = -(r.numerator);
    }

    //object method invert
    public void invert() {
        numerator += denominator;
        denominator = numerator - denominator;
        numerator = numerator - denominator;
    }
    
    //class method invert
    public static void invert(Rational r) {
    	r.numerator += r.denominator;
        r.denominator = r.numerator - r.denominator;
        r.numerator = r.numerator - r.denominator;
    }

    //object method toDouble
    public double toDouble() {
        return (double)numerator/(double)denominator;
    }
    
    //class method toDouble
    public static double toDouble(Rational r) {
    	return (double)r.numerator/(double)r.denominator;
    }

    //object method greatest common factor
    public int  gcd() {
        int gcd = 1;
        int temp = 0;
        int num = numerator, denom = denominator;
        while (denom != 0) {
            temp = num % denom;
            num= denom;
            denom = temp;
        }
        gcd = num;
        return gcd;
    }

    //class method gcf
    public static int  gcd(int a, int b) {
        int gcd = 1;
        int temp = 0;
        while (b != 0) {
            temp = a % b;
            a = b;
            b = temp;
        }
        gcd = a;
        return gcd;
    }
    
    //object method reduce()
    public void reduce() {
        int gcd = gcd();
        numerator /= gcd;
        denominator /= gcd;
    }
    
    //class method reduce
    public static void reduce(Rational r) {
        int gcd = gcd(r.numerator, r.denominator);
        r.numerator /= gcd;
        r.denominator /= gcd;
    }

    //object method add
    public Rational add(Rational r) {
    	if (denominator == r.denominator) 
    		return new Rational(numerator+r.numerator, denominator);
    	
    	return new Rational(numerator*r.denominator+r.numerator*denominator, denominator*r.denominator);
    }
    
    //class method add
    public static Rational add(Rational r1, Rational r2) {
    	if (r1.denominator == r2.denominator) 
    		return new Rational(r1.numerator+r2.numerator, r1.denominator);
    	
    	return new Rational(r1.numerator*r2.denominator+r2.numerator*r1.denominator, r2.denominator*r1.denominator);
    }
    
    //object method print
    public void printRational() {
    	if (denominator == 1) {
    		System.out.println(numerator);
    		return;
    	}
        System.out.println(numerator+"/"+denominator);
    }

    public static void main(String[] args) {
        Rational r = new Rational(4,6); //fraction automatically reduced in constructor
        r.printRational();
        
        r.invert();
        System.out.println("invert: ");
        r.printRational();
        
        r.negate();
        System.out.println("negate: ");
        r.printRational();
        
        System.out.println("gcf of 12, 354: "+Rational.gcd(12, 354));
        
        Rational r2 = new Rational(12,42);
        System.out.println("4/6 + 12/42 = ");
        Rational added = Rational.add(new Rational(4, 6), r2);
        added.printRational();	
        
        
    }
}