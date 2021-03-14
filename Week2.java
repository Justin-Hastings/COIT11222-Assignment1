//Programmer: Justin Hastings 12147349
//File: Week2.java
//Date: August 28 2020
//Purpose: COIT11222 assignment one question two T2-20
// Input of data types and arithmetic expressions - Program for council to
// calculate the quarterly water charges from their customers.

//Imports the Java Scanner class so the main method can access it.
import java.util.Scanner;

public class Week2
{
	public static void main(String [] args)
	{
		//Constants used becuase they can't be modified while running
		//Constant for the fixed sewage service rate
		final byte FIXED_SERVICE_FEE = 120;
		//Constant for the fixed water rate
		final double RATE = 0.8;
		//Constant for the offset spacing (move to the left) for the receipt
		final String receiptOffsetSpacing = "                          ";

		//String object declaration for the customer's name
		String customerName;
		//String object declaration for the customer's contant phone number
		String customerContactPhone;
		//Integer declaration for the customer's water usage
		int customerWaterUsage;
		//Double declaration for the customer's total charge
		double customerTotalCharge;

		//Scanner object for reading text inputs
		Scanner inText = new Scanner(System.in);
		//Scanner object for reading number inputs
		Scanner inNumber = new Scanner(System.in);

		//Outputs a prompt to the user for them to enter the name of the customer
		System.out.print("Enter the name of customer: ");
		//Reads the user's input and sets it as the customer's name
		customerName = inText.nextLine();

		//Outputs a prompt to the user for them to enter the contact phone of the customer
		System.out.print("Enter the contact phone: ");
		//Reads the user's input and sets it as the customer's contact number
		customerContactPhone = inText.nextLine();

		//Outputs a prompt to the user for them to enter the water usage of the customer
		System.out.print("Enter the water usage (KL) of " + customerName + ": " );
		//Reads the user's input and sets it as the customer's water usage
		customerWaterUsage = inNumber.nextInt();

		//Calculates the total customer charge by multiplying the customer's water usage (integer entered by the user)
		//by the rate (Constant) and adding the service fee (Constant)
		customerTotalCharge = FIXED_SERVICE_FEE + customerWaterUsage * RATE;

		//The receipt - indented to the right
		//Leaves 2 blank lines between the user input and the receipt
		System.out.print("\n\n");
		//Outputs the title for the receipt
		System.out.print(receiptOffsetSpacing + "    Customer Receipt\n");
		//Outputs the dashes for the second line of the receipt
		System.out.print(receiptOffsetSpacing + "-------------------------\n");//25 dashes
		//Outputs the customers name on the receipt
		System.out.print(receiptOffsetSpacing + "Customer name: " + customerName + "\n");
		//Outputs the customers contact phone on the receipt
		System.out.print(receiptOffsetSpacing + "Contact phone: " + customerContactPhone + "\n");
		//Outputs the customers water usage on the receipt
		System.out.print(receiptOffsetSpacing + "Water usage: " + customerWaterUsage + " KL\n");
		//Outputs the customers total charge on the receipt
		System.out.printf(receiptOffsetSpacing + "Total Charge: " + "$%.2f", customerTotalCharge);
		//Leaves 4 blank lines between the end of the receipt and the end of the program
		System.out.print("\n\n\n\n");

	}
}