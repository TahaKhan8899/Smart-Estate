package smart_estate;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*; 
import java.lang.*;
public class hpi_data {
	
	public static Hashtable<String, Double> indexes = new Hashtable<String, Double>(); 
	public static void read_data(String hpi_file) throws IOException {
		
		try {
			
			BufferedReader reader = new BufferedReader (new FileReader(hpi_file));
			String line = reader.readLine();
			Double base_year = 0.0;
			Double curr_year = 0.0;
			Double difference;
			while (line != null) {
				
				String[] comma_seperated = line.split(",");
				
				
				if (comma_seperated.length == 6) {	

					
					
					if (comma_seperated[3].equals("2007") && comma_seperated[4].equals("4")) {
//						base_year =  );
						indexes.put(comma_seperated[2],Double.valueOf(comma_seperated[5]));
						
					} 
//					else if (comma_seperated[3].equals("2017") && comma_seperated[4].equals("4")){
//						curr_year = Double.valueOf(comma_seperated[5] );
//					}
//					difference = curr_year - base_year;
//					indexes.put(comma_seperated[2], difference);
//					difference = 0.0;
					
				}
				

						
				line = reader.readLine();
				
			}
			
			
			
			
			int count = 0;
			for (Map.Entry<String, Double> entry : indexes.entrySet()) {
				
				
			    String key = entry.getKey();
			    Double value = entry.getValue();
			    count += 1;
			    System.out.println ("Key: " + key + " Value: " + value);
			}
			System.out.println ("-----------");
			System.out.println (count);
			
			
			
		} catch(FileNotFoundException e) {
			System.out.println("did not find");
			System.out.println(e);
		}

		
	}

	public static void main(String[] args) throws IOException {
		read_data("data/hpi.csv");

	}

}
