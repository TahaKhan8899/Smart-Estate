/**
 * This module sorts an array of StateInfo objects by HPI, crime rate, or housing prices depending on the client's intent
 * @author Noa Barsky
 * Citation: Algorithms Fourth Edition by Robert Sedgwick and Kevin Wayne
 */

package smart_estate;

import java.io.IOException;
import edu.princeton.cs.algs4.StdRandom;

public class Sort {
	
	/**
	 * @brief Function called by client to sort the array
	 * @param a - An array of StateInfo objects
	 * @param intent - A string that signals the client's intent (buy, sell, or invest)
	 */
	public static void sort(StateInfo[] a, String intent) {
		StdRandom.shuffle(a); // Eliminate dependence on input.
		sort(a, 0, a.length - 1, intent);
	}
    
	
	/**
	 * @brief Recursively sorts the array
	 * @param a, an array of StateInfo objects
	 * @param lo, first index
	 * @param hi, last index
	 * @param intent, a string that signals the client's intent (buy, sell, or invest)
	 */
	private static void sort(StateInfo[] a, int lo, int hi, String intent) {
		if (hi <= lo)
			return;
		int j = partition(a, lo, hi, intent); 
		sort(a, lo, j - 1, intent); 
		sort(a, j + 1, hi, intent);
	}

	
	/**
	 * @brief Partitions the list based on a pivot value
	 * @param a, an array of StateInfo objects
	 * @param lo, first index
	 * @param hi, last index
	 * @param intent, a string that signals the client's intent (buy, sell, or invest)
	 */
	private static int partition(StateInfo[] a, int lo, int hi, String intent) {
		int i = lo, j = hi + 1; // left and right scan indices
		StateInfo v = a[lo]; // partitioning item
		while (true) { // Scan right, scan left, check for scan complete, and exchange.
			while (less(a[++i], v, intent)) {
				if (i == hi) {
					break;
				}
			};
			while (less(v, a[--j], intent)) {
				if (j == lo) {
					break;
				}
			};
			if (i >= j) {
				break;
			}
			exch(a, i, j);
		}
		exch(a, lo, j); // Put v = a[j] into position
		return j;
	}
	
	
	/**
	 * @brief Helper functions that compares to StateInfo objects' properties based on the intent parameter
	 * @param v, a StateInfo object to be compared
	 * @param w, A StateInfo object to be compared
	 * @param intent, a string that signals the client's intent (buy, sell, or invest)
	 */
	private static boolean less(StateInfo v, StateInfo w, String intent) {
		if (intent.toLowerCase().equals("invest")) {
			return v.getHousingPrice() < w.getHousingPrice();	
		} else if (intent.toLowerCase().equals("sell")) {
			return v.getCrimeRate() < w.getCrimeRate();
		} else if (intent.toLowerCase().equals("buy")) {
			return v.getHPI() < w.getHPI();
		} 
		System.out.println("Intent field filled out incorrectly");
		return false;

		
	}
    
	
	/**
	 * @brief A helper function that swaps two objects in an array
	 * @param a, an array of StateInfo objects
	 * @param i, an index value 
	 * @param j, an index value 
	 */
	private static void exch(StateInfo[] a, int i, int j) {
		StateInfo t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	

//The following is a temporary main function used to quick testing
/*	public static void main(String[] args) throws IOException {
		StateInfo fst = new StateInfo("Alaska");
		StateInfo snd = new StateInfo("Denver");
		StateInfo thrd = new StateInfo("New York");
		fst.setHousingPrice(6.0);
		fst.setHPI(1.0);
		snd.setHousingPrice(5.0);
		snd.setHPI(2.0);
		thrd.setHousingPrice(4.0);
		thrd.setHPI(3.0);
		StateInfo[] sample_lst = {fst, snd, thrd};
		sort(sample_lst, "buy");
		for (int i = 0; i < sample_lst.length; i++) {
			System.out.println(sample_lst[i]);
			
		}

} */	
	

}
