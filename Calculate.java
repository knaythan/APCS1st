/*
 Nathan Cohn
 8/29/19
 Period 4
 
 Group of methods that perform math calculations
 */
import java.text.DecimalFormat;
import java.util.*;

public class Calculate {

	public static double square(double squared) {
		return exponent(squared, 2);
	} 
	
	public static double cube(double cubed) {
		return exponent(cubed, 3);
	}

	public static double exponent(double num, double power) {
		double numToPower = num;
		for (int i = 1; i <= power - 1; i++) {
			numToPower *= num;
		}
		return numToPower;
	}
	
	public static double sqrt(double numToRoot) {
		return findRoot(numToRoot, 2);
	}
	
	public static double findRoot(double numToRoot, double rootBy) {
		DecimalFormat df = new DecimalFormat("0.0000000");
		ArrayList<Double> temp = new ArrayList<>();

		boolean foundRoot = false;
		double squareRoot = 0.0001;
		double square = 0;

		if (numToRoot == 0) {
			return numToRoot;
		} else if (rootBy == 0) {
			return numToRoot;
		} else {
			while (!foundRoot) {
				squareRoot = Double.parseDouble(df.format(squareRoot));
				square = squareRoot;
				for (int i = 1; i <= (rootBy - 1); i++) {
					square *= squareRoot;
				}

				if (square > numToRoot) {
					foundRoot = true;
					squareRoot = temp.get(0);
					square = temp.get(1);
					break;
				} else {
					temp.clear();
				}

				temp.add(squareRoot);
				temp.add(square);
				squareRoot += 0.0001;
			}
		}
		return squareRoot;
	}
	
	public static double average(ArrayList<Double> listToAvg) {
		double total = 0;
		for (Double num : listToAvg) {
			total += num;
		}
		return (total / listToAvg.size());
	}
	
	/*public static double average(double a, double b) {
		ArrayList<Double> avgList = new ArrayList<>();
	}
	
	public static double average(double a, double, b, double c) {
		
	}*/

	public static double absValue(double num) {
		if (num < 0) {
			num *= -1;
		}
		return num;
	}

	public static double gcf(double a, double b) {
		a = absValue(a);
		b = absValue(b);

		if (a == 0 || a == 1) {
			return (a == 0) ? b : a;
		} else if (b == 0 || b == 1) {
			return (b == 0) ? a : b;
		} else {
			if (b > a) {
				while (b % a != 0) {
					b %= a;
					a %= b;
				}
				return a;
			} else {
				while (a % b != 0) {
					a %= b;
					b %= a;
				}
				return b;
			}
		}
	}
}
