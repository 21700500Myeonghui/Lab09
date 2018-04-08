package edu.handong.csee.java.Lab09;//Instructs the SalesReporter class to be complied and stored in edu.handong.csee.java.lab09

import java.util.Scanner;//importing a package, java.util.Scanner. A package is a kind of external objects created by other developer

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
	private SalesAssociate[] team;//Declare the reference variable team for SalesAssociate arrays
	private int numOfSalesman;//Create integer type Instance variable numOfSalesman

	/**
	 * This is constructor for initializing object
	 * constructor without parameter
	 */
	public SalesReporter()
	{
		System.out.println("Enter number of Sales associates: ");//Outputs the string literal "Enter number of Sales associates: "

		Scanner keyboard =new Scanner(System.in);//Create an object of the Scanner class
		numOfSalesman=keyboard.nextInt();//Take one integer from the keyboard and place it the numOfSalesman

	}

	/**
	 * This is a method for getting data
	 */
	public void getData()
	{
		team = new SalesAssociate[numOfSalesman];//Create reference array, The size of the array is the value of the instance variable numOfSalesman


		for(int i=0; i<team.length; i++)//Create integer type local variable i, Put 0 in variable i, increase i by 1, Repeat until i is smaller than the size of the array team.
		{
			Scanner keyboard =new Scanner(System.in);//Create an object of the Scanner class
			System.out.println("Enter data for associate number "+(i+1));//Outputs "Enter data for associate number 'Value of variable i plus 1'"

			System.out.print("Enter name of sales associate: ");//Outputs the string literal "Enter name of sales associate: "
			String name= keyboard.nextLine();//Create String type local variable name, Take one string from the keyboard and place it in name

			System.out.print("Enter associate's sales: $");//Outputs the string literal "Enter associate's sales: $"
			double sales = keyboard.nextDouble();//Create double type local variable sales, Take one double from the keyboard and place it in sales

			team[i]= new SalesAssociate();//Create each element object in the array

			team[i].setName(name);//calling method setName(String name) in the i-th of array team
			team[i].setSales(sales);//calling method setSales(double sales) in the i-th of array team

		}

	}

	/**
	 * This is method for computing highestSales
	 */
	public void computeHighestSales()
	{
		highestSales= team[0].getSales();//put the return value of method getSales() in 0-th of array team in highestSales

		for(int i=1; i<team.length; i++)//Create integer type local variable i, Put 1 in variable i, increase i by 1, Repeat until i is smaller than the size of the array team.
		{
			if(highestSales<team[i].getSales())//if the value of the highestSales is less than the return value of method getSales() in i-th of array team 
			{
				highestSales=team[i].getSales();//put the return value of method getSales() in i-th of array team in highestSales
			}
		}
	}

	/**
	 * This is a method for computing averageSales
	 */
	public void computeaverageSales()
	{
		double sum=0;//Create double type local variable sum, put 0 in sum

		for(int i=0; i<team.length; i++)//Create integer type local variable i, Put 0 in variable i, increase i by 1, Repeat until i is smaller than the size of the array team.
		{
			sum+=team[i].getSales();//put the value of sum plus the return value of method getSales() in i-th of array team in sum
		}
		averageSales=sum/numOfSalesman;//Put the value of the sum divided by numOfSalesman in averageSales
	}

	/**
	 * This is a method for displaying Results
	 */
	public void displayResults()
	{
		System.out.println("Average sales per associate is $"+averageSales);//Outputs "Average sales per associate is $ ' the value of Instance variable averageSales'"
		System.out.println("The highest sales figure is $"+highestSales);//Outputs "The highest sales figure is $ ' the value of Instance variable highestSales'"

		System.out.println("The following had the highest sales:");//Outputs the string literal "The following had the highest sales:"
		for(int i=0; i<team.length; i++)//Create integer type local variable i, Put 0 in variable i, increase i by 1, Repeat until i is smaller than the size of the array team.
		{
			if(highestSales == team[i].getSales())//if the value of highestSales and the return value of method getSales() in i-th of array team are the same
			{
				System.out.println("Name: " + team[i].getName());//Outputs "Name: ' the return value of method getName() in i-th of array team'"
				System.out.println("Sales: $ "+highestSales);//Outputs "Sales: $ 'the value of Instance variable highestSales'"
				differenceAverage(team[i].getSales());//calling method differenceAverage(double iSales), Send the return value of method getSales() in i-th of array team as value of the parameter at this time
			}
		}

		System.out.println("The rest performed as follows: ");// Output the string literal "The rest performed as follows: "
		for(int j=0; j<team.length ;j++)//Create integer type local variable j, Put 0 in variable j, increase j by 1, Repeat until j is smaller than the size of the array team.
		{
			if(highestSales != team[j].getSales())//if the value of highestSales and the return value of method getSales() in j-th of array team are not the same
			{
				System.out.println("Name: "+team[j].getName());//Outputs "Name: ' the return value of method getName() in j-th of array team'"
				System.out.println("Sales: "+team[j].getSales());//Outputs "Sales: $ 'the return value of method getSales() in j-th of array team'"
				differenceAverage(team[j].getSales());//calling method differenceAverage(double iSales), Send the return value of method getSales() in j-th of array team as value of the parameter at this time
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
