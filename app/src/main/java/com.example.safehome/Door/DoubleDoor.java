package com.example.safehome.Door;

public class DoubleDoor implements Door {

	private DoorInfo doorInfo;

	/**
	 * 
	 * @param doorInfo
	 */
	public DoubleDoor(DoorInfo doorInfo) {
		// TODO - implement DoubleDoor.DoubleDoor
		throw new UnsupportedOperationException();
	}

	/**
	 * detects whether an event has occurred
	 */
	@Override
	public DType determineType() {
		return null;
	}

	/**
	 * identifies the type of door
	 */
	@Override
	public void identify() {

	}

	/**
	 * enables notifications
	 */
	@Override
	public void enableNotification() {

	}

	/**
	 * disables notifications
	 */
	@Override
	public void disableNotification() {

	}

	/**
	 * reconfigures door
	 */
	@Override
	public void reconfigure() {

	}

	/**
	 * adds door to system
	 */
	@Override
	public void addSensorMomento() {

	}

	/**
	 * gets existing door from system
	 */
	@Override
	public void getSensorMomento() {

	}
}