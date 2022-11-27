package com.example.safehome.ControlPanel;

import com.example.safehome.Momento;

/**
 * Saves the current state of the {@linkplain ControlPanel} object.
 */
public class ControlPanelMomento implements Momento<ControlPanel> {

	private ControlPanel state;

	/**
	 * Do not implement constructor
	 * @param state the current state of the {@linkplain ControlPanel}
	 */
	public ControlPanelMomento(ControlPanel state) {
		this.state = state;
	}
	/**
	 * Retrieves the state of the saved state of the Camera state.
	 * @return  the current state of the {@linkplain ControlPanel}
	 */
	@Override
	public ControlPanel getState() {
		return this.state;
	}

	/**
	 * Saves the state of the Camera object.
	 * @param state  the current state of the {@linkplain ControlPanel}
	 */
	@Override
	public void setState(ControlPanel state) {
		this.state = state;
	}
}