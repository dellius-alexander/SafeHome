package com.example.safehome.ControlPanel;

public interface KeyPad {

	/**
	 * Defines the input from terminal, screen or key pad
	 * @param keyStrokes
	 */
	void readKeyStrokes(String keyStrokes);

	String decodeKey();

}