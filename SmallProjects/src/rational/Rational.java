package rational;

class Rational {

    int numerator, denominator;

    public Rational(int num, int den) {
        numerator = num;
        denominator = den;
        reduce();
    }

    public void negate() {
        numerator = -(numerator);
    }

    public void invert() {
        numerator += denominator;
        denominator = numerator - denominator;
        numerator = numerator - denominator;
    }

    public double toDouble() {
        return (double)numerator/(double)denominator;
    }

    public int  gcd(int a, int b) {
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

    public void reduce() {
        int gcd = gcd(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;

    }

    public void print() {
        System.out.println(numerator+"/"+denominator);
    }

    public static void main(String[] args) {
        Rational r = new Rational(-4, 6);
        r.print();
    }
}