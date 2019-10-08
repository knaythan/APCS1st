import java.util.ArrayList;

public class FracCalc { 
	public static double absValue(double num) {
		if (num < 0) {
			return -num;
		} else {
			return num;
		}
	}
	public static boolean isDivisibleBy(int a, int b) {
		if (a < b) {
			throw new IllegalArgumentException("First input must be greater than or equal to second input");
		}
		return a % b == 0;
	}
	public static double trueForMax(double[] inputList, boolean max) {
		ArrayList<Double> list = new ArrayList<>();
		for (int i = 0; i < inputList.length; i++) {
			list.add(inputList[i]);
		}

		int a = 0;
		int b = 1;
		while (list.size() != 1) {
			if (list.get(a) > list.get(b)) {
				list.remove((max) ? b : a);
			} else {
				list.remove((max) ? a : b);
			}
		}
		return list.get(0);
	}
	public static double max(double[] inputList) {
		return trueForMax(inputList, true);
	}
	public static double max(double a, double b) {
		return max(new double[] { a, b });
	}
	public static double min(double[] inputList) {
		return trueForMax(inputList, false);
	}
	public static int min(int a, int b) {
		return (int) min(new double[] { a, b });
	}
	public static int gcf(int a, int b) {
		a = (int) absValue(a);
		b = (int) absValue(b);
		int gcf	= min(a, b);

		while (gcf > 1) {
			if (isDivisibleBy(a, gcf) && isDivisibleBy(b, gcf)) {
				return gcf;
			}
			gcf--;
		}
		return 1;
	}
	public static ImpropFrac simplifyFrac(ImpropFrac frac) {
		int numer = frac.getNumer();
		int denom = frac.getDenom();
		int gcf = gcf(numer, denom);
		return new ImpropFrac(numer/gcf, denom/gcf);
	}	
	public static boolean isImprop(String frac) {
		if (frac.contains(" ")) {
			return false;
		}
		return true;
	}
	public static boolean isMixed(String frac) {
		if(frac.contains(" ")) {
			return true;
		}
		return false;
	}
	public static ImpropFrac addFrac(ImpropFrac frac1, ImpropFrac frac2) {
		double dec = frac1.toDouble() + frac2.toDouble();
		return decToFrac(dec);
	}	
	public static ImpropFrac subFrac(ImpropFrac frac1, ImpropFrac frac2) {
		frac2.setNumer(-frac2.getNumer());
		return addFrac(frac1, frac2);
		
	}	
	public static ImpropFrac decToFrac(double x) {
		if (x < 0) {
			ImpropFrac frac = decToFrac(-x);
			frac.setNumer(-frac.getNumer());
			return frac;
		}
		double tolerance = 1.0E-6;
		double numer = 1;
		double h2 = 0;
		double denom = 0;
		double k2 = 1;
		double b = x;
		do {
			double a = Math.floor(b);
			double aux = numer;
			numer = a * numer + h2;
			h2 = aux;
			aux = denom;
			denom = a * denom + k2;
			k2 = aux;
			b = 1 / (b - a);
		} while (Math.abs(x - numer / denom) > x * tolerance);

		return new ImpropFrac((int) numer, (int) denom);
	}
}
