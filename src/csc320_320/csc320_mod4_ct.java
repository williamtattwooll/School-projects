package csc320_320;
import java.util.ArrayList;
import java.util.Scanner;


public class csc320_mod4_ct {
	public static void main(String[] args) {
	// init vars
	ArrayList<Double> grades = new ArrayList<>();
	Double min = 100.0;
	Double max = 0.0;
	Scanner gradeInput= new Scanner(System.in);
	Double gradeValue;
	Double sum = 0.0;
	Double gradeAverage = 0.0;
	
	//enter values
	for(int i = 0;i < 10;i++) {  
		System.out.print("Enter the grade number " + (i +1) + ": ");
		gradeValue= gradeInput.nextDouble();
		grades.add(gradeValue);
	    }
	//find stats
	for (Double grade : grades) {
		sum += grade;
		if (grade < min) {
			min = grade;
		    }
		if (grade > max) {
			max = grade;
		 }
	    }//end for
	if (grades.size() >0) {
		gradeAverage=sum/(grades.size());
	} else {
		System.out.println("no grades were entered");
		}
	System.out.println("Lowest grade: " + min);
	System.out.println("Average grade: " + gradeAverage);
	System.out.println("Highest grade: " + max);
	}//end main
} //end class
