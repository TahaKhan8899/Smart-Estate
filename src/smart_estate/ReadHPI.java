/**
 * This module reads from HPI dataset
 * @author Noa Barsky
 *
 */

package smart_estate;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*; 




public class ReadHPI{
	
	/**
	 * @brief Reads the data into an array of Pairs called Indexes
	 * @param hpi_file a general parameter
	 */
	
	public static Pair[] read_data(String hpi_file) throws IOException {
		Pair[] indexes = new Pair[50]; // An array of Pairs that contains the state and it's HPI
		try { //if the file the found
			ArrayList<Double> base_years = new ArrayList<Double>(); //Array of base years to compare with
			ArrayList<Double> curr_years = new ArrayList<Double>(); //Array of current years
			
			BufferedReader reader = new BufferedReader (new FileReader(hpi_file)); //Reader to read the CSV
			String line = reader.readLine(); //The initial line of the CSV
			Double difference; //A variable representing the difference between the base year and current year
			
			int i = 0;
			while (line != null) { //Loop to iterate over file
				
				String[] comma_seperated = line.split(","); // separating each line by by its fields
				
				if (comma_seperated.length == 6) { //insurances it's a valid line
					
					if (comma_seperated[3].equals("2007") 
					    && comma_seperated[4].equals("4") 
					    && !comma_seperated[2].equals("District of Columbia")) {
						base_years.add(Double.valueOf(comma_seperated[5]));
					} else if (comma_seperated[3].equals("2017") 
							   && comma_seperated[4].equals("4") 
							   && !comma_seperated[2].equals("District of Columbia")) {
						           curr_years.add(Double.valueOf(comma_seperated[5]));
						           difference = curr_years.get(i) - base_years.get(i);
						           indexes[i] = new Pair(comma_seperated[2], difference);
						           i++;
				      }	
				}		
				line = reader.readLine();
			}
				
		} catch(FileNotFoundException e) {
			System.out.println(e);
		}

		return indexes;
	}

}
