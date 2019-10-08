
public class ImpropFrac {
	private int numer, denom;
	
	public ImpropFrac(int numer, int denom) {
		this.numer = numer;
		this.denom = denom;
	}
	
	public int getNumer() {
		return numer;
	}
	
	public int getDenom() {
		return denom;
	}
	
	public void setNumer(int newNumer) {
		numer = newNumer;
	}
	
	public void setDenom(int newDenom) {
		denom = newDenom;
	}

	public MixedNum toMixedNum() {
		int whole = numer / denom;
		numer = numer % denom;
		return new MixedNum(whole, numer, denom);
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
		return (double) numer / (double) denom;
	}
	
	@Override
	public String toString() {
		return numer + "/" + denom;
	}
	
}
