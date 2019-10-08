import java.util.*;

public class FracCalcClient {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Information");
		System.out.println("Input equation below:");
		String equations = scan.nextLine();
		
		String[] equation = equations.split(" ");
		System.out.println(Arrays.toString(equation));
	}
}
