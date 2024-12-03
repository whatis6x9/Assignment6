import java.util.SplittableRandom;
import java.util.ArrayList;

public class Order implements OrderInterface, Comparable<Order>{

	int orderNum;
	int orderTime;
	Day orderDay;
	Customer customer;
	ArrayList<Beverage> beverages;
	
	public Order(int orderTime, Day orderDay, Customer customer) {
		this.orderTime = orderTime;
		this.orderDay = orderDay;
		this.customer = customer;
		orderNum = generateOrder();
		beverages = new ArrayList<Beverage>();
	}
	
	public int getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

	public int getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(int orderTime) {
		this.orderTime = orderTime;
	}

	public Day getOrderDay() {
		return orderDay;
	}

	public void setOrderDay(Day orderDay) {
		this.orderDay = orderDay;
	}

	public Customer getCustomer() {
		return new Customer(customer);
	}
	
	public Customer getShallowCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public ArrayList<Beverage> getBeverages() {
		return beverages;
	}

	public void setBeverages(ArrayList<Beverage> beverages) {
		this.beverages = beverages;
	}
	
	public int generateOrder() {
		SplittableRandom rand = new SplittableRandom();
		
		return rand.nextInt(10000,90000);
		
	}
	@Override
	public boolean isWeekend() {
		if(orderDay == Day.SATURDAY || orderDay == Day.SUNDAY) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public Beverage getBeverage(int itemNo) {
		return beverages.get(itemNo);
	}

	@Override
	public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		beverages.add(new Coffee(bevName , size, extraShot, extraSyrup));
	}

	@Override
	public void addNewBeverage(String bevName, Size size) {
		beverages.add(new Alcohol(bevName , size, isWeekend()));		
	}

	@Override
	public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein) {
		beverages.add(new Smoothie(bevName , size, numOfFruits, addProtein));
	}
	
	public int getTotalItems() {
		
		if (beverages.isEmpty()) {
			return 0;
		}else {
			return beverages.size();
		}
	}

	@Override
	public double calcOrderTotal() {
		double toReturn = 0;
		
		for(int i = 0; i < beverages.size(); i++) {
			toReturn += beverages.get(i).calcPrice();
		}
		
		return toReturn;
	}

	@Override
	public int findNumOfBeveType(Type type) {
		int numOfType = 0;
		
		for(int i = 0; i < beverages.size(); i++) {
			if(beverages.get(i).getType() == type) {
				numOfType++;
			}
		}
		return numOfType;
	}
	
	@Override
	public String toString() {
		
		String beverageString = "Beverages: ";
		
		for(Beverage a : beverages) {
			beverageString += ", " + a.toString();
		}
		
		return "Order Time: " + orderTime + ", Order Num: " + orderNum + ", OrderDay: " + orderDay + ", " + beverageString;
	}
	
	@Override
	public int compareTo(Order anotherOrder) {
		if( orderNum < anotherOrder.getOrderNum()) {
			return 1;
		}else if(orderNum > anotherOrder.getOrderNum()) {
			return -1;
		}else {
			return 0;
		}
	}
}
