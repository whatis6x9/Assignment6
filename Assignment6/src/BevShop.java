import java.util.ArrayList;
import java.util.Collections;

public class BevShop implements BevShopInterface{
	
	int numAlcohol;
	ArrayList<Order> orders;
	
	public BevShop() {
		numAlcohol = 0;
		orders = new ArrayList<Order>();
	}
	
	@Override
	public boolean isValidTime(int time) {
		if(time <= 23 && time >= 8) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public int getMaxNumOfFruits() {
		return MAX_FRUIT;
	}

	@Override
	public int getMinAgeForAlcohol() {
		return MIN_AGE_FOR_ALCOHOL;
	}

	@Override
	public boolean isMaxFruit(int numOfFruits) {
		if(numOfFruits > MAX_FRUIT) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public int getMaxOrderForAlcohol() {
		return MAX_ORDER_FOR_ALCOHOL;
	}

	@Override
	public boolean isEligibleForMore() {
		return !(numAlcohol < MAX_ORDER_FOR_ALCOHOL);
	}

	@Override
	public int getNumOfAlcoholDrink() {
		return numAlcohol;
	}

	@Override
	public boolean isValidAge(int age) {
		if(age < MIN_AGE_FOR_ALCOHOL) {
			return false;
		}else {
			return true;
		}
	}

	@Override
	public void startNewOrder(int time, Day day, String customerName, int customerAge) {
		numAlcohol = 0;
		orders.add(new Order(time, day, new Customer(customerName, customerAge)));
	}

	@Override
	public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		getCurrentOrder().addNewBeverage(bevName, size, extraShot, extraSyrup);
	}

	@Override
	public void processAlcoholOrder(String bevName, Size size) {
		getCurrentOrder().addNewBeverage(bevName, size);
	}

	@Override
	public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein) {
		getCurrentOrder().addNewBeverage(bevName, size, numOfFruits, addProtein);
	}

	@Override
	public int findOrder(int orderNo) {
		for(int i = 0; i < orders.size(); i++) {
			if(orderNo == orders.get(i).getOrderNum()) {
				return i;
			}
		}
		
		return -1;
	}

	@Override
	public double totalOrderPrice(int orderNo) {
		
		if(orders.isEmpty()) {
			return 0;
		}else {
			return orders.get(findOrder(orderNo)).calcOrderTotal();	
		}
	}

	@Override
	public double totalMonthlySale() {
		double sum = 0;
		
		for(Order a: orders) {
			sum += a.calcOrderTotal();
		}
		
		return sum;
	}

	@Override
	public int totalNumOfMonthlyOrders() {
		return orders.size();
	}

	@Override
	public Order getCurrentOrder() {
		if (orders.isEmpty()) {
			return null;
		}else {
			return orders.get(orders.size() - 1);
		}
	}

	@Override
	public Order getOrderAtIndex(int index) {
		return orders.get(index);
	}

	@Override
	public void sortOrders() {
		int length = orders.size();
		
		for(int i = 0; i < length -1; i++) {
			int min = i;
			
			for(int j = i + 1; j < length; j++) {
				if(orders.get(j).getOrderNum() < orders.get(min).getOrderNum()) {
					min = j;
				}
			}
			
			Collections.swap(orders, min, i);
		}
	}
	
	public String toString() {
		String toReturn = "Orders: ";
		
		for(Order a: orders) {
			toReturn += a.toString();
		}
		
		return toReturn;
	}

}
