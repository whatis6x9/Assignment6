
public class Smoothie extends Beverage{

	int numOfFruits;
	boolean protienAdded;
	
	public Smoothie(String name, Size size, int numOfFruits, boolean protienAdded) {
		super(name, Type.SMOOTHIE, size);
		this.numOfFruits = numOfFruits;
		this.protienAdded = protienAdded;
	}
	
	public int getNumOfFruits() {
		return numOfFruits;
	}

	public void setNumOfFruits(int numOfFruits) {
		this.numOfFruits = numOfFruits;
	}

	public boolean isProtienAdded() {
		return protienAdded;
	}

	public void setProtienAdded(boolean protienAdded) {
		this.protienAdded = protienAdded;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", Number Of Fruits: " + numOfFruits + ", Protien Added: " + protienAdded;
	}
	
	@Override
	public double calcPrice() {
		double toAdd = 0;
		
		if(protienAdded) toAdd += 1.5;
		toAdd += (numOfFruits * 0.5);
		
		return super.addSizePrice() + toAdd;
	}
	
	@Override
	public boolean equals(Object o) {
		Smoothie other = (Smoothie) o;
		
		if(super.equals(other) && other.numOfFruits == this.numOfFruits && other.protienAdded == this.protienAdded) {
			return true;
		}else {
			return false;
		}
	}
}
