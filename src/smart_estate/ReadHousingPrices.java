package smart_estate;

/**
 * This module reads data and parses data from the Median Housing Prices dataset

 * @author Taha Khan
 *
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadHousingPrices {

	static String fileName;

	/**
	 * This is the constructor for reading housing prices
	 * @param name - name of the file to get housing prices from
	 */
	public ReadHousingPrices(String name) {
		fileName = name;
	}

	/**
	 * It reads a csv file and parses it into an array of Pairs
	 * 
	 * @return array of Pairs - (State, Price)
	 */
	public static Pair[] readPrices(String name) {

		try {
			fileName = name;
			// open file
			Scanner sc = new Scanner(new File(fileName));
			List<String> lines = new ArrayList<String>();

			// add each line of the text file into an array
			while (sc.hasNextLine()) {
				lines.add(sc.nextLine());
			}

			// allLines is an array with each item being a row in the file
			String[] allLines = lines.toArray(new String[0]);

			Pair[] statesWithPrices = new Pair[allLines.length];

			// loop through all lines of the csv
			for (int i = 0; i < allLines.length; i++) {
				// take a single line from the list of lines
				String fullLine = allLines[i];

				// get the State form the line
				String state = parseLineForState(fullLine);

				// get the price from the line
				double price = parseLineforPrice(fullLine);

				// create and add pair to list of pairs
				Pair pair = new Pair(state, price);
				statesWithPrices[i] = pair;
			}

			return statesWithPrices;
		} catch (FileNotFoundException e) {
			Pair[] errorPair = new Pair[1];
			return errorPair;
		}
	}

	/**
	 * Parse line for the state
	 * 
	 * @param s
	 *            - a line from the housingPrices csv
	 * @return String for the state
	 */
	private static String parseLineForState(String s) {
		// break it up on the ',"' and '",'
		// this gives the form: "Alabama$132,100"
		// take the first thing from that splitting, this is the State
		String state = s.split("(,\")|(\",)")[0];
		return state;
	}

	/**
	 * Parse line for the price
	 * 
	 * @param s
	 *            - a line from the housingPrices csv
	 * @return Double for the price
	 */
	private static double parseLineforPrice(String s) {
		// break it up on the ',"' and '",'
		// this gives the form: "Alabama$132,100"
		// priceStr is of the form: '$132,100'
		String priceStr = s.split("(,\")|(\",)")[1];

		// get rid of the '$' and ',' from the price and make it into a double
		priceStr = priceStr.substring(1);
		priceStr = priceStr.split(",")[0] + priceStr.split(",")[1];
		double price = Double.parseDouble(priceStr);
		return price;
	}

}
