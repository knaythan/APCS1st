import java.util.*;

public class QuadraticClient {

	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		boolean repeat = true;

		System.out.println("Welcome to the Quadratic Describer");

		while (repeat) {
			System.out.println("Provide values for the co-efficients a, b, and c");
			System.out.print("a: ");
			double a = getDouble();
			System.out.print("b: ");
			double b = getDouble();
			System.out.print("c: ");
			double c = getDouble();

			String result = Quadratic.quadrDescriber(a, b, c);

			String equation = "Equation: " + result.substring(result.indexOf("of"), result.indexOf("Open"));
			String openDirection = result.substring(result.indexOf("Open"), result.indexOf("Axis"));
			String axis = result.substring(result.indexOf("Axis"), result.indexOf("Vertex"));
			String vertex = result.substring(result.indexOf("Vertex"), result.indexOf("x-intercept"));
			String intercepts = result.substring(result.indexOf("x-intercept"));

			boolean newValue = false;
			while (!newValue) {
				boolean validOption = false;
				while (!validOption) {

					String[] options = { "Equation", "Opening Direction", "Axis of Symmetry", "Vertex", "Intercepts",
							"All" };
					System.out.println("What would you like to find?");

					for (int i = 0; i < options.length; i++) {
						System.out.println(i + 1 + ". " + options[i]);
					}
					int selected = getInteger();

					if (selected <= 6 && selected >= 1) {
						if (selected == 1) {
							System.out.println(equation);
						} else if (selected == 2) {
							System.out.println(openDirection);
						} else if (selected == 3) {
							System.out.println(vertex);
						} else if (selected == 4) {
							System.out.println(axis);
						} else if (selected == 5) {
							System.out.println(intercepts);
						} else if (selected == 6) {
							System.out.println(result);
						}
						validOption = true;
					} else {
						System.out.println("Enter a valid option.");
					}
				}

				while (validOption) {
					String[] endOptions = { "Choose different option", "Enter new values", "Exit" };
					System.out.println("What would you like to do next?");

					for (int i = 0; i < endOptions.length; i++) {
						System.out.println(i + 1 + ". " + endOptions[i]);
					}
					int selected = getInteger();

					if (selected <= 4 && selected >= 1) {
						if (selected == 2) {
							newValue = true;
						} else if (selected == 3) {
							newValue = true;
							repeat = false;
							System.out.println("Goodbye.");
						}
						validOption = false;
					} else {
						System.out.println("Enter a valid option.");
					}
				}
			}
		}

		scan.close();
	}

	private static double getDouble() {
		while (true) {
			try {
				double scanned = Double.parseDouble(scan.nextLine());
				return scanned;
			} catch (NumberFormatException ex) {
				System.out.println("Enter a valid number");
			}
		}
	}
	
	private static int getInteger() {
		while(true) {
			try {
				int scanned = Integer.parseInt(scan.nextLine());
				return scanned;
			} catch (NumberFormatException ex) {
				System.out.println("Enter a valid number");
			}
		}
	}
}
