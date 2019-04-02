package smart_estate;

import java.util.Scanner;

/**
 * This is the main class that integrates all other modules
 * @author tahakhan
 *
 */
public class Integration {

	public static void main(String[] args) {
		
		//get user input for price and intent
		Scanner input = new Scanner(System.in);
		System.out.print("Enter an integer for annual income: ");
    	int income = input.nextInt();
    	System.out.print("Enter intent (buy, sell, invest): ");
    	String intent = input.next();
		
		//parse and read data sets using PopulateStateInfo.java
		StateInfo[] array = new StateInfo[50];
		array = PopulateStateInfo.populateStateInfo();
//		printArray(array);		
		
		//sort by value specified by intent
		Sort.sort(array, intent);
//		printArray(array);
		
		/*
		 * Perform binary search to find the right state based on user income
		 * NOTE: for now, user income must be a specific income that is part of the
		 * median housing price data set.
		 * TODO: Implement a tolerance for the search so the user can enter whatever
		 * value they want
		 */
		StateInfo result = binSearch.binSearch(array, fieldT.housing_price, 286100);

		System.out.println("Search result: " + result.getState());

	}
	
	private static void printArray(StateInfo[] array)
	{
		for (int i = 0; i < array.length; i++)
		System.out.print(array[i].toString()+"\n");
	}

}
