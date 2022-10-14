public class Main {
    public static void main(String[] args) {
    }

    public static double getDiscriminant(double a, double b, double c) {
        return b * b - 4.0 * a * c;
    }


    public static String getSmallestWord(String[] words) {
        if (words.length == 1) {
            return words[0];
        }
        String shortest = words[0];
        for (int i = 1; i < words.length; i++) {
            if (words[i].length() < shortest.length()) {
                shortest = words[i];
            }
        }
        return shortest;
    }

}

class Fraction {

    private int numerator;

    private int denominator;


    public int getNumerator() {
        return this.numerator;
    }

    public int getDenominator() {
        return this.denominator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Fraction) {
            return (((Fraction) obj).numerator * this.denominator == ((Fraction) obj).denominator * this.numerator);
        }
        return false;
    }

    @Override
    public String toString() {
        return this.numerator + "/" + this.denominator;
    }


    public Fraction truncated() {
        int greatestCommonDivisor = 1;
        for(int i = 1; i <= this.numerator && i <= this.denominator; i++)
        {
            if(this.numerator % i == 0 && this.denominator % i == 0) greatestCommonDivisor = i;
        }
        this.numerator /= greatestCommonDivisor;
        this.denominator /= greatestCommonDivisor;
        return this;
    }

    public Fraction add(Fraction fraction) {
        int resultNumerator = this.numerator * fraction.denominator + fraction.numerator * this.denominator;
        int resultDenominator = this.denominator * fraction.denominator;
        Fraction resultFraction = new Fraction(resultNumerator, resultDenominator);
        return resultFraction.truncated();
    }


    public  Fraction multiply(Fraction fraction) {
        int resultNumerator = this.numerator * fraction.numerator;
        int resultDenominator = this.denominator * fraction.denominator;
        Fraction resultFraction = new Fraction(resultNumerator, resultDenominator);
        return resultFraction.truncated();
    }

}