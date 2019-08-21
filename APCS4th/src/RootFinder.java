import java.text.*;
import java.util.*;

public class RootFinder {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("0.0000000");

		for (int i = 1; i > 0; i++) {

			boolean foundRoot = false;
			double squareRoot = 0;
			double square = 0;
			ArrayList<Double> temp = new ArrayList<>();

			System.out.println("What number would you like to root:");
			double numToRoot = Double.parseDouble(scan.nextLine());

			if (numToRoot < 0) {
				System.out.println("Input a positive number.");
				continue;
			} else if (numToRoot == 0) {
				foundRoot = true;
			} else if (!foundRoot) {
				for (int j = 1; j > 0; j++) {
					squareRoot = Double.parseDouble(df.format(squareRoot));
					square = squareRoot * squareRoot;

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

			if (foundRoot) {
				System.out.println("The " + ((square == numToRoot) ? "exact" : "approximate") + " square root of "
						+ numToRoot + " is " + squareRoot);
				for (int k = 1; k > 0; k++) {
					System.out.println("Would you like to try another number (y/n)");
					String yOrN = scan.nextLine();

					if (yOrN.equalsIgnoreCase("y")) {
						foundRoot = false;
						break;
					} else if (yOrN.equalsIgnoreCase("n")) {
						System.out.println("Thank you for rooting with us.\nGoodbye!");
						System.exit(0);
					} else {
						System.out.println("Please type y or n.");
						continue;
					}
				}
			}
		}
	}

}
