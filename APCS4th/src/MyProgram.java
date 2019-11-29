/*

Nathan Cohn 
August 15, 2019
First program in Java that prints out Hello World! to the console

*/
import java.util.*;

public class MyProgram {
	public static void main(String[] args) {
		ArrayList<String> spongebob = new ArrayList<>();
		spongebob.add("Patrick Star");
		spongebob.add("Squidward Tentacles");
		spongebob.add("Mr. Krabs");
		spongebob.add("Pikachu");
		spongebob.add("Sandy Cheeks");
		spongebob.set(3, "Sheldon Plankton");
		System.out.println(spongebob);
		
	}
}
