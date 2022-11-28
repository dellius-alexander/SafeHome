package com.example.safehome.ControlPanel;

/**
 * Abstract Panel for the {@linkplain ControlPanel} class.
 */
public interface Panel extends KeyPad {
	/**
	 * Defines the display status. True if display is available,
	 * false otherwise.
	 * @return {@literal boolean}
	 */
	boolean displayStatus();
	/**
	 * Defines the screen mode to dark mode.
	 * @param mode the mode definition string to define the mode.
	 * @return {@literal boolean}
	 */
	boolean darkMode(String mode);

	/**
	 * Sends a control message to initiate a task.
	 * @param msg the message string
	 * @return {@literal boolean}
	 */
	boolean sendControlMsg(String msg);

}