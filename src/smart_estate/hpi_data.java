package smart_estate;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class hpi_data {
	
	public static void read_data(String hpi_file) throws IOException {
		
		try {
			String line = "";
			BufferedReader reader = new BufferedReader (new FileReader(hpi_file));
			
			
//			while ((line = reader.readLine()) != null) {
//				System.out.println(line);
//				
//			}
			
		} catch(FileNotFoundException e) {
			System.out.println("did not find");
			System.out.println(e);
		}

		
	}

	public static void main(String[] args) throws IOException {
		read_data("data/hpi.csv");
//		try {
//			read_data();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			System.out.println("Did not work");
//		}

	}

}
