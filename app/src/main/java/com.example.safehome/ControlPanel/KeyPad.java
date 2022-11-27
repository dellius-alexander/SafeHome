package com.example.safehome.ControlPanel;

/**
 * Represents user input
 */
public interface KeyPad {

	/**
	 * Defines the input from terminal, screen or key pad
	 * @param keyStrokes the {@literal String} keyStroke input.
	 */
	void readKeyStrokes(String keyStrokes);
	/**
	 * Decodes keystroke to to utf-8 encoding
	 * @return the decoded key {@literal String} value
	 */
	String decodeKey();
}