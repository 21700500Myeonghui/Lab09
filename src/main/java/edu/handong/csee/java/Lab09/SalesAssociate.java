package edu.handong.csee.java.Lab09;//Instructs the SalesAssociate class to be complied and stored in edu.handong.csee.java.lab09

/**
 * This class defines a SalesAssociate object
 * The SalesAssociate class has name, sales members
 * The SalesAssociate class has getName(), setName(), getSales(), setSales() methods
 * @author Lee MyeongHui
 * @version java version "9.0.4"
 *
 */
public class SalesAssociate {
	private String name;//Create String type Instance variable name
	private double sales;//Create double type Instance variable sales

	/**
	 * This is a method for getting Name
	 * @return Returns member variable name of the object to which the currently executing method belongs, it is String type
	 */
	public String getName() {
		return name;//Returns member variable name of the object to which the currently executing method belongs
	}
	
	/**
	 * This is a method for setting Name
	 * @param name, it is String type
	 */
	public void setName(String name) {
		this.name = name;//put the parameter name into the member variable name, 'this' is a reference to the object itself
	}
	
	/**
	 * This is a method for getting Sales
	 * @return Returns member variable sales of the object to which the currently executing method belongs, it is double type
	 */
	public double getSales() {
		return sales;//Returns member variable sales of the object to which the currently executing method belongs
	}
	
	/**
	 * This is a method for setting Sales
	 * @param sales, it is double type
	 */
	public void setSales(double sales) {
		this.sales = sales;//put the parameter sales into the member variable sales, 'this' is a reference to the object itself
	}

}
