package com.example.safehome.Door;

public class PocketDoor implements Door {

	private DoorInfo doorInfo;

	/**
	 * 
	 * @param doorInfo
	 */
	public PocketDoor(DoorInfo doorInfo) {
		// TODO - implement PocketDoor.PocketDoor
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