/**
 * 
 */
package smart_estate;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Akram Elwazani
 *
 */
public class binSearchTest {

	private StateInfo[] states;
	
	/**
	 * Checks if two states are equivalent
	 * @param a - State number one to compare
	 * @param b - State number two to compare
	 * @return - True if the two states are the same, false otherwise
	 */
	public boolean isEqual(StateInfo a, StateInfo b) {
		double aHPI = a.getHPI();
		double bHPI = b.getHPI();
		double cHPI = aHPI - bHPI;
		
		double aCrime = a.getCrimeRate();
		double bCrime = b.getCrimeRate();
		double cCrime = aCrime - bCrime;
		
		if (a.getState().equals(b.getState())) {
			if (Math.abs(cHPI) <= 0.000001) {
				if (Math.abs(cCrime) <= 0.000001) {
					return true;
				}
			}
		}
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
	 * Tests binSearch for searching by state names
	 */
	@Test
	public void testBinSearchState() {
		StateInfo a = binSearch.binSearch(states, "New York");
		assertTrue(isEqual(states[31], a));
		a = binSearch.binSearch(states, "Maine");
		assertTrue(isEqual(states[18], a));
	}

	/**
	 * Tests binSearch for hpi search
	 */
	@Test
	public void testBinSearchHPI() {
		StateInfo cmp1 = states[31];
		StateInfo cmp2 = states[18];
		StateInfo a = binSearch.binSearch(states, fieldT.hpi, -11.99);
		assertTrue(isEqual(cmp1, a));
		a = binSearch.binSearch(states, fieldT.hpi, 83.20);
		assertTrue(isEqual(cmp2, a));
	}
	
	/**
	 * Tests binSearch for crime rate search
	 */
	@Test
	public void testBinSearchCrimerate() {
		StateInfo cmp1 = states[31];
		StateInfo cmp2 = states[18];
		StateInfo a = binSearch.binSearch(states, fieldT.crime_rate, 717);
		assertTrue(isEqual(cmp1, a));
		a = binSearch.binSearch(states, fieldT.crime_rate, 121);
		assertTrue(isEqual(cmp2, a));
	}
	
	/**
	 * Tests binSearch for housing price search
	 */
	@Test
	public void testBinSearchHousingPrice() {
		StateInfo cmp1 = states[31];
		StateInfo cmp2 = states[18];
		StateInfo a = binSearch.binSearch(states, fieldT.housing_price, 293000);
		assertTrue(isEqual(cmp1, a));
		a = binSearch.binSearch(states, fieldT.housing_price, 179900);
		assertTrue(isEqual(cmp2, a));
	}
}
