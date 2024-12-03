public abstract class Beverage {
	String name;
	Type type;
	Size size;
	final double BASE_PRICE = 2.0;
	final double SIZE_PRICE = 0.5;
	
	public Beverage(String name, Type type, Size size) {
		this.name = name;
		this.type = type;
		this.size = size;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}
	
	public double addSizePrice() {
		
		int sizeMultiplier = -1;
		
		if(size == Size.SMALL) {
			sizeMultiplier = 0;
		}else if(size == Size.MEDIUM) {
			sizeMultiplier = 1;
		}else if(size == Size.LARGE) {
			sizeMultiplier = 2;
		}
		
		return BASE_PRICE + (SIZE_PRICE * sizeMultiplier);
	}
	
	public abstract double calcPrice();
	
	@Override
	public String toString() {
		return "Name: " + name + ", Size: " + size + ", Type: " + type;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o == null) {
			return false;
		}
		
		if(o.getClass() != this.getClass()) {
			return false;
		}
		
		if(o == this) {
			return true;
		}
		
		Beverage other = (Beverage) o;
		
		if(this.name.equals(other.name) && this.size == other.size && this.type == other.type) {
			return true;
		}else {
			return false;
		}
	}
	
}
