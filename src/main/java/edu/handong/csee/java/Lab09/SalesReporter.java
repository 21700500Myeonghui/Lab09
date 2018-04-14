package edu.handong.csee.java.Lab09;//Instructs the SalesReporter class to be complied and stored in edu.handong.csee.java.lab09

import java.util.Scanner;//importing a package, java.util.Scanner. A package is a kind of external objects created by other developer
import java.util.ArrayList;

/**
 * This class defines a SalesReporter object
 * The SalesReporter class has highestSales, averageSales, team, numOfSalesman members
 * The SalesReporter class has SalesReporter(), getData(), computeHighestSales(), computeaverageSales(), displayResults(), differenceAverage(), main methods
 * @author Lee MyeongHui
 * @version java version "9.0.4"
 *
 */
public class SalesReporter {
	private double highestSales;//Create double type Instance variable highestSales
	private double averageSales;//Create double type Instance variable averageSales
	private ArrayList<SalesAssociate> team= new ArrayList<SalesAssociate>();
	
	/**
	 * This is constructor for initializing object
	 * constructor without parameter
	 */
	public SalesReporter()
	{
		
	}

	/**
	 * This is a method for getting data
	 */
	public void getData()
	{

		boolean getDT=true;
		
		Scanner keyboard= new Scanner(System.in);
		
		while(getDT==true)
		{
			System.out.print("Enter name of sales associate: ");//Outputs the string literal "Enter name of sales associate: "
			String name= keyboard.nextLine();//Create String type local variable name, Take one string from the keyboard and place it in name

			System.out.print("Enter associate's sales: $");//Outputs the string literal "Enter associate's sales: $"
			double sales = keyboard.nextDouble();//Create double type local variable sales, Take one double from the keyboard and place it in sales
		
			SalesAssociate member=new SalesAssociate();
			member.setName(name);
			member.setSales(sales);
			
			team.add(member);
			
			System.out.println("More data for the team");
			String answer=keyboard.nextLine();
			
			if(!answer.equalsIgnoreCase("yes"))
				getDT=true;
		}
		
	}

	/**
	 * This is method for computing highestSales
	 */
	public void computeHighestSales()
	{
		highestSales=team.get(0).getSales();
		
		for(SalesAssociate member: team)
		{
			if(highestSales <member.getSales())
				highestSales=member.getSales();
		}
	}

	/**
	 * This is a method for computing averageSales
	 */
	public void computeaverageSales()
	{
		double sum=0;//Create double type local variable sum, put 0 in sum

		for(SalesAssociate member: team)
		{
			sum+=member.getSales();
		}
		averageSales=sum/team.size();
		
	}

	/**
	 * This is a method for displaying Results
	 */
	public void displayResults()
	{
		System.out.println("Average sales per associate is $"+averageSales);//Outputs "Average sales per associate is $ ' the value of Instance variable averageSales'"
		System.out.println("The highest sales figure is $"+highestSales);//Outputs "The highest sales figure is $ ' the value of Instance variable highestSales'"

		System.out.println("The following had the highest sales:");//Outputs the string literal "The following had the highest sales:"
		for(SalesAssociate member:team)//Create integer type local variable i, Put 0 in variable i, increase i by 1, Repeat until i is smaller than the size of the array team.
		{
			if(highestSales == member.getSales())//if the value of highestSales and the return value of method getSales() in i-th of array team are the same
			{
				System.out.println("Name: " + member.getName());//Outputs "Name: ' the return value of method getName() in i-th of array team'"
				System.out.println("Sales: $ "+highestSales);//Outputs "Sales: $ 'the value of Instance variable highestSales'"
				differenceAverage(member.getSales());//calling method differenceAverage(double iSales), Send the return value of method getSales() in i-th of array team as value of the parameter at this time
			}
		}

		System.out.println("The rest performed as follows: ");// Output the string literal "The rest performed as follows: "
		for(SalesAssociate member2: team)//Create integer type local variable j, Put 0 in variable j, increase j by 1, Repeat until j is smaller than the size of the array team.
		{
			if(highestSales != member2.getSales())//if the value of highestSales and the return value of method getSales() in j-th of array team are not the same
			{
				System.out.println("Name: "+member2.getName());//Outputs "Name: ' the return value of method getName() in j-th of array team'"
				System.out.println("Sales: "+member2.getSales());//Outputs "Sales: $ 'the return value of method getSales() in j-th of array team'"
				differenceAverage(member2.getSales());//calling method differenceAverage(double iSales), Send the return value of method getSales() in j-th of array team as value of the parameter at this time
			}
		}
	}

	/**
	 * This is a method to compare differences from the average.
	 * @param iSales, it is double type
	 */
	public void differenceAverage(double iSales)
	{
		if(averageSales<iSales)//if the value of averageSales is less than the value of iSales
		{
			System.out.println("$"+(iSales-averageSales)+" above the average");//Output "$ 'the value of the value of iSales minus the value of averageSales' above the average"
		}
		else if(averageSales>iSales)//if the value of averageSales is larger than the value of iSales
		{
			System.out.println("$"+(averageSales-iSales)+" below the average");//Output "$ 'the value of the value of averageSales minus the value of iSales' below the average"
		}
		else if(averageSales==iSales)//if the value of averageSales and the value of iSales are the same
		{
			System.out.println("It's the same as the average.");//Output the string literal "It's the same as the average."
		}
	}
	

	/**
	 * This is main method that starts our program.
	 * @param args, String arrays, called args, can be received as the method's factor values.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SalesReporter myReporter = new SalesReporter();//Instantiate of an object

		myReporter.getData();//calling method getData() in myReporter 
		myReporter.computeHighestSales();//calling method computeHighestSales() in myReporter
		myReporter.computeaverageSales();//calling method computeaverageSales() in myReporter
		myReporter.displayResults();//calling method displayResults() in myReporter


	}


}
