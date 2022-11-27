package Sensors;

public interface ISensorInfo {

	string toString();

	string getName();

	/**
	 * 
	 * @param name
	 */
	void setName(string name);

	SType getType();

	/**
	 * 
	 * @param type
	 */
	void setType(string type);

	string getLocation();

	/**
	 * 
	 * @param location
	 */
	void setLocation(string location);

	string getArea();

	/**
	 * 
	 * @param area
	 */
	void setArea(string area);

	string getCharacteristics();

	/**
	 * 
	 * @param characteristics
	 */
	void setCharacteristics(string characteristics);

	/**
	 * used to supply a SensorMemento.class in response to a caretaker (aka a Sensor.class) request. It contains the current state of the Originator (SensorInfo.class) object.
	 */
	SensorMomento saveState();

	/**
	 * used to restore the originator SensorInfo.class to a previous state. This state is contained in a SensorMemento.class (that comes as a method argument) from the caretaker Sensor.class. A caretaker Sensor.class sends this SensorMemento object that it saved earlier.
	 * @param sensorMomento
	 */
	void restoreState(SensorMomento sensorMomento);

	/**
	 * set a new state of an originator SensorInfo.
	 * @param newState
	 */
	void setState(SensorInfo newState);

}