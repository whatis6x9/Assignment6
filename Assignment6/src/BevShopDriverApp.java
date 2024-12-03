import java.util.Scanner;
import java.util.SplittableRandom;

public class BevShopDriverApp {
	public static void main(String[] args) {
		
		BevShop shop = new BevShop();
		Scanner scan = new Scanner(System.in);
		SplittableRandom rand = new SplittableRandom();
		
		System.out.println("The current order in process can have at most " + BevShopInterface.MAX_ORDER_FOR_ALCOHOL + " alcoholic beverages.");
		System.out.println("The minimum age to order alcohol drink is " + BevShopInterface.MIN_AGE_FOR_ALCOHOL);
		System.out.println("Please start a new order: ");
		
		shop.startNewOrder(-1, null, null, -1);			
		System.out.println("Your Total Order for now is: " + shop.totalOrderPrice(shop.getCurrentOrder().getOrderNum()));
		
		System.out.print("Would you please enter your name ");
		shop.getCurrentOrder().getShallowCustomer().setName(scan.nextLine());
		
		System.out.print("Would you please enter your age ");
		shop.getCurrentOrder().getShallowCustomer().setAge(scan.nextInt());
		scan.nextLine();
				
		if(shop.getCurrentOrder().getCustomer().getAge() >= BevShopInterface.MIN_AGE_FOR_ALCOHOL) {
			System.out.println("Your age is above 20 and you are eligible to order alcohol");
			
			String currentIteration;
			
			for(int i = 0; i < 3; i++) {
				
				currentIteration = switch (i+1) {
					case 1 -> {yield "an";}
					case 2 -> {yield "a second";}
					case 3 -> {yield "a third";}
					default -> throw new IllegalArgumentException("Unexpected value: " + i);
				};
				
				System.out.println("Would you please add " + currentIteration + " alcohol drink");
				
				shop.getCurrentOrder().addNewBeverage("Vigrin Sex On The Beach", Size.LARGE);
				
				System.out.println("The current order of drinks is " + shop.getCurrentOrder().getTotalItems());
				System.out.println("The Total price on the Order is " + shop.getCurrentOrder().calcOrderTotal());
				
				if(shop.getNumOfAlcoholDrink() < BevShopInterface.MAX_ORDER_FOR_ALCOHOL) {
					System.out.println("Your current alcohol drink order is less than 4");
				}else {
					break;
				}
			}
			
		}else {
			System.out.println("Your age is not above 20 and you are not eligible to order alcohol");
		}
		
		System.out.println("#------------------------------------#");
		
		Type curType;
		int randNum;
		
		System.out.println("Would you please start a new order");
		
		shop.startNewOrder(-1, null, null, -1);			
		
		System.out.print("Would you please enter your name ");
		
		if (scan.hasNextLine()) {
			shop.getCurrentOrder().getShallowCustomer().setName(scan.nextLine());
		}else {
			System.out.println("goof");
		}
						
		System.out.print("Would you please enter your age ");
		shop.getCurrentOrder().getShallowCustomer().setAge(scan.nextInt());
		
		for(int i = 0; i < 4; i++) {
			
			randNum = rand.nextInt(2);
			
			curType = switch (randNum + 1) {
				case 1 -> {yield Type.SMOOTHIE;}
				case 2 -> {yield Type.COFFEE;}
				case 3 -> {yield Type.ALCOHOL;}
				default -> throw new IllegalArgumentException("Unexpected value: " + rand + 1);
			};	
			
			System.out.println("The Total Price on the Order: " + shop.totalOrderPrice(shop.getCurrentOrder().getOrderNum()));
			System.out.println("Would you please add a " + curType + " to order");
			
			if(curType == Type.SMOOTHIE) {
				shop.getCurrentOrder().addNewBeverage("Big Ole Red", Size.LARGE, 3, true);
			}else if(curType == Type.COFFEE){
				shop.getCurrentOrder().addNewBeverage("Frappe", Size.LARGE, true, true);
			}else if(curType == Type.ALCOHOL){
				if(shop.getCurrentOrder().getCustomer().age < BevShopInterface.MIN_AGE_FOR_ALCOHOL) {
					System.out.println("Your Age is not appropriate for alcohol drink!!");
				}else {
					shop.getCurrentOrder().addNewBeverage("Virgin Sex On The Beach", Size.LARGE);
				}
			}
		}
		
		System.out.println("The Total Price on the Order: " +  shop.totalOrderPrice(shop.getCurrentOrder().getOrderNum()));
		System.out.println("Total amount for all Orders: " + shop.totalMonthlySale());
		
	}
}
