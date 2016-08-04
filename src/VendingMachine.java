/**
 * Title: VendingMachine.java
 * Abstract: Virtual vending machine. (Homework 3)
 * Author: Arash Aria
 * ID: 4210
 * Date: 06/10/16
 */

import java.text.DecimalFormat;
import java.util.Scanner;


public class VendingMachine {

	private final double waterPrice = 1.50;
	private final double coffeePrice = 2.00; 
	private final double chipsPrice = 1.00;
	private final double chocolatePrice = 2.50;
	
	private int serialNumber;
	private String location;
	
	private int waterCt;
	private int coffeeCt; 
	private int chipsCt;
	private int chocolateCt;
	
	private int[] transactions;
	private double[] statusHelper;
	
	public VendingMachine(int serial){
		
		this.location = "UNKNOWN";
		this.serialNumber = serial;
		this.waterCt = 0;
		this.coffeeCt = 0;
		this.chipsCt = 0;
		this.chocolateCt = 0;
		
	}
	
	public VendingMachine(int serial, String location){
		
		this.location = location;
		this.serialNumber = serial;
		this.waterCt = 0;
		this.coffeeCt = 0;
		this.chipsCt = 0;
		this.chocolateCt = 0;
		
	}
	
	public void addItems(int water, int coffee, int chips, int choco){
		
		this.waterCt += water;
		this.coffeeCt += coffee;
		this.chipsCt += chips;
		this.chocolateCt += choco;
		transactions = new int[] {this.waterCt,this.coffeeCt,this.chipsCt,this.chocolateCt};
		
	}
	
	public void reset(int water, int coffee, int chips, int choco){
		
		this.waterCt = water;
		this.coffeeCt = coffee;
		this.chipsCt = chips;
		this.chocolateCt = choco;
		transactions = new int[] {this.waterCt,this.coffeeCt,this.chipsCt,this.chocolateCt};
		
	}
	
	public void setTransactions(int[] transactions) {
		this.transactions = transactions;
	}

	public void displayMenu(){
		
		System.out.println("===== Vending Machine Menu =====");
		System.out.println("Water............$" + getWaterPrice());
		System.out.println("Regular Coffee...$" + getCoffeePrice());
		System.out.println("Sun Chips........$" + getChipsPrice());
		System.out.println("Chocolate Bar....$" + getChocolatePrice());		
		
	}
	
	public void buyItem(){
		
		Scanner scan = new Scanner(System.in);
		
		
		System.out.println("Select an item number: ");
		int itemNumber = scan.nextInt();
		
		
		System.out.println("How many do you want to buy? ");
		int itemCount = scan.nextInt();
		
		this.buyItem(itemNumber, itemCount);
		
		
		
	}
	
	public boolean buyItem(int itemNumber, int itemCount){
		
		if (itemNumber == 1)
		{
			if (itemCount <= this.waterCt)
			{
				System.out.println("You selected Water. Quantity: " + itemCount);
				 waterCt -= itemCount;
				 return true;
			} else { return false; }
		} else if (itemNumber == 2)
		{
			if (itemCount <= this.coffeeCt)
			{
				System.out.println("You selected Coffee. Quantity: " + itemCount);
				coffeeCt -= itemCount;
				return true;
			} else { return false; }
		} else if (itemNumber == 3)
		{
			if (itemCount <= this.chipsCt)
			{
				System.out.println("You selected Chips. Quantity: " + itemCount);
				chipsCt -= itemCount;
				return true;
			} else { return false; }
		} else if (itemNumber == 4)
		{
			if (itemCount <= this.chocolateCt)
			{
				System.out.println("You selected Chocolate. Quantity: " + itemCount);
				chocolateCt -= itemCount;
				return true;
			} else { return false; }
		} else {
			return false;
		}
		
		
	}
	
	public void returned(int itemNumber, int itemCount){
		
		if (itemNumber == 1)
		{
			
				waterCt += itemCount;
				
				System.out.println("You returned Water. Quantity: " + itemCount);
				
			
		} else if (itemNumber == 2)
		{
				
				coffeeCt += itemCount;
				
				System.out.println("You returned Coffee. Quantity: " + itemCount);
				
			
		} else if (itemNumber == 3)
		{
			
				chipsCt += itemCount;
				
				System.out.println("You returned Chips. Quantity: " + itemCount);
				
		
		} else if (itemNumber == 4)
		{
			
				chocolateCt += itemCount;
				
				System.out.println("You returned Chocolate. Quantity: " + itemCount);
				
			
		} else {
			System.out.println("Wrong input!!!");
		}
		
	}

