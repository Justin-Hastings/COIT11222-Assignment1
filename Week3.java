//Programmer: Justin Hastings 12147349
//File: Week3.java
//Date: August 28 2020
//Purpose: COIT11222 assignment one question three T2-20
// Decision statements - Program for council to calculate the
// quarterly water charges from their customers with tiered rates
// depending on the water usage

//Imports the Java Scanner class so the main method can access it.
import java.util.Scanner;

public class Week3
{
	public static void main (String[] args)
	{
		//Constants used becuase they can't be modified while running
		//Constant for the fixed sewage service rate
		final byte FIXED_SERVICE_FEE = 120;
		//Constant for the offset spacing (move to the left) for the receipt
		final String receiptOffsetSpacing = "                          ";

		//Constant for the fixed low water use rate
		final double LOW_RATE = 0.8;
		//Constant for the fixed middle water use rate
		final double MID_RATE = 0.9;
		//Constant for the fixed high water use rate
		final double HIGH_RATE = 1.1;

		//Constant to determine low to middle water use
		final int MIDDLE_USAGE = 50;
		//Constant to determine middle to high water use
		final int HIGH_USAGE= 90;

		//String object declaration for the customer's name
		String customerName;
		//String object declaration for the customer's contant phone number
		String customerContactPhone;
		//Integer declaration for the customer's water usage
		int customerWaterUsage;
		//Double declaration for the customer's water usage charge
		double customerUsageCharge = 0;
		//Double declaration for the customer's total charge (usage charge + service fee)
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

		//Checks water usage, determine rates based on water usage
		//Checks if the water usage is equal to or below 50KL
		if (customerWaterUsage <= MIDDLE_USAGE)
		{
			//Use LOW_RATE
			//Sets the usage charge to the water usage * the low rate(0.8)
			customerUsageCharge = customerWaterUsage * LOW_RATE;
		}
		//Checks if the water usage is above 50KL but equal to or below 50KL
		else if (customerWaterUsage <= HIGH_USAGE)
		{
			//Use MID_RATE + LOW_RATE for first 50KL
			//First 50KL is at low rate, rest is at middle rate
			//Sets the usage charge to the middle usage(50) * low rate(0.8) + the middle rate(0.9) * (water usage - middle usage(50))
			customerUsageCharge = (MIDDLE_USAGE * LOW_RATE) + (MID_RATE * (customerWaterUsage - MIDDLE_USAGE));
		}
		//to use if the water usage is above 90KL
		else
		{
			//Use HIGH_RATE for excess + MID_RATE for 40KL + LOW_RATE for 50KL
			//First 50KL is at low rate, next 40KL is at the middle rate, rest is at high rate
			//Sets the usage charge to the middle usage(50) * low rate(0.8) + the middle rate(0.9) * (high usage(90) - middle usage(50)) + the high rate(1.1) * (water usage - high usage(90))
			customerUsageCharge = (MIDDLE_USAGE * LOW_RATE) + ((HIGH_USAGE - MIDDLE_USAGE) * MID_RATE) + (HIGH_RATE * (customerWaterUsage - HIGH_USAGE));
		}

		//Calculates the total customer charge by adding the fixed service fee to the customer's usage charge, calculated above^^
		customerTotalCharge = FIXED_SERVICE_FEE + customerUsageCharge;

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