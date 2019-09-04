import java.text.DecimalFormat;
import java.util.ArrayList;

public class Quadratic {
	/*
	 Must return the direction it opens, the vertex, and the intercepts
	 */
	public static String quadDescriber(double a, double b, double c) {
		String xIntercepts = quadForm(a + "x^2 + " +  b + "x + " + c);
		int x1 = 
	}
	
	public static String foil(double a, double b, int c, double d, String var) {
		String part1 = (a * c) + var + "^2";
		String part2 = " + " + ((a * d) + (b * c)) + var;
		String part3 = " + " + (b * d);
		return part1 + part2 + part3;
	}
	
	public static String quadForm(String stanForm) {
		int a = Integer.parseInt((stanForm.substring(0, stanForm.indexOf('^') - 1)));
		int b = Integer.parseInt(stanForm.substring(stanForm.indexOf('+') + 2, stanForm.lastIndexOf('+') - 2));
		int c = Integer.parseInt(stanForm.substring(stanForm.lastIndexOf(' ') + 1));
		
		double dis = discriminant(a, b, c);
		double root1 = ((-b) - sqrt(dis)) / 2 * a;
		double root2 = ((-b) + sqrt(dis)) / 2 * a;
		
		if (dis < 0) {
			return "no real roots";
		} else {
			return root1 + ((dis == 0) ? "" : " and " + root2);
		}
	}
	
	public static double discriminant(double a, double b, double c) {
		return square(b) - (4 * a * c);
	}
	
	public static double square(double squared) {
		return exponent(squared, 2);
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
	
	public static double findRoot(double numToRoot, double rootBy) {
		DecimalFormat df = new DecimalFormat("0.0000000");
		ArrayList<Double> temp = new ArrayList<>();

		boolean foundRoot = false;
		double root = 0.0001;
		double pow = 0;

		if (numToRoot == 0) {
			return numToRoot;
		} else if (rootBy == 0) {
			return numToRoot;
		} else {
			while (!foundRoot) {
				root = Double.parseDouble(df.format(root));
				pow = root;
				pow = exponent(root, rootBy);

				if (pow > numToRoot) {
					foundRoot = true;
					root = temp.get(0);
					pow = temp.get(1);
					break;
				} else {
					temp.clear();
				}

				temp.add(root);
				temp.add(pow);
				root += 0.0001;
			}
		}
		return root;
	}
	
	public static double sqrt(double numToRoot) {
		try {
			return round2(findRoot(numToRoot, 2));
		} catch (NumberFormatException ex) {
			System.out.println("Enter a valid number.");
			return 0;
		}
	}
	
	public static double round2(double a) {
		return round(a, 2);
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
}
