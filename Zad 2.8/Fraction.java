
class Fraction {

    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            this.denominator = 1;
        } else {
            this.denominator = denominator;
        }
        this.numerator = numerator;
    }

    public Fraction add(Fraction other) {
        int newNumerator = this.numerator * other.denominator + other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;

        Fraction result = new Fraction(newNumerator, newDenominator);
        result = result.simplify();

        return result;
    }

    public Fraction subtract(Fraction other) {
        int newNumerator = this.numerator * other.denominator - other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;

        Fraction result = new Fraction(newNumerator, newDenominator);
        result = result.simplify();

        return result;
    }

    public Fraction multiply(Fraction other) {
        int newNumerator = this.numerator * other.numerator;
        int newDenominator = this.denominator * other.denominator;

        Fraction result = new Fraction(newNumerator, newDenominator);
        result = result.simplify();

        return result;
    }

    public Fraction divide(Fraction other) {
        if (other.numerator == 0) {
            return new Fraction(this.numerator, this.denominator);
        }

        Fraction otherInverse = other.inverse();
        Fraction result = this.multiply(otherInverse);

        result = result.simplify();
        return result;
    }

    public Fraction simplify() {
        int a = Math.abs(this.numerator);
        int b = Math.abs(this.denominator);

        //algorytm euklidesa
        // https://eduinf.waw.pl/inf/utils/010_2010/0208.php
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return new Fraction(this.numerator /= a, this.denominator /= a);
    }

    private Fraction inverse() {
        int newNumerator = this.denominator;
        int newDenominator = this.numerator;

        Fraction result = new Fraction(newNumerator, newDenominator);
        return result;
    }

    @Override
    public String toString() {
        return this.numerator + "/" + this.denominator;
    }

}
