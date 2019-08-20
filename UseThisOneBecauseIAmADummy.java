/*

Nathan Cohn 
August 15, 2019
First program in Java that prints out Hello World! to the console

*/
import java.util.*;

public class UseThisOneBecauseIAmADummy {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("I copy whatever you type until you type stop");
		
		for(int i = 1; i>0; i++) {
			String textToCopy = scan.nextLine();
			if(textToCopy.equalsIgnoreCase("stop")) {
				System.out.println("Aww. You don't want to play anymore. :( \nBye then!");
				System.exit(0);
			} else {
				System.out.println(textToCopy);
			}
		}
		
		scan.close();
	}
}
