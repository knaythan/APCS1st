
/*
 Nathan Cohn
 8/29/19
 Period 4
 
 Group of methods that perform math calculations
 */

import java.util.*;

public class Calculate {

	// Squares any number
	public static double square(int numToSquare) {
		return exponent(numToSquare, 2);
	}

	// Cubes any number
	public static double cube(int numToCube) {
		return exponent(numToCube, 3);
	}

	// Finds the result of any number to any power
	public static double exponent(double num, int power) {
		if (power < 0) {
			return exponent(1 / num, (int) absValue(power));
		}
		double numToPower = num;
		for (int i = 1; i < power; i++) {
			numToPower *= num;
		}
		return numToPower;
	}

	// Finds the closest square root of any number
	public static double sqrt(double numToRoot) {
		if (numToRoot < 0) {
			throw new IllegalArgumentException("Input must be positive");
		}
		return findRoot(numToRoot, 2);
	}

	// Finds the any root of a negative number
	public static String negRoot(double numToRoot, int rootBy) {
		if (numToRoot >= 0) {
			throw new IllegalArgumentException("Input must be negative");
		}
		String negRoot = "" + findRoot(absValue(numToRoot), rootBy);
		negRoot += " i";
		return negRoot;
	}

	// Finds any root of any number
	public static double findRoot(double numToRoot, int rootBy) {
		if(numToRoot < 0) {
			throw new IllegalArgumentException("Input must be positive");
		} else {
		double root = 0;
		while(exponent(root, rootBy) <= numToRoot) {
			root += 0.001;
		}
		return round2(root);
		}
	}

	// Finds the average of a list of numbers
	public static double average(double[] listToAvg) {
		double total = 0;
		for (double num : listToAvg) {
			total += num;
		}
		return (total / listToAvg.length);
	}

	// Finds the average of 2 numbers
	public static double average(double a, double b) {
		double[] listToAvg = { a, b };
		return average(listToAvg);
	}

	// Finds the average of 3 numbers
	public static double average(double a, double b, double c) {
		double[] listToAvg = { a, b, c };
		return average(listToAvg);
	}

	// Finds the absolute value of a number
	public static double absValue(double num) {
		if (num < 0) {
			return -num;
		} else {
			return num;
		}
	}

	// Finds the gcf of 2 numbers
	public static int gcf(int a, int b) {
		a = (int) absValue(a);
		b = (int) absValue(b);
		int gcf = min(a, b);
		
		while(gcf > 1) {
			if (isDivisibleBy(a, gcf) && isDivisibleBy(b, gcf)) {
				return gcf;
			}
			gcf--;
		}
		return 1;
	}

	// Converts from radians to degrees
	public static double toDegrees(double radians) {
		return radians * (180 / 3.14159);
	}

	// Converts from degrees to radians
	public static double toRadians(double degrees) {
		return degrees / (180 / 3.14159);
	}

	// Finds the discriminant of a, b, and c
	public static double discriminant(double a, double b, double c) {
		return square(b) - (4 * a * c);
	}

	// Converts a mixed number to an improper fraction
	public static String toImproperFrac(int whole, int numer, int denom) {
		int improp = (whole * denom) + numer;
		return improp + "/" + denom;
	}

	// Converts an improper fraction to a mixed number
	public static String toMixedNum(int numer, int denom) {
		int whole = numer / denom;
		int remain = numer % denom;
		return whole + "_" + remain + "/" + denom;
	}

	// Converts from (a, b)(c, d) to standard form
	public static String foil(int a, int b, int c, int d, String var) {
		String part1 = (a * c) + var + "^2";
		String part2 = " + " + ((a * d) + (b * c)) + var;
		String part3 = " + " + (b * d);
		return part1 + part2 + part3;
	}

	// Returns true if a divides by b evenly and false if they don't
	public static boolean isDivisibleBy(int a, int b) {
		if (a < b) {
			throw new IllegalArgumentException("First input must be greater than or equal to second input");
		}
		return a % b == 0;
	}

	//Finds max or min depending on a boolean
	public static double trueForMax(double[] inputList, boolean max) {
		ArrayList<Double> list = new ArrayList<>();
		for (int i = 0; i < inputList.length; i++) {
			list.add(inputList[i]);
		}

		int a = 0;
		int b = 1;
		while (list.size() != 1) {
			if (list.get(a) > list.get(b)) {
				list.remove((max) ? b : a);
			} else {
				list.remove((max) ? a : b);
			}
		}
		return list.get(0);
	}

	// Finds the maximum of a list
	public static double max(double[] inputList) {
		return trueForMax(inputList, true);
	}

	// Finds the maximum of 2 numbers
	public static double max(double a, double b) {
		return max(new double[] { a, b });
	}

	// Finds the maximum of three numbers
	public static double max(double a, double b, double c) {
		return max(new double[] { a, b, c });
	}

	// Finds the minimum of a list of numbers
	public static double min(double[] inputList) {
		return trueForMax(inputList, false);
	}

	// Finds the minimum of two numbers
	public static int min(int a, int b) {
		return (int) min(new double[] { a, b });
	}

	// Rounds a number depending on which decimal place is chosen
	public static double round(double a, int decimalPlace) {
		a *= exponent(10, decimalPlace);
		if (a < 0) {
			a -= 0.5;
		} else {
			a += 0.5;
		}
		a = (int) a;
		a /= exponent(10, decimalPlace);
		return a;

	}

	// Round a number to the 2nd decimal place
	public static double round2(double a) {
		return round(a, 2);
	}

	// Finds the factorial of the number provided
	public static int factorial(int a) {
		if (a < 0) {
			throw new IllegalArgumentException("Input must be positive");
		}
		int factorial = 1;
		for (int i = 1; i <= a; i++) {
			factorial *= i;
		}
		return factorial;
	}

	// Determines whether a number is prime or not
	public static boolean isPrime(int num) {
		if (num <= 2 || isDivisibleBy(num, 2)) {
			return num == 2;
		}
		int i = 3;
		while (!isDivisibleBy(num, i)) {
			i += 2;
		}
		return num == i;
	}

	// Finds the root(s) of a, b, and c if there are any
	public static String quadForm(int a, int b, int c) {
		double dis = discriminant(a, b, c);
		if (dis < 0) {
			return "no real roots";
		}

		double root1 = round2(((-b) - sqrt(dis)) / (2 * a));
		if (dis == 0) {
			return root1 + "";
		}

		double root2 = round2(((-b) + sqrt(dis)) / (2 * a));
		return root1 + " and " + root2;
	}

}