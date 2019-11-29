import java.util.*;

public class DoMath {

	public static void main (String[] args) {
		System.out.println(Calculate.square(7));
		System.out.println(Calculate.cube(5));
		System.out.println(Calculate.average(5, 10));
		System.out.println(Calculate.average(3, 5, 6));
		System.out.println(Calculate.toDegrees(3));
		System.out.println(Calculate.toRadians(180));
		System.out.println(Calculate.discriminant(1, 2, 3));
		System.out.println(Calculate.toImproperFrac(9, 4, 5));
		System.out.println(Calculate.toMixedNum(49, 5));
		System.out.println(Calculate.foil(1, 2, 1, -4, "x"));
		System.out.println(Calculate.isDivisibleBy(141, 3));
		System.out.println(Calculate.absValue(-2));
		System.out.println(Calculate.max(3, 9));
		System.out.println(Calculate.max(0.1,  0.5,  0.50000001));
		System.out.println(Calculate.min(1, 3));
		System.out.println(Calculate.round2(-37.955));
		System.out.println(Calculate.exponent(3, -2));
		System.out.println(Calculate.factorial(0));
		System.out.println(Calculate.isPrime(97));
		System.out.println(Calculate.gcf(15,0));
		System.out.println(Calculate.sqrt(1000000));
		System.out.println(Calculate.quadForm(1, 2, -63));
		System.out.println(Calculate.sqrt(2));
		System.out.println(Calculate.negRoot(-1, 2));
		
	}
}