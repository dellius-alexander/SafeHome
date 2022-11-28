package com.example.safehome.Door;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SlidingDoor implements Door {
	private static final Logger log = LoggerFactory.getLogger(SlidingDoor.class);
	private DoorInfo doorInfo;

	/**
	 * 
	 * @param doorInfo
	 */
	public SlidingDoor(DoorInfo doorInfo) {
		// TODO - implement SlidingDoor.SlidingDoor
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