	public String toString(){
	
		return "Serial Number: " + getSerialNumber() +
				"\nLocation: "+ getLocation() +
				"\nContents: " +
				"\n  Water:  " + getWaterCt() +
				"\n  Coffee:  " + getCoffeeCt() +
				"\n  Sun Chips:  " + getChipsCt() +
				"\n  Chocolate Bar:  " + getChocolateCt();
	}
	
	public int getSerialNumber() {
		return serialNumber;
	}

	public void setName(int serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public double getWaterPrice() {
		return waterPrice;
	}

	public double getCoffeePrice() {
		return coffeePrice;
	}

	public double getChipsPrice() {
		return chipsPrice;
	}

	public double getChocolatePrice() {
		return chocolatePrice;
	}

	public int getWaterCt() {
		return waterCt;
	}

	public int getCoffeeCt() {
		return coffeeCt;
	}

	public int getChipsCt() {
		return chipsCt;
	}

	public int getChocolateCt() {
		return chocolateCt;
	}

	public boolean payment() {
		
		double amount = 0; 
		if (transactions[0] > waterCt)
		{
			amount = amount + ((transactions[0] - waterCt)*waterPrice); 
		}
		if (transactions[1] > coffeeCt)
		{
			amount = amount + ((transactions[1] - coffeeCt)*coffeePrice);
		}
		if (transactions[2] > chipsCt)
		{
			amount = amount + ((transactions[2] - chipsCt)*chipsPrice);
		}
		if (transactions[3] > chocolateCt)
		{
			amount = amount + ((transactions[3] - chocolateCt)*chocolatePrice);
		}
		
		amount = amount + amount*0.1;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter money amount: $ ");
		
		double userPayment = scan.nextDouble();
		
		DecimalFormat df = new DecimalFormat("#.##");

		
		if (userPayment < amount)
		{
			System.out.print("Insufficient money. $" + df.format(userPayment) + " returned");
			return false;
		} else {
			System.out.print("Sufficient money. $" + df.format(userPayment-amount) + " returned");
			statusHelper = new double[] {transactions[0] - waterCt,
											transactions[1] - coffeeCt,
											transactions[2] - chipsCt,
											transactions[3] - chocolateCt,
											amount};
			return true;
		}

	}

	public void displayReceipt() {
		
		double amount = 0; 
		DecimalFormat df = new DecimalFormat("#.##");
		if (transactions[0] > waterCt)
		{
			System.out.println("Water: $" + df.format(waterPrice) + " X " + (transactions[0] - waterCt) + " = $" + 
								df.format(((transactions[0] - waterCt)*waterPrice)));
			amount = amount + ((transactions[0] - waterCt)*waterPrice); 
		}
		if (transactions[1] > coffeeCt)
		{
			System.out.println("Coffee: $" + df.format(coffeePrice) + " X " + (transactions[1] - coffeeCt) + " = $" + 
					df.format(((transactions[1] - coffeeCt)*coffeePrice)));
			amount = amount + ((transactions[1] - coffeeCt)*coffeePrice);
		}
		if (transactions[2] > chipsCt)
		{
			System.out.println("Chips: $" + df.format(chipsPrice) + " X " + (transactions[2] - chipsCt) + " = $" + 
					df.format(((transactions[2] - chipsCt)*chipsPrice)));
			amount = amount + ((transactions[2] - chipsCt)*chipsPrice);
		}
		if (transactions[3] > chocolateCt)
		{
			System.out.println("Chocolate: $" + df.format(chocolatePrice) + " X " + (transactions[3] - chocolateCt) + " = $" + 
					df.format(((transactions[3] - chocolateCt)*chocolatePrice)));
			amount = amount + ((transactions[3] - chocolateCt)*chocolatePrice);
		}
		
		System.out.println("Tax (10.0%): $" + df.format(amount*0.1));
		
		amount = amount + amount*0.1;
		
		System.out.println("Total: $" + df.format(amount));
		
		
	}

	public void status() {
		
		System.out.println("Serial Number: " + this.getSerialNumber());
		System.out.println("Location: " + this.getLocation());
		
		System.out.println("Sold items: ");
		System.out.println("\n  Water:  " + statusHelper[0] +
							"\n  Coffee:  " + statusHelper[1] +
							"\n  Sun Chips:  " + statusHelper[2] +
							"\n  Chocolate Bar:  " + statusHelper[3] + 
							"\nTotal earning:  $" + statusHelper[4]);
		System.out.println();
		System.out.println("Current items:");
		System.out.println("\n  Water:  " + getWaterCt() +
							"\n  Coffee:  " + getCoffeeCt() +
							"\n  Sun Chips:  " + getChipsCt() +
							"\n  Chocolate Bar:  " + getChocolateCt());
		
		
	}
	
	
	
	
	
	

	

}
