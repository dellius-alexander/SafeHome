package com.example.safehome.Camera;
/**
 * Defines the type of camera used in the security system.
 */
public interface AbstractCamera {

	String id();

	/**
	 * Defines the type of camera used in the security system.
	 */
	String type();

	/**
	 * The location of the camera.
	 */
	String location();

	/**
	 * What is the field of view of the camera:
	 * 
	 * 160 Degrees
	 * 140 Degrees
	 * 130 Degrees
	 * and so on...
	 */
	String fieldOfView();

	/**
	 * Does the camera have two-way audio functionality.
	 */
	boolean twoWayAudio();

	/**
	 * Does the camera have night vision capabilities.
	 */
	boolean nightVision();

	/**
	 * what is the resolution of the camera:
	 * 720P
	 * 10800P
	 * 2K
	 * 4K
	 */
	String resolution();

	/**
	 * Does the camera have push notifications functionality.
	 */
	boolean hasPushNotifications();

	/**
	 * What type of network connectivity function does the camera have?
	 * 
	 * Type of connectivity:
	 * Wifi
	 * Ethernet
	 * and so on...
	 */
	String connectivity();

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
	Storage storage();

}