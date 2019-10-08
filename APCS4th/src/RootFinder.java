import java.util.*;

public class RootFinder {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Input the size of the hourglass: ");
		int size = scan.nextInt();
		String topBot = "|";
		for (int cover = 1; cover <= size; cover++) {
			topBot += "\"";
		}
		topBot += "|";
		System.out.println(topBot);
		for (int half = 1; half <= 2; half++) {
			String spaces = "";
			for (int glass = 1; glass < (int) ((size / 2) + 0.5); glass++) {
				int line = 0;
				if(half == 1) {
					line = glass;
				} else {
					line = (int) ((size / 2) + 0.5) - glass;
				}
				for (int space = 1; space <= line; space++) {
					spaces += (line == (size / 2) - 1) ? " " : "";
					System.out.print(" ");
				}
				System.out.print((half == 1) ? "\\" : "/");
				for (int sand = 1; sand <= size - (line * 2); sand++) {
					System.out.print(":");
				}
				System.out.println((half == 1) ? "/" : "\\");
			}
			System.out.println((half == 1) ? spaces + " ||" : topBot);
		}
	}
}