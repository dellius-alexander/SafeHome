package ControlPanel;

public abstract interface KeyPad {

	/**
	 * 
	 * @param keyStrokes
	 */
	abstract void readKeyStrokes(string keyStrokes);

	abstract string decodeKey();

}