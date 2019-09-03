public class Test {
    public static void main(String[] args) {
    	// a.
    	System.out.println("a.");
    	int max = 5;
    	for (int n = 1; n <= max; n++) {
    	    System.out.println(n);
    	}
    	System.out.println();

    	// b.
    	System.out.println("b.");
    	int total = 25;
    	for (int number = 1; number <= (total / 2); number++) {
    	    total = total - number;
    	    System.out.println(total + " " + number);
    	}
    	System.out.println();

    	// c.
    	System.out.println("c.");
    	for (int i = 1; i <= 2; i++) {
    	    for (int j = 1; j <= 3; j++) {
    	        for (int k = 1; k <= 4; k++) {
    	            System.out.print("*");
    	        }
    	        System.out.print("!");
    	    }
    	    System.out.println();
    	}
    	System.out.println();

    	// d.
    	System.out.println("d.");
    	int number = 4;
    	for (int count = 1; count <= number; count++) {
    	    System.out.println(number);
    	    number = number / 2;
    	}
    }
}
