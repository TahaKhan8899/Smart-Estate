package smart_estate;

/**
 * @brief enum to represent 3 fields to search
 */
enum fieldT {hpi, crime_rate, housing_price}

/**
 * This module performs binary search on the list of StateInfo's
 * @author Connor Hewick
 *
 */

public class binSearch {

	
	
	/**
	 * @brief binary search that will return closest min value if key is not found
	 * @param arr array of StateInfo's to search through
	 * @param field enum of fieldT to specify what field of StateInfo to search for
	 * @param key value to find
	 * @return StateInfo object containing (closest) value
	 */
	public static StateInfo binSearch(StateInfo[] arr, fieldT field, double key) {
		
		// if outside bounds return closest
		switch (field) {
		case hpi:
			if (key < arr[0].getHPI()) {
				return arr[0];
			}
			if (key > arr[arr.length-1].getHPI()) {
				return arr[0];
			}
			break;
		case crime_rate:
			if (key < arr[0].getCrimeRate()) {
				return arr[0];
			}
			if (key > arr[arr.length-1].getCrimeRate()) {
				return arr[0];
			}
			break;
		case housing_price:
			if (key < arr[0].getHousingPrice()) {
				return arr[0];
			}
			if (key > arr[arr.length-1].getHousingPrice()) {
				return arr[0];
			}
			break;
		}
		
		// set min and max index values
		int lo = 0;
		int hi = arr.length - 1;
		
		while (lo <= hi) {
			int mid = (hi + lo) / 2; // set new mid point
			
			// search hpi
			if (field == fieldT.hpi) {
				if (key < arr[mid].getHPI()) {
					hi = mid - 1;
				} else if (key > arr[mid].getHPI()) {
					lo = mid + 1;
				} else {
					return arr[mid];
				}
				
			// search crime rate
			} else if (field == fieldT.crime_rate) {
				if (key < arr[mid].getCrimeRate()) {
					hi = mid - 1;
				} else if (key > arr[mid].getCrimeRate()) {
					lo = mid + 1;
				} else {
					return arr[mid];
				}
			} 
			
			// search housing price
			else if (field == fieldT.housing_price) {
				if (key < arr[mid].getHousingPrice()) {
					hi = mid - 1;
				} else if (key > arr[mid].getHousingPrice()) {
					lo = mid + 1;
				} else {
					return arr[mid];
				}
			}
		}
		
		// if not found then return closest min value
		switch (field) {
		case hpi:
			return (arr[lo].getHPI() - key) < (key - arr[hi].getHPI()) ? arr[lo] : arr[hi];
		case crime_rate:
			return (arr[lo].getCrimeRate() - key) < (key - arr[hi].getCrimeRate()) ? arr[lo] : arr[hi];
		case housing_price:
			return (arr[lo].getHousingPrice() - key) < (key - arr[hi].getHousingPrice()) ? arr[lo] : arr[hi];
		}
		
		// empty return if all fails, code will never run due to switch case above
		StateInfo empty = new StateInfo("empty");
		return empty;
	}
	
	/*
	public static void main(String[] args) {
		// demo of use
		
		// get state info
		StateInfo[] array = new StateInfo[50];
		array = PopulateStateInfo.populateStateInfo();
		
		//demo 
		Sort.sort(array, "invest");
		StateInfo result = binSearch(array, fieldT.housing_price, 120000);
		
		//result
		System.out.println(result.getState());
	}
	*/
}



