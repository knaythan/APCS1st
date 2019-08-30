import java.util.*;

public class Calculate {

	public static int square(int square) {
		return square * square;
	}

	public static double pow(double num, double power) {
		double numToPower = num;
		for (int i = 1; i <= power - 1; i++) {
			numToPower *= num;
		}
		return numToPower;
	}

	public static double avg(ArrayList<Double> listToAvg) {
		double total = 0;
		for (Double num : listToAvg) {
			total += num;
		}
		return total / listToAvg.size();
	}
	
	public static double abs(double num) {
		if(num < 0) {
			num *= -1;
		}
		return num;
	}
	
	public static double gcd(double a, double b) {
		a = abs(a);
		b = abs(b);
		
		if (a == 0 || a == 1) {
			return (a == 0) ? b : a;
		} else if (b == 0 || b == 1) {
			return (b == 0) ? a : b;
		} else {
			if(b > a) {
				while(b%a != 0) {
					b %= a;
					a %= b;
				}
				return a;
			} else {
				while(a%b != 0) {
					a %= b;
					b %= a;
				}
				return b;
			}
		}
	}


	
	
}
