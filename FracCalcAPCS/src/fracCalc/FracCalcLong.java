package fracCalc;

//Nathan Cohn
//10/31/19
//Ms. Dreyer - APCSA
//4th Period
//
//Fractional Calculator that can solve fractions and integers
//EXTRA CREDIT:
//	Can solve multiple expressions
//	Can handle any input

import java.util.*;

public class FracCalcLong {

	// takes in expressions from the user
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean quit = false;
		while (!quit) {
			System.out.println("Enter expression below:");
			String input = scan.nextLine();
			if (input.equalsIgnoreCase("quit")) {
				quit = true;
			} else {
				System.out.println(produceAnswer(input.trim()));
			}
		}
		System.out.println("Goodbye.");
		scan.close();
	}

	// produces an answer for the given expression
	public static String produceAnswer(String input) {
		String solution = solve(input);
		if (!testString(solution) || zeroDenom(solution)) {
			return "ERROR: Input is invalid";
		} else if (isWhole(solution)) {
			return toWhole(solution) + "";
		} else if (isMixedNum(solution)) {
			return toMixedNum(solution);
		}
		return solution;
	}

	// TODO: Fill in the space below with any helper methods that you think you will

	// solves the input provided by produce answer
	public static String solve(String input) {
		while (input.contains("(") || input.contains(")")) {
			input = parenthesis(input);
		}
		String[] equation = input.split(" ");
		String solution = "";
		if (!testAll(equation)) {
			solution = "error";
		} else if (equation.length > 3) {
			solution = complexSolve(input);
		} else {
			solution = simpleSolve(equation[0], equation[1], equation[2]);
		}
		return solution;
	}

	// solves for a basic 2 operand 1 operator expression
	public static String simpleSolve(String first, String operator, String second) {
		String num1 = toImproperFrac(first);
		String num2 = toImproperFrac(second);
		if (zeroDenom(num1, num2)) {
			return "error";
		}
		if (operator.equals("+")) {
			return addFrac(num1, num2);
		} else if (operator.equals("-")) {
			return subFrac(num1, num2);
		} else if (operator.equals("/")) {
			return divideFrac(num1, num2);
		} else if (operator.equals("*")) {
			return multiplyFrac(num1, num2);
		} else {
			return "error";
		}
	}

	// EC: solves for expressions with multiple operators using order of operations
	public static String complexSolve(String input) {
		String[] equation = input.split(" ");
		for (int i = 1; i <= 2; i++) {
			String test1, test2;
			if (i == 1) {
				test1 = "*";
				test2 = "/";
			} else {
				test1 = "+";
				test2 = "-";
			}
			for (int j = 0; j < equation.length - 1; j++) {
				if (equation[j].equals(test1) || equation[j].equals(test2)) {
					String wholeEquation = equation[j - 1] + " " + equation[j] + " " + equation[j + 1];
					equation = replace(equation, j - 1, j + 1, solve(wholeEquation));
					j -= 2;
				}
			}
		}
		return equation[0];
	}

	// EC: solves for the expression in the parenthesis
	public static String parenthesis(String input) {
		int numOpenParen = 0, numCloseParen = 0;
		for (int i = 0; i < input.length(); i++) {
			char charAt = input.charAt(i);
			if (charAt == '(') {
				numOpenParen++;
			} else if (charAt == ')') {
				numCloseParen++;
			}
		}
		if (numCloseParen != numOpenParen) {
			return "error";
		}
		String equation = getPair(input);
		String output = replace(input, equation, solve(replace(replace(equation, "(", ""), ")", "")));
		return output;
	}

	// used in parenthesis to get the first expression from the first pair of
	// parenthesis
	public static String getPair(String input) {
		int beginOfPair = 0, endOfPair = 0;
		int counter = 0;
		while (endOfPair == 0) {
			char charAt = input.charAt(counter);
			if (charAt == '(') {
				beginOfPair = counter;
			} else if (charAt == ')') {
				endOfPair = counter;
			}
			counter++;
		}
		return input.substring(beginOfPair, endOfPair + 1);
	}

	// used in complex solve to replace chunks in a string array
	public static String[] replace(String[] input, int firstIndex, int lastIndex, String replaceWith) {
		String[] output = new String[input.length - (lastIndex - firstIndex)];
		int counter = 0;
		for (int i = 0; i < input.length; i++) {
			if (i == firstIndex) {
				output[counter++] = replaceWith;
			} else if (i < firstIndex || i > lastIndex) {
				output[counter++] = input[i];
			}
		}
		return output;
	}

	// the .replace method rewritten to only delete the first occurance
	public static String replace(String input, String toReplace, String replaceWith) {
		if (input.indexOf(toReplace) < 0) {
			return "error";
		}
		String firstPart = input.substring(0, input.indexOf(toReplace));
		String secondPart = input.substring(input.indexOf(toReplace) + toReplace.length());

		return firstPart + replaceWith + secondPart;
	}

	// EC: tests the array inputed to make sure it is formatted correctly
	public static boolean testAll(String[] input) {
		if (!testLength(input)) {
			return false;
		}
		for (int i = 0; i < input.length; i += 2) {
			if (!testString(input[i])) {
				return false;
			}
		}
		for (int i = 1; i < input.length; i += 2) {
			if (!testOperator(input[i])) {
				return false;
			}
		}
		return true;
	}

	// overloads the testAll method to take in a String
	public static boolean testAll(String input) {
		return testAll(input.split(" "));
	}

	// tests an operator string to make sure it is formatted correctly
	public static boolean testOperator(String operator) {
		String validOps = "+-/*";
		if (validOps.contains(operator) && operator.length() == 1) {
			return true;
		}
		return false;
	}

	// tests the length of an equation array to make sure it is the right length
	public static boolean testLength(String[] input) {
		if (input.length % 2 == 0 || input.length < 3) {
			return false;
		}
		return true;
	}

	// tests the operands of an expression to make sure they are correctly formatted
	public static boolean testString(String frac) {
		if (frac.equals("")) {
			return false;
		} else if (frac.length() == 1) {
			if (!Character.isDigit(frac.charAt(0))) {
				return false;
			}
		}
		int numSlash = 0, numUnderScore = 0, numMinus = 0;
		for (int i = 0; i < frac.length(); i++) {
			char charAt = frac.charAt(i);
			if (!Character.isDigit(charAt)) {
				if (charAt == '/') {
					numSlash++;
				} else if (charAt == '_') {
					numUnderScore++;
				} else if (charAt == '-') {
					numMinus++;
				} else {
					return false;
				}
			}
		}
		if (numUnderScore > 1 || numSlash > 1 || numMinus > 1) {
			return false;
		}
		if (numMinus != 0) {
			if ('-' != frac.charAt(0)) {
				return false;
			}
		}
		if (numUnderScore != 0) {
			if (numUnderScore != numSlash) {
				return false;
			}
			String[] splitFrac;
			for (int i = 1; i <= 2; i++) {
				String splitOn = "_";
				if (i != 1) {
					splitOn = "/";
				}
				splitFrac = frac.split(splitOn);
				if (splitFrac.length != 2) {
					return false;
				}
				frac = splitFrac[0] + " " + splitFrac[1];
			}

			splitFrac = frac.split(" ");
			for (String str : splitFrac) {
				if (!testString(str)) {
					return false;
				}
			}
		}
		return true;
	}

	// tests the frac inputed to make sure it is a whole number
	public static boolean isWhole(String frac) {
		if (!frac.contains("/")) {
			return true;
		}
		int test = getNumer(frac) / getDenom(frac);
		double tester = (getNumer(frac) + 0.0) / (getDenom(frac) + 0.0);
		if (test == tester) {
			return true;
		}
		return false;
	}

	// converts an improper fraction to a whole number
	public static int toWhole(String frac) {
		if (!frac.contains("/")) {
			return Integer.parseInt(frac);
		}
		return getNumer(frac) / getDenom(frac);
	}

	// takes three ints and converts them to an improper fraction
	public static String toImproperFrac(int whole, int numer, int denom) {
		int improp = whole * denom;
		if (whole < 0) {
			improp -= numer;
		} else {
			improp += numer;
		}
		return improp + "/" + denom;
	}

	// overloads the one above and sets the whole number to 0
	public static String toImproperFrac(int numer, int denom) {
		return toImproperFrac(0, numer, denom);
	}

	// overloads all of them to take in a String
	public static String toImproperFrac(String frac) {
		if (frac.contains("_")) {
			return toImproperFrac(getWhole(frac), getNumer(frac), getDenom(frac));
		} else if (frac.contains("/")) {
			return toImproperFrac(getNumer(frac), getDenom(frac));
		} else {
			return frac + "/1";
		}
	}

	// tests if the improper fraction is a mixed number
	public static boolean isMixedNum(String frac) {
		if (getNumer(frac) / getDenom(frac) != 0) {
			return true;
		}
		return false;
	}

	// converts 2 integers to a mixed number
	public static String toMixedNum(int numer, int denom) {
		int whole = numer / denom;
		int remain = Math.abs(numer % denom);
		return whole + "_" + remain + "/" + Math.abs(denom);
	}

	// overloads the one above to take in a String
	public static String toMixedNum(String frac) {
		return toMixedNum(getNumer(frac), getDenom(frac));
	}

	// adds 2 improper fractions
	public static String addFrac(String frac1, String frac2) {
		int numer1 = getNumer(frac1);
		int denom1 = getDenom(frac1);
		int numer2 = getNumer(frac2);
		int denom2 = getDenom(frac2);
		int numer = (numer1 * denom2) + (numer2 * denom1);
		int denom = denom1 * denom2;
		return simplify(toImproperFrac(numer, denom));
	}

	// subtracts 2 improper fractions
	public static String subFrac(String frac1, String frac2) {
		int numer = -getNumer(frac2);
		return addFrac(frac1, toImproperFrac(numer, getDenom(frac2)));
	}

	// multiplies 2 improper fractions
	public static String multiplyFrac(String frac1, String frac2) {
		int numer = getNumer(frac1) * getNumer(frac2);
		int denom = getDenom(frac1) * getDenom(frac2);
		return simplify(toImproperFrac(numer, denom));
	}

	// divides 2 improper fractions
	public static String divideFrac(String frac1, String frac2) {
		if (frac2.contains("-")) {
			frac2 = toImproperFrac(-getNumer(frac2), -getDenom(frac2));
		}
		return multiplyFrac(frac1, toImproperFrac(getDenom(frac2), getNumer(frac2)));
	}

	// checks if the denominator of an improper fraction is zero
	public static boolean zeroDenom(String frac) {
		if (getDenom(frac) == 0) {
			return true;
		}
		return false;
	}

	// over loads the one above to test 2 improper fractions
	public static boolean zeroDenom(String frac1, String frac2) {
		if (zeroDenom(frac1) || zeroDenom(frac2)) {
			return true;
		}
		return false;
	}

	// simplifies an improper fraction
	public static String simplify(String frac) {
		int numer = getNumer(frac);
		int denom = getDenom(frac);
		int gcf = gcf(numer, denom);
		return (numer / gcf) + "/" + (denom / gcf);
	}

	// gets the whole number from a mixed number
	public static int getWhole(String frac) {
		return Integer.parseInt(frac.substring(0, frac.indexOf('_')));
	}

	// gets the numerator from any fraction
	public static int getNumer(String frac) {
		if (frac.contains("_")) {
			return Integer.parseInt(frac.substring(frac.indexOf("_") + 1, frac.indexOf('/')));
		}
		return Integer.parseInt(frac.substring(0, frac.indexOf('/')));
	}

	// gets the denominator from any fraction
	public static int getDenom(String frac) {
		return Integer.parseInt(frac.substring(frac.indexOf('/') + 1));
	}

	// finds the greatest common factor of 2 numbers
	public static int gcf(int a, int b) {
		a = (int) Math.abs(a);
		b = (int) Math.abs(b);
		int gcf = Math.min(a, b);

		while (gcf > 1) {
			if (a % gcf == 0 && b % gcf == 0) {
				return gcf;
			}
			gcf--;
		}
		return 1;
	}
}