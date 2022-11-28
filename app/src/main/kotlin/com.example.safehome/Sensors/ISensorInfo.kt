package com.example.safehome.Sensors;

public interface ISensorInfo {

	String toString();

	String getName();

	/**
	 * 
	 * @param name
	 */
	void setName(String name);

	SType getType();

	/**
	 * 
	 * @param type
	 */
	void setType(String type);

	String getLocation();

	/**
	 * 
	 * @param location
	 */
	void setLocation(String location);

	String getArea();

	/**
	 * 
	 * @param area
	 */
	void setArea(String area);

	String getCharacteristics();

	/**
	 * 
	 * @param characteristics
	 */
	void setCharacteristics(String characteristics);

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

	String getConfiguration();
}