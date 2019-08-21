import java.util.*;

public class Test {

		public static void main(String[] args) {
			Scanner scan = new Scanner(System.in);
			
			boolean foundRoot = false;
			
			System.out.println("Input number to root below:");
			double inputNumber = Integer.parseInt(scan.nextLine());
			double initialNumber = 0.001;
			
			while(foundRoot == false) {
				if(initialNumber*initialNumber == inputNumber) {
					System.out.println("The square root of " + inputNumber + " is " + initialNumber);
					foundRoot = true;
				} else if(inputNumber == 0){
					System.out.println("The square root of 0 is 0");
					foundRoot = true;
				} else {
					initialNumber+=initialNumber;
				}
			}
		}
}
