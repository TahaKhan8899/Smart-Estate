/**
 * 
 */
package smart_estate;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * @author aissaelwazani
 *
 */
public class SortTest {

	private StateInfo[] states;

	/**
	 * Tests to check that a list of states is sorted in ascending order by some
	 * fieldT
	 * 
	 * @param states
	 *            - An array of StateInfo (a list of states)
	 * @param field
	 *            - A fieldT (either hpi, crime rate, housing price)
	 * @return - True if the array is sorted, false otherwise
	 */
	public static boolean isSorted(StateInfo[] states, fieldT field) {
		int n = states.length;
		System.out.println(field);
		for (int i = 0; i < n - 1; i++) {
			if (!less(states[i], states[i + 1], field)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * @brief Helper functions that compares to StateInfo objects' properties based
	 *        on the intent parameter
	 * @param v,
	 *            a StateInfo object to be compared
	 * @param w,
	 *            A StateInfo object to be compared
	 * @param intent,
	 *            what to compare between the states (hpi, crime rate, housing
	 *            price)
	 */
	private static boolean less(StateInfo v, StateInfo w, fieldT intent) {
		if (intent == fieldT.housing_price) {
			return v.getHousingPrice() <= w.getHousingPrice();
		} else if (intent == fieldT.crime_rate) {
			return v.getCrimeRate() <= w.getCrimeRate();
		} else if (intent == fieldT.hpi) {
			return v.getHPI() <= w.getHPI();
		}
		System.out.println("Intent field filled out incorrectly");
		return false;
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		states = PopulateStateInfo.populateStateInfo();
	}

	/**
	 * tests to check that sorting by hpi is functional
	 */
	@Test
	public void test_sort_hpi() {
		Sort.sort(states, fieldT.hpi);
		assertTrue(isSorted(states, fieldT.hpi));
	}

	/**
	 * tests to check that sorting by crime rate is functional
	 */
	@Test
	public void test_sort_crime() {
		Sort.sort(states, fieldT.crime_rate);
		int n = states.length;
		assertTrue(isSorted(states, fieldT.crime_rate));
	}

	/**
	 * tests to check that sorting by housing price is functional
	 */
	@Test
	public void test_sort_housing_price() {
		Sort.sort(states, fieldT.housing_price);
		int n = states.length;
		assertTrue(isSorted(states, fieldT.housing_price));
	}
}
