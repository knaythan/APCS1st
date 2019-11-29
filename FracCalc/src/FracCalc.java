import java.util.*;

public class FracCalc { 
	
	public static int gcf(int a, int b) {
		a = (int) Math.abs(a);
		b = (int) Math.abs(b);
		int gcf	= Math.min(a, b);

		while (gcf > 1) {
			if (a % gcf == 0 && b % gcf == 0) {
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
	public static ImpropFrac multiplyFrac(ImpropFrac frac1, ImpropFrac frac2) {
		int numer = frac1.getNumer() * frac2.getNumer();
		int denom = frac1.getDenom() * frac2.getDenom();
		ImpropFrac frac = new ImpropFrac(numer, denom);
		return frac;
	}
	public static ImpropFrac divideFrac(ImpropFrac frac1, ImpropFrac frac2) {
		int numer = frac2.getNumer();
		frac2.setNumer(frac2.getDenom());
		frac2.setDenom(numer);
		return multiplyFrac(frac1, frac2);
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
