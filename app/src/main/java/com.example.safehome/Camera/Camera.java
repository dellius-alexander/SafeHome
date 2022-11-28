package com.example.safehome.Camera;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Camera {
	private static final Logger log = LoggerFactory.getLogger(Camera.class);

	/**
	 * camera id
	 */
	private String id = null;
	private String type = null;

	/**
	 * camera location
	 */
	private String location = null;
	private String fieldOfView = null;
	private boolean twoWayAudio;
	private boolean nightVision;
	private String resolution = null;

	/**
	 * Defaults to false.
	 */
	private boolean hasPushNotifications = false;
	private String connectivity = null;
	private Camera state;

	/**
	 * Defines the storage object.
	 */
	private Storage storage = null;

	/**
	 * Defines the camera type.
	 * @param type the camera type.
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Saves a new state of the Object.
	 * @param newState the Object state to save
	 */
	public void setState(Camera newState) {
		this.state = newState;
	}

	/**
	 * Retrieve the save state of the Object
	 * @return the saved state of the Object
	 */
	public Camera saveState() {
		return this.state;
	}

	/**
	 * Create a restore state from the CameraMomento.
	 * @param cameraMomemto the saved state of an Object.
	 */
	public void restoreState(CameraMomento cameraMomemto) {
		// TODO - implement Camera.restoreState
//		throw new UnsupportedOperationException();
	}
}