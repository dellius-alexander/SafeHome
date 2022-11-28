package com.example.safehome.Sensors;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class DoorSensor implements Sensor {
	private static final Logger log = LoggerFactory.getLogger(DoorSensor.class);
	private List<SensorMomento>[] sensorMomentoList;
	private SensorInfo state;

	/**
	 * detects whether an event has occurred
	 */
	@Override
	public boolean isEventDectected() {
		return false;
	}

	/**
	 * identifies the type of sensor
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
	 * reconfigures sensor
	 */
	@Override
	public void reconfigure() {

	}

	/**
	 * adds sensor to system
	 */
	@Override
	public void addSensorMomento() {

	}

	/**
	 * gets existing sensor from system
	 */
	@Override
	public void getSensorMomento() {

	}
}