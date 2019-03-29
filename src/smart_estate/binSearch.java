package smart_estate;
/**
 * This module performs binary search on the list of StateInfo's
 * @author Connor Hewick
 *
 */
public class binSearch {

	enum fieldT {hpi, crime_rate, housing_price}
	private final static double TOL = 20000; 
	
	public static StateInfo binSearch(StateInfo[] arr, fieldT field, double key) {
		
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
		
		
		int lo = 0;
		int hi = arr.length - 1;
		

		while (lo <= hi) {
			int mid = (hi + lo) / 2;
			
			
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
				
			// search housing price
			} 
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
		
		
		
		
		
		switch (field) {
		case hpi:
			return (arr[lo].getHPI() - key) < (key - arr[hi].getHPI()) ? arr[lo] : arr[hi];
		case crime_rate:
			return (arr[lo].getCrimeRate() - key) < (key - arr[hi].getCrimeRate()) ? arr[lo] : arr[hi];
		case housing_price:
			return (arr[lo].getHousingPrice() - key) < (key - arr[hi].getHousingPrice()) ? arr[lo] : arr[hi];
		}
		
		
		// if key not found in any state
		StateInfo empty = new StateInfo("empty");
		return empty;
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// get state info
		StateInfo[] array = new StateInfo[50];
		array = PopulateStateInfo.populateStateInfo();
		
		//demo 
		
		Sort.sort(array, "invest");
		StateInfo result = binSearch(array, fieldT.housing_price, 120000);
		
		//result
		System.out.println(result.getState());
	}
}



