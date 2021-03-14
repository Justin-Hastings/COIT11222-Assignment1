//Programmer: Justin Hastings 12147349
//File: Week5.java
//Date: August 28 2020
//Purpose: COIT11222 assignment one question five T2-20
//Methods and GUI I/O - Read in the customer name, contact phone
//and the water usage and calculate the  charge for each customer, N times,
//where N is the highest digit in my student ID (Which is 9). It also has to
//report the maximum value of the charge and the corresponding customer name

import javax.swing.JOptionPane;

public class Week5
{
	public static void main(String[] args)
	{
		//Constants used becuase they can't be modified while running
		//Constant for the highest integer in my student ID
		final int N = 9;

		//String object declaration for the customer's name
		String customerName;
		//String object declaration for the customer's contant phone number
		String customerContactPhone;
		//String declaration for the customer's water usage returned from user (JOptionPane returns values as a string)
		String customerWaterUsageReturn;
		//Int declaration for the customer's water usage
		int customerWaterUsage = 0;
		//Double declaration for the customer's total charge (usage charge + service fee)
		double customerTotalCharge;
		//Double declaration for the maximum charge
		double maxCharge = 0;
		//String declaration
		String maxChargeCustomer = "";

		//Outputs a GUI message box displaying the welcome message
		JOptionPane.showMessageDialog(null, "Welcome to Urban Utilities Water Charge Application Program");

		//For loop to enter the customer details and output the receipt for each customer N times (N is highest digit in student ID (9))
		// for loop: Sets lcv (Loop Control Variable) to 0, checks if the loop control variable is less than N (9) and adds 1 to the value of lcv
		for (int lcv = 0; lcv < N; lcv++)
		{
			//Outputs a GUI input box, prompting the user to enter their name
			customerName = JOptionPane.showInputDialog(null, "Please enter the customer's name");
			//Outputs a GUI input box, prompting the user to enter their phone number
			customerContactPhone = JOptionPane.showInputDialog(null, "Please enter the contact phone");
			//Outputs a GUI input box, prompting the user to enter their water usage
			customerWaterUsageReturn = JOptionPane.showInputDialog(null, "Please enter the water usage(KL) of " + customerName);
			//Converts the water usage entered by the user from a string to an integer so that it can be used in calculations
			//(Because inputs from JOptionPan.showInputDialog() are returned as strings)
			customerWaterUsage = Integer.parseInt(customerWaterUsageReturn);
			//Calls the calculateCharge method, passing in the customer's water usage as the argument
			//Also sets the customer's total charge to the value returned by the calculateCharge method
			customerTotalCharge = calculateCharge(customerWaterUsage);

			//Checks if the current customer's total charge is greater than the current maximum charge
			if (customerTotalCharge > maxCharge)
			{
				//If YES
				//Sets the maximum charge to the current customer's total charge
				maxCharge = customerTotalCharge;
				//Sets the customer with the maximum charge to the current customer's name
				maxChargeCustomer = customerName;
			}

			//Outputs a receipt receipt after each customer has entered their details, including a title,
			// the customer's name, their phone number, their water usage and their total charge
			//Using String.format to format the string
			JOptionPane.showMessageDialog(null, String.format("%s\n%s\n%s\n%s%d%s\n%s$%.2f",
				"----- Customer Receipt -----",
				"Customer name: " + customerName,
				"Contact phone: " + customerContactPhone,
				"The water usage: ", customerWaterUsage, " KL",
				"Total charge: ", customerTotalCharge
				) );

		}

		//Outputs a GUI message box displaying the customer with the maximum charge and the corresponding cost
		JOptionPane.showMessageDialog(null, String.format("%s$%.2f%s",
			"The maximum total charge: ", maxCharge, " for " + maxChargeCustomer
			));
	}

	//The method to calculate the charges for each customer
	public static double calculateCharge (int customerWaterUsage)
	{

		//Constants used becuase they can't be modified while running
		//Constant for the fixed sewage service rate
		final byte FIXED_SERVICE_FEE = 120;

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

		//Double declaration for the customer's water usage charge
		double customerUsageCharge = 0;

		//Double declaration for the customer's total charge (usage charge + service fee)
		double customerTotalCharge = 0;

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
		//Calculates the customer's total charge by adding their usage charge to the fixed service fee of $120
		customerTotalCharge = customerUsageCharge + FIXED_SERVICE_FEE;
		//Returns the customer's total charge so that it's value can be used in the main method after it has been called
		return customerTotalCharge;

	}
}