package smart_estate;

/**
 * This is generic class for a pair that can hold two items
 * 
 * @author Taha Khan Citation:
 *         https://stackoverflow.com/questions/9568403/how-to-store-an-array-of-pairs-in-java
 */
public class Pair {

	private final String key;
	private final double val;

	/**
	 * This pair holds a State and a Value for that State
	 * 
	 * @param state
	 *            - String of the State
	 * @param value
	 *            - Double for price, crime, etc
	 */
	public Pair(String state, double value) {
		this.key = state;
		this.val = value;
	}

	/**
	 * Get the key
	 * 
	 * @return - item 1
	 */
	public String state() {
		return key;
	}

	/**
	 * Get value
	 * 
	 * @return - item 2
	 */
	public double value() {
		return val;
	}

	/**
	 * String representation of the pair
	 */
	public String toString() {
		return ("State: " + this.key + ", Value: " + this.val);
	}
}
