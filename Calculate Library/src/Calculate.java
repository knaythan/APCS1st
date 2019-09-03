
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
		try {
		double numToPower = num;
		for (int i = 1; i <= power - 1; i++) {
			numToPower *= num;
		}
		return numToPower;
		} catch(NumberFormatException ex) {
			System.out.println("Enter a valid number.");
			return 0;
		}
	}

	public static double sqrt(double numToRoot) {
		try {
			return round2(findRoot(numToRoot, 2));
		} catch (NumberFormatException ex) {
			System.out.println("Enter a valid number.");
			return 0;
		}
	}

	public static String negRoot(double numToRoot, double rootBy) {
		String negRoot = "" + findRoot(absValue(numToRoot), rootBy);
		negRoot += " i";
		return negRoot;
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
				square = exponent(squareRoot, rootBy);

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

	public static double average(double[] listToAvg) {
		double total = 0;
		for (double num : listToAvg) {
			total += num;
		}
		return (total / listToAvg.length);
	}

	public static double average(double a, double b) {
		double[] listToAvg = { a, b };
		return average(listToAvg);
	}

	public double average(double a, double b, double c) {
		double[] listToAvg = { a, b, c };
		return average(listToAvg);
	}

	public static double absValue(double num) {
		return (num < 0) ? -num : num;
	}

	public static int gcf(int a, int b) {
		a = (int) absValue(a);
		b = (int) absValue(b);
		int gcd = 1;

		for (int i = 1; i <= a && i <= b; i++) {
			if (a % i == 0 && b % i == 0) {
				gcd = i;
			}
		}
		return gcd;
	}

	public static double toDegrees(double radians) {
		return radians * (180 / 3.14159);
	}

	public static double toRadians(double degrees) {
		return degrees / (180 / 3.14159);
	}

	public static double discriminant(double a, double b, double c) {
		return square(b) - (4 * a * c);
	}

	public static String toImproperFrac(int whole, int num, int den) {
		Integer improp = (whole * den) + num;
		return improp.toString() + "/" + den;
	}

	public static String toMixedNum(int num, int den) {
		int whole = num;
		while (whole % den != 0) {
			whole--;
		}
		num -= whole;
		whole /= den;
		String mixed = whole + ((num == 0) ? "" : " " + num + "/" + den);
		return mixed;
	}

	public static String foil(int a, int b, int c, int d, String var) {
		String part1 = (a * c) + var + "^2";
		String part2 = " + " + ((a * d) + (b * c)) + var;
		String part3 = " + " + (b * d);
		return part1 + part2 + part3;
	}

	public static boolean isDivisibleBy(int a, int b) {
		try {
			return (a % b == 0) ? true : false;
		} catch (NumberFormatException ex) {
			System.out.println("Enter a vlid number.");
			return false;
		}
	}

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

	public static double max(double[] inputList) {
		return trueForMax(inputList, true);
	}

	public static double max(double a, double b) {
		return max(new double[] { a, b });
	}

	public static double max(double a, double b, double c) {
		return max(new double[] { a, b, c });
	}

	public static double min(double[] inputList) {
		return trueForMax(inputList, false);
	}

	public static int min(int a, int b) {
		return (int) min(new double[] { a, b });
	}

	public static double round(double a, int decimalPlace) {
		a *= exponent(10, decimalPlace);
		String round = "" + a;
		int roundIf = Integer.parseInt("" + round.charAt(round.indexOf('.') + 1));
		round = round.substring(0, round.indexOf('.'));
		a = Double.parseDouble(round);
		if (roundIf >= 5) {
			a += (a > 0) ? 1 : -1;
		}
		return a / exponent(10, decimalPlace);
	}

	public static double round2(double a) {
		return round(a, 2);
	}

	public static int factorial(int a) {
		try {
			int factorial = 1;
			for (int i = 1; i <= a; i++) {
				factorial *= i;
			}
			return factorial;
		} catch (NumberFormatException ex) {
			System.out.println("Enter a valid number.");
			return 0;
		}
	}

	public static boolean isPrime(int num) {
		if (num % 2 == 0) {
			return (num == 2) ? true : false;
		}
		for (int i = 1; i < num; i += 2) {
			if (isDivisibleBy(num, i) && i != 1) {
				return false;
			}
		}
		return true;
	}

	public static String quadForm(String stanForm) {
		int a = Integer.parseInt((stanForm.substring(0, stanForm.indexOf('^') - 1)));
		int b = Integer.parseInt(stanForm.substring(stanForm.indexOf('+') + 2, stanForm.lastIndexOf('+') - 2));
		int c = Integer.parseInt(stanForm.substring(stanForm.lastIndexOf(' ') + 1));
		double dis = discriminant(a, b, c);
		double minus = ((-b) - sqrt(dis)) / 2 * a;
		double plus = ((-b) + sqrt(dis)) / 2 * a;
		if (dis < 0) {
			return "no real roots";
		} else {
			return minus + ((dis == 0) ? "" : " and " + plus);
		}
	}

}