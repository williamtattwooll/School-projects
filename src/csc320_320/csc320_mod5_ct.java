package csc320_320;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class csc320_mod5_ct {
	public static void main (String[] args){

		// the  values
		int dayValue; 
		int sum=0;
		double average=0;
		double averageWeek=0;
		ArrayList<Integer> dailyTemp= new ArrayList<>();
		ArrayList<Double> dailyAverage = new ArrayList<>();
		
		
		// to generate the values used in the arrays
		int maxTemp=100;
		int minTemp=60;
		Random random = new Random();

		//the requested day, and below the input to get it
		String menu="""
			1. Sunday
			2. Monday
			3. Tuesday
			4. Wednesday
			5. Thursday
			6. Friday
			7. Saturday
			8. Weekly average
			9. Quit\r
			""";
		String[] weekDay= new String[]{
			"Sunday",
			"Monday",
			"Tuesday",
			"Wednesday",
			"Thursday",
			"Friday",
			"Saturday"
		};
		boolean continueInput = true;
		Scanner whichDay=new Scanner(System.in);
		int menuInput;
		
		//populate the arrays with their values and averages
		for (int i=1;i<8;i++) {
			dayValue=random.nextInt(maxTemp-minTemp+1)+60;
			dailyTemp.add(dayValue);
			sum +=dayValue;
		    average =(double)sum/i;
			dailyAverage.add(average);
		}
		averageWeek = (double) sum/7;
		
		//now get the day and output 
		while (continueInput) {
			System.out.println(menu);
			// in case they enter something other then an integer
			try {
				menuInput= whichDay.nextInt();
			}
			catch (RuntimeException e) {
				System.out.println("invalid entry");
				whichDay.next(); // prevent a  token issue which was pointed outto me
				continue;
			
			}
			//offset menuinput for 0 based arrays, then print out
			menuInput -= 1;
			switch (menuInput){
				case 0,1,2,3,4,5,6 ->{
					System.out.print(
						"For the day of " + weekDay[menuInput] +
						" the temperature was " + dailyTemp.get(menuInput));
						System.out.printf(" and the average for that day was %.1f%n", dailyAverage.get(menuInput));
						System.out.println("");
				}
				case 7->{
					System.out.printf("The weekly average is %.1f%n", averageWeek);
					System.out.println("");
				}
				case 8 -> {
					continueInput = false;
					System.out.println("Thanks for playing");
					whichDay.close();
				}
				default -> {
					System.out.println("Invalid menu option");
				} 
			}//close switch
		} // close while
	} // close method
}//close class

