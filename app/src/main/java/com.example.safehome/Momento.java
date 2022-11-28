package com.example.safehome;

public interface Momento<Object> {
	/**
	 * Retrieves the state of the saved state of the Camera state.
	 * @return the saved Object state
	 */
	Object getState();

	/**
	 * Saves the state of the Camera object.
	 * @param state the state the object
	 */
	void setState(Object state);

}