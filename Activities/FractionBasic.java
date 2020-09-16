
public class FractionBasic {

    private int num;
    private int den;

    FractionBasic (int numerator, int denominator) {
        num = numerator;
        den = denominator;
        reduce();
    }
    
    // public getters for numerator and denominator
    public int getNum() {return num;}
    public int getDen() {return den;}

    // get a double approximating the value of the Fraction
    public double getDouble() { return (double) num / den;}
    
    // get a String representing the fraction
    public String getString () {return (num + " / " + den);}
    

    // make a new Fraction that is the sum of this and f, and return
    // the result
    public Fraction plus (Fraction f) {
        // sum numerator
        int sumNum = num * f.getDen() + f.getNum() * den;

        // sum denominator
        int sumDen = den * f.getDen();

        return new Fraction(sumNum, sumDen);
    }

    // make a new Fraction that is the product of this and f, and
    // return the result
    public Fraction times (Fraction f) {
        int prodNum = num * f.getNum();
        int prodDen = den * f.getDen();

        return new Fraction(prodNum, prodDen);

    }

    // compute the greatest common divisor of two ints
    // this is utter magic
    private int gcd (int n, int m) {
        if (m == 0) return n;
        return gcd(m, n % m);
    }

    // reduce Fraction to lowest terms by dividing numerator and
    // denominator by the greatest common divisor
    private void reduce () {
        
        int div = gcd(num, den);
        
        num /= div;
        den /= div;
    }
}
