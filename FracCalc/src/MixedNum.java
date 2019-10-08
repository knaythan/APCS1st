
public class MixedNum {
	private int whole, numer, denom;
	

	public MixedNum(int whole, int numer, int denom) {
		this.whole = whole;
		this.numer = numer;
		this.denom = denom;
	}

	public MixedNum(int whole, ImpropFrac frac) {
		this(whole, frac.getNumer(), frac.getDenom());
	}
	
	public int getWhole() {
		return whole;
	}
	
	public int getNumer() {
		return numer;
	}
	
	public int getDenom() {
		return denom;
	}
	
	public void setWhole(int newWhole) {
		whole = newWhole;
	}
	
	public void setNumer(int newNumer) {
		numer = newNumer;
	}
	
	public void setDenom(int newDenom) {
		denom = newDenom;
	}

	public ImpropFrac toImpropFrac() {
		numer = (whole * denom) + numer;
		return new ImpropFrac(numer, denom);
	}
	
	public boolean isWhole() {
		double dec = (numer + 0.0)/(denom + 0.0);
		int whole = numer/denom;
		String num = "" + dec;
		if(num.equals(whole + ".0")) {
			return true;
		} else {
			return false;
		}
	}
	
	public double toDouble() {
		return (double) whole * ((double) numer / (double) denom);
	}
	
	@Override
	public String toString() {
		return whole + " " + numer + "/" + denom;
	}
}
