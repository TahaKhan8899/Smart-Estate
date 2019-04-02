package smart_estate;

import java.io.IOException;

/**
 * This modules reads in data from datasets into a list of state infos
 * @author Connor Hewick
 *
 */
public class PopulateStateInfo {
	static StateInfo[] states = new StateInfo[50];
	static String[] state_names = {"Alabama","Alaska","Arizona","Arkansas","Calidornia","Colorado","Connecticut","Delware","Florida","Gerogia","Hawii","Idaho","Illinois","Indiana","Iowa","Kansas","Kentucky","Louisiana","Maine","Maryland","Massachusetts","Michigan","Minnesota","Mississippi","Missouri","Montana","Nebraska","Nevada","New Hampshire","New Jersey","New Mexico","New York","North Carolina","North Dakota","Ohio","Oklahoma","Oregon","Pennsylvania","Rhode Island","South Carolina","South Dakota","Tennessee","Texas","Utah","Vermont","Virginia","Washington","West Virginia","Wisonsin","Wyoming"};
	
	
	private static void initStates() {
		for (int i = 0; i < 50; i++) {
			states[i] = new StateInfo(state_names[i]);
		}
	}
	
	private static void populateHPI() {
		Pair[] HPI;
		try {
			HPI = ReadHPI.read_data("data/hpi.csv");
			for (int i = 0; i < 50; i++) {
				states[i].setHPI(HPI[i].value());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void populateCrimeRate() {
		Pair[] CR = ReadCrimeRate.CRList();
		for (int i = 0; i < 50; i++) {
			states[i].setCrimeRate(CR[i].value());
		}
	}

	private static void populateHousingPrice() {
		Pair[] HP = ReadHousingPrices.readPrices("data/housingPrices.csv");
		for (int i = 0; i < 50; i++) {
			states[i].setHousingPrice(HP[i].value());
		}
	}
	
	public static StateInfo[] populateStateInfo() {
		initStates();
		populateHPI();
		populateCrimeRate();
		populateHousingPrice();
		return states;
	}
	
	public static void main(String[] args) {
		// demo of how to use
		StateInfo[] array = new StateInfo[50];
		array = populateStateInfo();
		for (int i = 0; i < 50; i++)
			System.out.print(array[i].toString()+"\n");
		// array is now an array of all state info objects
	}

}
