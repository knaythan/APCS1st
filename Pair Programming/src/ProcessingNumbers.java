import java.util.*;

public class ProcessingNumbers {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to the number processer!");
		System.out.print("How many numbers: ");
		int totalNumbers = scan.nextInt();
		int max = -2147483648;
		int min = 2147483647;
		
		int numOdds = 0;
		int sum = 0;
		for(int i = 1; i <= totalNumbers; i++) {
			System.out.print("#" + i + ": ");
			int scanned = scan.nextInt();
			if(scanned > max) {
				max = scanned;
			}
			if(scanned < min) {
				min = scanned;
			}
			if(scanned % 2 == 0) {
				sum += scanned;
			} else {
				numOdds++;
			}
		}
		System.out.println("max: " + max + "\tmin: " + min);
		if(numOdds == totalNumbers) {
			System.out.println("No even numbers entered");
		} else {
			System.out.println("sum of even numbers: " + sum);
		}
		scan.close();
	}
}
