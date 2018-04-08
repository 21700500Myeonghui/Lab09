package edu.handong.csee.java.Lab09;

import java.util.Scanner;

public class SalesReporter {
	private double highestSales;
	private double averageSales;
	private SalesAssociate[] team;
	private int numOfSalesman;

	public SalesReporter()
	{
		System.out.println("Enter number of Sales associates: ");

		Scanner keyboard =new Scanner(System.in);
		numOfSalesman=keyboard.nextInt();

	}

	public void getData()
	{
		team = new SalesAssociate[numOfSalesman];


		for(int i=0; i<team.length; i++)
		{
			Scanner keyboard =new Scanner(System.in);
			System.out.println("Enter data for associate number "+(i+1));

			System.out.print("Enter name of sales associate: ");
			String name= keyboard.nextLine();

			System.out.print("Enter associate's sales: $");
			double sales = keyboard.nextDouble();

			team[i]= new SalesAssociate();

			team[i].setName(name);
			team[i].setSales(sales);

		}

	}

	public void computeHighestSales()
	{
		highestSales= team[0].getSales();

		for(int i=1; i<team.length; i++)
		{
			if(highestSales<team[i].getSales())
			{
				highestSales=team[i].getSales();
			}
		}
	}

	public void computeaverageSales()
	{
		double sum=0;

		for(int i=0; i<team.length; i++)
		{
			sum+=team[i].getSales();
		}
		averageSales=sum/numOfSalesman;
	}

	public void displayResults()
	{
		System.out.println("Average sales per associate is $"+averageSales);
		System.out.println("The highest sales figure is $"+highestSales);

		System.out.println("The following had the highest sales:");
		for(int i=0; i<team.length; i++)
		{
			if(highestSales == team[i].getSales())
			{
				System.out.println("Name: " + team[i].getName());
				System.out.println("Sales: $ "+highestSales);
				differenceAverage(team[i].getSales());
			}
		}

		System.out.println("The rest performed as follows: ");
		for(int j=0; j<team.length ;j++)
		{
			if(highestSales != team[j].getSales())
			{
				System.out.println("Name: "+team[j].getName());
				System.out.println("Sales: "+team[j].getSales());
				differenceAverage(team[j].getSales());
			}
		}
	}

	public void differenceAverage(double iSales)
	{
		if(averageSales<iSales)
		{
			System.out.println("$"+(iSales-averageSales)+" above the average");
		}
		else if(averageSales>iSales)
		{
			System.out.println("$"+(averageSales-iSales)+" below the average");
		}
		else if(averageSales==iSales)
		{
			System.out.println("It's the same as the average.");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SalesReporter myReporter = new SalesReporter();

		myReporter.getData();
		myReporter.computeHighestSales();
		myReporter.computeaverageSales();
		myReporter.displayResults();


	}


}
