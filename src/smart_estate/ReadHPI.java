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
	 * This is the constructor for reading HPI
	 * @param hpi_file - hpi_fileof the file where HPI for different states is
	 */
	
	public static Pair[] read_data(String hpi_file) throws IOException {
		Pair[] indexes = new Pair[50];
		try {
			ArrayList<Double> base_years = new ArrayList<Double>();
			ArrayList<Double> curr_years = new ArrayList<Double>();
			
			BufferedReader reader = new BufferedReader (new FileReader(hpi_file));
			String line = reader.readLine();
			Double difference;
			
			int i = 0;
			while (line != null) {
				String[] comma_seperated = line.split(",");
				
				
				if (comma_seperated.length == 6) {	

					
					
					if (comma_seperated[3].equals("2007") && comma_seperated[4].equals("4") && !comma_seperated[2].equals("District of Columbia")) {
						base_years.add(Double.valueOf(comma_seperated[5]));
						
					} 
					else if (comma_seperated[3].equals("2017") && comma_seperated[4].equals("4") && !comma_seperated[2].equals("District of Columbia")){
						curr_years.add(Double.valueOf(comma_seperated[5]));
						difference = curr_years.get(i) - base_years.get(i);
						indexes[i] = new Pair(comma_seperated[2], difference);
						i++;
					}

					
				}		
				line = reader.readLine();
				
			}
			
			
			
			int count = 0;
			
			for (int j = 0; j < indexes.length; j++ ) {
				System.out.println(indexes[j].toString());
				count++;
				
			}


			System.out.println ("-----------");
			System.out.println (count);
			
			
		} catch(FileNotFoundException e) {
			System.out.println("did not find");
			System.out.println(e);
		}

		return indexes;
	}

	public static void main(String[] args) throws IOException {
		read_data("data/hpi.csv");
		Pair[] array = new Pair[50];
		array = read_data("data/hpi.csv");
		for (int i = 0; i < 50; i++)
			System.out.print(array[i].toString()+"\n");
	}

}
