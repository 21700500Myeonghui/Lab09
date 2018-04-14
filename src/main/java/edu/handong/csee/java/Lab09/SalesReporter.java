package edu.handong.csee.java.Lab09;//Instructs the SalesReporter class to be complied and stored in edu.handong.csee.java.lab09

import java.util.Scanner;//importing a package, java.util.Scanner. A package is a kind of external objects created by other developer
import java.util.ArrayList; //importing a package, java.util.ArrayList. A package is a kind of external objects created by other developer

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
	private ArrayList<SalesAssociate> team= new ArrayList<SalesAssociate>();//Create object SalesAssociate type ArrayList team
	
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

		boolean getDT=true;//Create local variable getDT, put true in getDT
		
		while(getDT==true)//Repeat if value of getDT is true
		{
			Scanner keyboard= new Scanner(System.in);//Create an object of the Scanner class
			
			System.out.print("Enter name of sales associate: ");//Outputs the string literal "Enter name of sales associate: "
			String name= keyboard.nextLine();//Create String type local variable name, Take one string from the keyboard and place it in name

			System.out.print("Enter associate's sales: $");//Outputs the string literal "Enter associate's sales: $"
			double sales = keyboard.nextDouble();//Create double type local variable sales, Take one double from the keyboard and place it in sales
		
			SalesAssociate member=new SalesAssociate();//Instantiate of an object
			member.setName(name);//calling method setName(String name) in member, Send value of name as value of the parameter at this time
			member.setSales(sales);//calling method setSales(double sales) in member, Send value of sales as value of the parameter at this time
			
			team.add(member);//Adding an object member to the end of the array list team
			
			String blank=keyboard.nextLine();//Create String type local variable blank, Receive input the <Eneter>key
			System.out.println("More data for the team:");//Outputs the string literal " More data for the team:"
			String answer=keyboard.nextLine();//Create String type local variable answer, Take one String from the keyboard and place it in the answer
			
			if(answer.equalsIgnoreCase("yes"))//if value of answer is yes
				getDT=true;//put true in getDT
			else//if value of answer is not yes
				getDT=false;//put false in getDT
		}
		
	}

	/**
	 * This is method for computing highestSales
	 */
	public void computeHighestSales()
	{
		highestSales=team.get(0).getSales();//Get the value of the sales of the 0th object of the ArrayList team
		
		for(SalesAssociate member: team)//Repeat the length of the ArrayList team, each repetition, the member is set from the first object to the last object of the ArrayList team.
		{
			if(highestSales <member.getSales())//if value of highestSales is smaller than return value of method getSales() in member
				highestSales=member.getSales();//put return value of getSales() in member in highestSales
		}
	}

	/**
	 * This is a method for computing averageSales
	 */
	public void computeaverageSales()
	{
		double sum=0;//Create double type local variable sum, put 0 in sum

		for(SalesAssociate member: team)//Repeat the length of the ArrayList team, each repetition, the member is set from the first object to the last object of the ArrayList team.
		{
			sum+=member.getSales();//put sum of than return value of method getSales() in member and value of sum in variable sum
		}
		averageSales=sum/team.size();//put the division value of sum and the length of the ArrayList team in variable averageSales
		
	}

	/**
	 * This is a method for displaying Results
	 */
	public void displayResults()
	{
		System.out.println("Average sales per associate is $"+averageSales);//Outputs "Average sales per associate is $ ' the value of Instance variable averageSales'"
		System.out.println("The highest sales figure is $"+highestSales);//Outputs "The highest sales figure is $ ' the value of Instance variable highestSales'"

		System.out.println("The following had the highest sales:");//Outputs the string literal "The following had the highest sales:"
		for(SalesAssociate member:team)//Repeat the length of the ArrayList team, each repetition, the member is set from the first object to the last object of the ArrayList team.
		{
			if(highestSales == member.getSales())//if the value of highestSales and the return value of method getSales() in member are same
			{
				System.out.println("Name: " + member.getName());//Outputs "Name: ' the return value of method getName() in member'"
				System.out.println("Sales: $ "+highestSales);//Outputs "Sales: $ 'the value of Instance variable highestSales'"
				differenceAverage(member.getSales());//calling method differenceAverage(double iSales), Send the return value of method getSales() in member as value of the parameter at this time
			}
		}

		System.out.println("The rest performed as follows: ");// Output the string literal "The rest performed as follows: "
		for(SalesAssociate member2: team)//Repeat the length of the ArrayList team, each repetition, the member2 is set from the first object to the last object of the ArrayList team.
		{
			if(highestSales != member2.getSales())//if the value of highestSales and the return value of method getSales() in member2 are not the same
			{
				System.out.println("Name: "+member2.getName());//Outputs "Name: ' the return value of method getName() in member2'"
				System.out.println("Sales: "+member2.getSales());//Outputs "Sales: $ 'the return value of method getSales() in member2'"
				differenceAverage(member2.getSales());//calling method differenceAverage(double iSales), Send the return value of method getSales() in member2 as value of the parameter at this time
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
