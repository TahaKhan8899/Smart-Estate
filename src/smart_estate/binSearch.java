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
		
		int first = 0;
		int last = arr.length - 1;
		int mid = (first + last) / 2;
		//test
		while (first <= last) {
			
			// search hpi
			if (field == fieldT.hpi) {
				System.out.println(mid);
				if (arr[mid].getHPI() < key) {
					first = mid++;
				} else if (arr[mid].getHPI() == key) {
					return arr[mid];
				} else {
					last = mid - 1;
				}
				mid = (first + last) / 2;
				
			// search crime rate
			} else if (field == fieldT.crime_rate) {
				if (arr[mid].getCrimeRate() < key) {
					first = mid++;
				} else if (arr[mid].getCrimeRate() == key) {
					return arr[mid];
				} else {
					last = mid - 1;
				}
				mid = (first + last) / 2;
				
			// search housing price
			} 
			else if (field == fieldT.housing_price) {
				if (arr[mid].getHousingPrice() < key) {
					first = mid++;
				} 
				else if (arr[mid].getHousingPrice() == key) {
					return arr[mid];
				} 
//				//this is the test for tolerance
//				else if (arr[mid].getHousingPrice() > key-TOL && arr[mid].getHousingPrice() < key+TOL) {
//					return arr[mid];
//				} 
				else {
					last = mid - 1;
				}
				mid = (first + last) / 2;
			}
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
		System.out.println(array[5].getHousingPrice());
		Sort.sort(array, "invest");
		StateInfo result = binSearch(array, fieldT.housing_price, 286100);
		
		//result
		System.out.println(result.getState());
	}
}
