package com.example.safehome.ControlPanel;

public interface Panel extends KeyPad {

	abstract boolean displayStatus();

	/**
	 * 
	 * @param mode
	 */
	abstract boolean darkMode(String mode);

	/**
	 * 
	 * @param msg
	 */
	abstract boolean sendControlMsg(String msg);

}