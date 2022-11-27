package com.example.safehome.Camera;
/**
 * Defines the type of camera used in the security system.
 */
public interface AbstractCamera {

	String id();

	/**
	 * Defines the type of camera used in the security system.
	 */
	String type() {
		// TODO - implement AbstractCamera.type
		throw new UnsupportedOperationException();
	}

	/**
	 * The location of the camera.
	 */
	String location() {
		// TODO - implement AbstractCamera.location
		throw new UnsupportedOperationException();
	}

	/**
	 * What is the field of view of the camera:
	 * 
	 * 160 Degrees
	 * 140 Degrees
	 * 130 Degrees
	 * and so on...
	 */
	String fieldOfView() {
		// TODO - implement AbstractCamera.fieldOfView
		throw new UnsupportedOperationException();
	}

	/**
	 * Does the camera have two-way audio functionality.
	 */
	boolean twoWayAudio() {
		// TODO - implement AbstractCamera.twoWayAudio
		throw new UnsupportedOperationException();
	}

	/**
	 * Does the camera have night vision capabilities.
	 */
	boolean nightVision() {
		// TODO - implement AbstractCamera.nightVision
		throw new UnsupportedOperationException();
	}

	/**
	 * what is the resolution of the camera:
	 * 720P
	 * 10800P
	 * 2K
	 * 4K
	 */
	String resolution() {
		// TODO - implement AbstractCamera.resolution
		throw new UnsupportedOperationException();
	}

	/**
	 * Does the camera have push notifications functionality.
	 */
	boolean hasPushNotifications() {
		// TODO - implement AbstractCamera.hasPushNotifications
		throw new UnsupportedOperationException();
	}

	/**
	 * What type of network connectivity function does the camera have?
	 * 
	 * Type of connectivity:
	 * Wifi
	 * Ethernet
	 * and so on...
	 */
	String connectivity() {
		// TODO - implement AbstractCamera.connectivity
		throw new UnsupportedOperationException();
	}

	/**
	 * Defines the storage type class used to persist video capture.
	 * 
	 * Types include:
	 * Cloud storage
	 * Flash storage
	 * NFS storage
	 * Local storage: connected to NVR
	 * and so on...
	 */
	Storage storage() {
		// TODO - implement AbstractCamera.storage
		throw new UnsupportedOperationException();
	}

}