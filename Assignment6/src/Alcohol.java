
public class Alcohol extends Beverage{

	boolean weekend;

	public Alcohol(String name, Size size, boolean weekend) {
		super(name, Type.ALCOHOL, size);
		this.weekend = weekend;
	}

	public boolean isWeekend() {
		return weekend;
	}



	public void setWeekend(boolean weekend) {
		this.weekend = weekend;
	}

	
	@Override
	public String toString() {
		return super.toString() + ", Weekend: " + weekend;
	}
	
	@Override
	public double calcPrice() {
		double toAdd = 0;
		
		if(weekend) toAdd += 0.6;
		
		return super.addSizePrice() + toAdd;
	}
	
	@Override
	public boolean equals(Object o) {
		Alcohol other = (Alcohol) o;
		
		if(super.equals(other) && other.weekend == this.weekend) {
			return true;
		}else {
			return false;
		}
	}
	
}
