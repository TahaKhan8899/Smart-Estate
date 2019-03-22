package smart_estate;
/**
 * This is an abstract data type to hold multiple values relating to a single state
 * @author Connor Hewick
 *
 */
public class StateInfo {
	
	private final String state;
	private double hpi;
	private double crime_rate;
	private double housing_price;
	
	/**
	 * @brief initialization of object
	 * @param state - String of the State
	 */
	public StateInfo(String state) {
		this.state = state;
	}
	
	/**
	 * @brief get name of state
	 * @return value string of state
	 */
	public String getState() {
		return this.state;
	}
	
	/**
	 * @brief get housing price index of state
	 * @return value double for hpi
	 */
	public double getHPI() {
		return this.hpi;
	}
	
	/**
	 * @brief setting of hpi value with assumption that this method is only called once per object
	 * @param hpi HPI of state
	 */
	public void setHPI(double hpi) {
		this.hpi = hpi;
	}
	
	/**
	 * @brief get crime rate of state
	 * @return value double for crime rate
	 */
	public double getCrimeRate() {
		return this.crime_rate;
	}
	
	/**
	 * @brief setting of crime rate value with assumption that this method is only called once per object
	 * @param crime_rate crime rate of state
	 */
	public void setCrimeRate(double crime_rate) {
		this.crime_rate = crime_rate;
	}
	
	/**
	 * @brief get median housing price of state
	 * @return value double for housing price
	 */
	public double getHousingPrice() {
		return this.housing_price;
	}
	
	/**
	 * @brief setting of housing price value with assumption that this method is only called once per object
	 * @param housing_price housing price of state
	 */
	public void setHousingPrice(double housing_price) {
		this.housing_price = housing_price;
	}
	
	/**
	 * @brief output object as string
	 * @return string form of state info
	 */
	public String toString() {
		return this.state+": " + " HPI: " + this.hpi + " Crime Rate: " + this.crime_rate + " Housing Price: " + this.housing_price;
	}
}
