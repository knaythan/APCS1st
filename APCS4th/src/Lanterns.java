public class Lanterns {
	public static void main(String[] args) {
		// a.
		System.out.println("a.");
		int max = 5;
		int n = 1;
		while(n <= max) {
		    System.out.println(n);
		    n++;
		}
		System.out.println();

		// b.
		System.out.println("b.");
		int total = 25;
		int num = 1;
		while(num <= (total / 2)) {
		    total = total - num;
		    System.out.println(total + " " + num);
		    num++;
		}
		System.out.println();

		// c.
		System.out.println("c.");
		int i = 1;
		while(i <= 2) {
			int j = 1;
			while(j <= 3) {
				int k = 1;
				while(k <= 4) {
					System.out.print("*");
					k++;
				}
				System.out.print("!");
				j++;
			}
			System.out.println();
			i++;
		}

		// d.
		System.out.println("d.");
		int number = 4;
		int count = 1;
		while(count <= number) {
		    System.out.println(number);
		    number = number / 2;
		    count++;
		}
	}
}
