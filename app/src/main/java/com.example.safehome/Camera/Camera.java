package com.example.safehome.Camera;

public class Camera {

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

	public void setType(String type) {
		this.type = type;
	}

	public void setState(Camera state) {
		this.state = state;
	}

	public Camera saveState() {
		// TODO - implement Camera.saveState
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param cameraMomemto
	 */
	public void restoreState(CameraMomemto cameraMomemto) {
		// TODO - implement Camera.restoreState
		throw new UnsupportedOperationException();
	}

}