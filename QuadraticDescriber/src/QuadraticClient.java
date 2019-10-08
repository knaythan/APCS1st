import java.util.*;

public class QuadraticClient {

	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		boolean repeat = true;

		System.out.println("Welcome to the Quadratic Describer");

		while (repeat) {
			System.out.println("Provide values for the co-efficients a, b, and c");
			double a = getScanner("a: ");
			double b = getScanner("b: ");
			double c = getScanner("c: ");

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

					String[] options = { "Equation", "Opening Direction", "Axis of Symmetry", "Vertex", "Intercepts", "All" };
					System.out.println("What would you like to find?");

					int selected = (int) getScanner(selection(options));

					if (selected <= 6 && selected >= 1) {
						if (selected == 1) {
							System.out.println(equation);
						} else if (selected == 2) {
							System.out.println(openDirection);
						} else if (selected == 3) {
							System.out.println(axis);
						} else if (selected == 4) {
							System.out.println(vertex);
						} else if (selected == 5) {
							System.out.println(intercepts);
						} else if (selected == 6) {
							System.out.println(result);
						}
						validOption = true;
					}
				}

				while (validOption) {
					String[] endOptions = { "Choose different option", "Enter new values", "Exit" };
					System.out.println("What would you like to do next?");
					int selected = (int) getScanner(selection(endOptions));

					if (selected <= 3 && selected >= 1) {
						if (selected == 2) {
							newValue = true;
						} else if (selected == 3) {
							newValue = true;
							repeat = false;
							System.out.println("Goodbye.");
						}
						validOption = false;
					}
				}
			}
		}

		scan.close();
	}

	private static String selection(String[] message) {
		String output = "";
		for (int i = 0; i < message.length; i++) {
			output += i + 1 + ". " + message[i] + "\n";
		}
		return output;
	}

	private static double getScanner(String message) {
		System.out.print(message);
		while (true) {
			try {
				double scanned = Double.parseDouble(scan.nextLine());
				return scanned;
			} catch (NumberFormatException ex) {
				System.out.print("Enter a valid input.\n" + message);
			}
		}
	}
}
