import java.util.*;

public class RootFinder {
	public static void main(String[] args) {
		for(int i = 0; i < 1000; i+=100) {
			for(int j = 0; i < 100; j+=10) {
				for(int k = 1; k <= 10; k++) {
					System.out.println(i + j + k);
				}
			}
		}
	}
}