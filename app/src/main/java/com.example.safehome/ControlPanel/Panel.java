package ControlPanel;

public interface Panel extends KeyPad {

	abstract boolean displayStatus();

	/**
	 * 
	 * @param mode
	 */
	abstract boolean darkMode(string mode);

	/**
	 * 
	 * @param msg
	 */
	abstract boolean sendControlMsg(string msg);

}