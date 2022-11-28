package com.example.safehome.Sensors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class WindowSensor implements Sensor {
	private static final Logger log = LoggerFactory.getLogger(WindowSensor.class);
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