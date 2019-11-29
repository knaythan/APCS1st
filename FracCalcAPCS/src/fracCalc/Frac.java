package fracCalc;

public class Frac {

	public int whole;
	public int numer;
	public int denom;

	public Frac(int whole, int numer, int denom) {
		this.numer = numer;
		this.denom = denom;
		this.whole = whole;
	}

	public Frac(int numer, int denom) {
		this(0, numer, denom);
	}

	public void simplify() {
		int gcf = gcf(numer, denom);
		numer = (numer / gcf);
		denom = (denom / gcf);
	}

	private int gcf(int a, int b) {
		a = (int) Math.abs(a);
		b = (int) Math.abs(b);
		int gcf = Math.min(a, b);

		while (gcf > 1) {
			if (a % gcf == 0 && b % gcf == 0) {
				return gcf;
			}
			gcf--;
		}
		return 1;
	}

	public String toString() {
		if (denom == 0) {
			return "ERROR: Divide by zero";
		}
		if (denom < 0) {
			denom = Math.abs(denom);
			numer *= -1;
		}
		if (whole != 0) {
			return whole + "_" + Math.abs(numer % denom) + "/" + denom;
		} else {
			return numer + "/" + denom;
		}
	}
}
