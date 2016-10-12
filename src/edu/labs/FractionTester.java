package edu.labs;

public class FractionTester {

	public static void main(String[] args) {
		System.out.println("in this program you will add 2 fractions");
		Fraction f1 = new Fraction();
		Fraction f2 = new Fraction();
		Fraction f3 = new Fraction();
		f1.inputFraction();
		f2.inputFraction();
		f3 = f1.add(f2);
		System.out.println(f1+" + "+f2+" = "+f3);
		f3 = f1.sub(f2);
		System.out.println(f1+" - "+f2+ " = "+f3);
		f3 = f1.mul(f2);
		System.out.println(f1+" * "+f2+" = "+f3);
		f1.div(f2);
		System.out.println(f1+" / "+f2+" = "+Fraction.divFraction(f1, f2));
		f1.setNumerator(2);
		f2.setDenominator(5);
		System.out.println("Print f1 :"+f1.toString());
		System.out.println("Print f2 :"+f2.toString());
	}
}
