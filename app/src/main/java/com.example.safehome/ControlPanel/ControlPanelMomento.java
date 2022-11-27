package com.example.safehome.ControlPanel;

import com.example.safehome.Momento;

public class ControlPanelMomento implements Momento<ControlPanel> {

	private ControlPanel state;

	/**
	 * 
	 * @param state
	 */
	public ControlPanelMomento(ControlPanel state) {
		// TODO - implement ControlPanelMomento.ControlPanelMomento
		throw new UnsupportedOperationException();
	}

	/**
	 * Retrieves the state of the saved state of the Camera state.
	 *
	 * @return the saved Object state
	 */
	@Override
	public ControlPanel getState() {
		return null;
	}

	/**
	 * Saves the state of the Camera object.
	 *
	 * @param state the state the object
	 */
	@Override
	public void setState(ControlPanel state) {

	}
}