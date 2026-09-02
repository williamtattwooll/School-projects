package csc320_320;
import java.util.ArrayList;
import java.util.Scanner;

public class csc320_mod3_ct {
	public static void main(String[] args) {
		//value holding variables
		ArrayList<Double> groceries = new ArrayList<>();
		double sum = 0.0; // this will hold the monthly sum, and it will be used for averages
		double coupon = 0.0;
		double averageCost = 0.0; // this will hold the weekly cost
		double monthCost = 0.0;
		double couponWeek = 0.0;
		double couponMonth = 0.0;
		//control and temp variables.
		boolean nextVal = true;
		int count=0;
		double enteredValue = 0.0;
		//object values
		Scanner clientInput=new Scanner(System.in);
			
			
		//get the input from the user about the coupon
		System.out.print("enter the coupon in hundreths, (ie 15% you woud enter .15: ");
		coupon=clientInput.nextDouble();
		if (coupon < 0 || coupon > 1) {
			coupon = .1;
			System.out.println("Invalid coupon amount entered, setting to default of 10%");
		}
		
		//get grocieries input
		while (nextVal) {
			count += 1;
			System.out.print("enter this weeks groceries bill or 0 to stop: ");
			enteredValue = clientInput.nextDouble();
			if (enteredValue == 0) {
				nextVal = false;
			} else {
				groceries.add(enteredValue);
			}
			if (count == 4){
				nextVal = false;
				}
		} // close while
		clientInput.close();
		//now sum 
		for (double grocery : groceries) {
			sum += grocery;
		}
		//get costs
		if (groceries.size()>0) {
			averageCost = sum / groceries.size();
			couponWeek = averageCost * (1 - coupon);
		} else {
			System.out.println("not enough entered grocery costs");
		}
		monthCost = averageCost * 4;
		couponMonth = monthCost  * (1 - coupon);
		// finally show output
		System.out.println("Weekly average: " + averageCost);			
		System.out.println("Month average: " + monthCost);
		System.out.println("Weekly discounted average: " + couponWeek);
		System.out.println("Monthly discounted average: " + couponMonth);
	} // close main
} // close class
