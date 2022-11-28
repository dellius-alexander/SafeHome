package com.example.safehome.System;

/**
 * Represents the Security system
 */
public interface ISystem {

	/**
	 * initializes some screen or object to enable you to program the system. This could be an admin function.
	 */
	void program();

	/**
	 * displays the system information
	 */
	void display();

	/**
	 * resets the system and returns true upon completion.
	 */
	boolean reset();

	/**
	 * 
	 * @param queryString
	 */
	String query(String queryString);

	/**
	 * arm the system
	 */
	boolean arm();

	/**
	 * disarm the system
	 */
	boolean disarm();

	/**
	 * Arm the system
	 * @return
	 */
	boolean isArmed();

}