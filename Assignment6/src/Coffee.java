public class Coffee extends Beverage{
	
	boolean extraShot;
	boolean extraSyrup;

	public Coffee(String name, Size size, boolean extraShot, boolean extraSyrup) {
		super(name, Type.COFFEE, size);
		this.extraShot = extraShot;
		this.extraSyrup = extraSyrup;
	}
	
	public boolean isExtraShot() {
		return extraShot;
	}

	public void setExtraShot(boolean extraShot) {
		this.extraShot = extraShot;
	}

	public boolean isExtraSyrup() {
		return extraSyrup;
	}

	public void setExtraSyrup(boolean extraSyrup) {
		this.extraSyrup = extraSyrup;
	}

	@Override
	public double calcPrice() {
		double toAdd = 0;
		
		if(extraShot) toAdd += 0.5;
		if(extraSyrup) toAdd += 0.5;
		
		return super.addSizePrice() + toAdd;
	}

	@Override
	public String toString() {
		return super.toString() + ", Extra Shot: " + extraShot + ", Extra Syrup: " + extraSyrup;
	}
	
	@Override
	public boolean equals(Object o) {
		Coffee other = (Coffee) o;
		
		if(super.equals(other) && other.extraShot == this.extraShot && other.extraSyrup == this.extraSyrup) {
			return true;
		}else {
			return false;
		}
	}
}
