package com.example.safehome.ControlPanel;

public abstract interface KeyPad {

	/**
	 * 
	 * @param keyStrokes
	 */
	abstract void readKeyStrokes(String keyStrokes);

	abstract String decodeKey();

}